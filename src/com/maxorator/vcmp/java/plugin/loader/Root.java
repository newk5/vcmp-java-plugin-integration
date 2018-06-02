package com.maxorator.vcmp.java.plugin.loader;

import java.lang.reflect.InvocationTargetException;
import java.net.URLClassLoader;

@SuppressWarnings("unused")
public class Root {
    private static final int PLUGIN_MAJOR_VERSION = 2;

    public static boolean seed(int pluginMajorVersion, String libName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (pluginMajorVersion != PLUGIN_MAJOR_VERSION) {
            throw new RuntimeException("Invalid plugin version: required " + PLUGIN_MAJOR_VERSION + ", detected " + pluginMajorVersion + ".");
        }

        URLClassLoader currentUrlLoader = (URLClassLoader) Root.class.getClassLoader();
        SeedLoader seedLoader = new SeedLoader(currentUrlLoader.getURLs());

        Class<?> seedClass = seedLoader.loadSeed();
        Thread.currentThread().setContextClassLoader(seedLoader);
        return (Boolean)seedClass.getMethod("activateWrapper", String.class).invoke(null, libName);
    }

    public static void restoreClassLoader() {
        Thread.currentThread().setContextClassLoader(Root.class.getClassLoader());
    }
}
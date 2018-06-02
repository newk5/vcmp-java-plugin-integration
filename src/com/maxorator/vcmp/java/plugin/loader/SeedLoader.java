package com.maxorator.vcmp.java.plugin.loader;

import java.net.URL;
import java.net.URLClassLoader;

public class SeedLoader extends URLClassLoader {
    public SeedLoader(URL[] urls) {
        super(urls, new NoopLoader());
    }

    public Class<?> loadSeed() throws ClassNotFoundException {
        return loadClass("com.maxorator.vcmp.java.plugin.loader.Seed", true);
    }

    @Override
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        try {
            return super.loadClass(className, resolve);
        } catch (ClassNotFoundException e) {
            return Class.forName(className);
        }
    }
}

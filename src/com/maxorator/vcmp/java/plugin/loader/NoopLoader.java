package com.maxorator.vcmp.java.plugin.loader;

public class NoopLoader extends ClassLoader {
    @Override
    protected Class<?> loadClass(String name, boolean resolve) {
        return null;
    }
}

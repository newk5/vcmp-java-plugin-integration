package com.maxorator.vcmp.java.plugin.loader;

@SuppressWarnings("unused")
public class Seed {
    private static String formatLibName(String rawLibName) {
        if (rawLibName.startsWith("lib") && rawLibName.endsWith(".so")) {
            return rawLibName.substring(3, rawLibName.length() - 3);
        } else if (rawLibName.endsWith(".dll")) {
            return rawLibName.substring(0, rawLibName.length() - 4);
        } else {
            return rawLibName;
        }
    }

    public static boolean activateWrapper(String libName) {
        System.loadLibrary(formatLibName(libName));
        return activate();
    }

    public static native boolean activate();
}

package com.maxorator.vcmp.java.plugin.exceptions;

@SuppressWarnings("unused")
public class ThreadSafetyException extends RuntimeException {
    public ThreadSafetyException(String message) {
        super(message);
    }
}

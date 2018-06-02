package com.maxorator.vcmp.java.plugin.exceptions;

@SuppressWarnings("unused")
public class DeadEntityException extends RuntimeException {
    public DeadEntityException(String message) {
        super(message);
    }
}

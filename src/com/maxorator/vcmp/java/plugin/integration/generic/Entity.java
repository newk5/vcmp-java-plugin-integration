package com.maxorator.vcmp.java.plugin.integration.generic;

@SuppressWarnings("unused")
public interface Entity {
    int getId();

    boolean isValid();

    void setData(String name, Object value);

    <T> T getData(String name, Class<T> klass);
    
    void clearData();
}

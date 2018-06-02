package com.maxorator.vcmp.java.plugin.integration.generic;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public abstract class EntityImpl implements Entity {

    public int id;
    private final Object sync;
    private Map<String, Object> data;

    protected EntityImpl(int id) {
        this.id = id;
        this.sync = new Object();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isValid() {
        return id >= 0;
    }

    @Override
    public void setData(String name, Object value) {
        synchronized (sync) {
            if (data == null) {
                data = new HashMap<>();
            }
            data.put(name, value);
        }
    }

    @Override
    public void clearData() {
        synchronized (sync) {
            if (data != null) {
                this.data.clear();
            }
        }
    }

    @Override
    public <T> T getData(String name, Class<T> klass) {
        synchronized (sync) {
            if (data == null) {
                return null;
            }

            Object value = data.get(name);

            if (klass.isInstance(value)) {
                return (T) value;
            }
            return null;
        }
    }
}

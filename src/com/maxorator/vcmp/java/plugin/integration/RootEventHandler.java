package com.maxorator.vcmp.java.plugin.integration;

import com.maxorator.vcmp.java.plugin.integration.server.Server;
import com.maxorator.vcmp.java.plugin.integration.server.ServerImpl;

@SuppressWarnings("unused")
public abstract class RootEventHandler extends AbstractEventHandler {
    public final Server server;
    private final ServerImpl impl;

    public RootEventHandler(Server server) {
        this.server = server;
        this.impl = (ServerImpl) server;
    }

    private void onServerUnloadScriptsInternal() {
        onServerUnloadScripts();

        impl.setUnloaded();
    }

    private void onServerFrameInternal() {
        impl.runSyncBlocks();

        onServerFrame();
    }
}

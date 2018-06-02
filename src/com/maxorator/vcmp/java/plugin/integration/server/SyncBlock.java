package com.maxorator.vcmp.java.plugin.integration.server;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SyncBlock implements AutoCloseable {
    private final CountDownLatch start;
    private final CountDownLatch finish;
    private final ServerImpl server;

    public SyncBlock(ServerImpl server) {
        this.server = server;
        start = new CountDownLatch(1);
        finish = new CountDownLatch(1);
    }

    public boolean waitForSync() throws InterruptedException {
        if (start.await(100, TimeUnit.MILLISECONDS)) {
            server.startThreadSynced();
            return true;
        }
        return false;
    }

    public void start() {
        start.countDown();
    }

    public void waitForFinish() throws InterruptedException {
        finish.await();
    }

    @Override
    public void close() throws Exception {
        server.endThreadSynced();
        finish.countDown();
    }
}

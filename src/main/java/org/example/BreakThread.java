package org.example;

public class BreakThread implements Runnable {
    private boolean canBreak = false;
    private final int delayInSeconds;

    public BreakThread(int delayInSeconds) {
        this.delayInSeconds = delayInSeconds;
    }

    public synchronized boolean isCanBreak() {
        return canBreak;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delayInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        canBreak = true;
    }
}


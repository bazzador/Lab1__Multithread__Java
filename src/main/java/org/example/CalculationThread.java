package org.example;

public class CalculationThread extends Thread {
    private final int id;
    private final BreakThread breakThread;
    private final int stepValue;

    public CalculationThread(int id, BreakThread breakThread, int stepValue) {
        this.id = id;
        this.breakThread = breakThread;
        this.stepValue = stepValue;
    }

    @Override
    public void run() {
        long sum = 0;
        long count = 0;
        while (!breakThread.isCanBreak()) {
            sum += stepValue;
            count++;
        }
        System.out.println("id: " + id + " Sum: " + sum + " Count: " + count);
    }
}

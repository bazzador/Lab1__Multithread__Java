package org.example;

import org.example.BreakThread;
import org.example.CalculationThread;

public class Main {

    private static void launchCalculations(int numberOfThreads, int delayInSeconds, int stepValue) {
        BreakThread breakThread = new BreakThread(delayInSeconds);
        Thread breakThreadRunner = new Thread(breakThread);
        breakThreadRunner.start();

        for (int i = 0; i < numberOfThreads; i++) {
            new CalculationThread(i, breakThread, stepValue).start();
        }
    }

    public static void main(String[] args) {
        int numberOfThreads = 6;
        int timeToWork = 2;
        int stepValue = 2;
        System.out.println("Кількість потоків: " + numberOfThreads);
        launchCalculations(numberOfThreads, timeToWork, stepValue);
    }
}

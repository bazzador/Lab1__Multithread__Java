package org.example;

import org.example.BreakThread;
import org.example.CalculationThread;

import java.util.Scanner;

public class Main {

    private static void launchCalculations(int numberOfThreads, int[] timeToWork, int[] stepValue) {
        for (int i = 0; i < numberOfThreads; i++) {
            BreakThread breakThread = new BreakThread(timeToWork[i]);
            new Thread(breakThread).start();
            new CalculationThread(i, breakThread, stepValue[i]).start();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість потоків: ");
        int numberOfThreads = scanner.nextInt();
        scanner.nextLine();

        int[] timeToWork = new int[numberOfThreads];
        int[] stepValue = new int[numberOfThreads];

        System.out.println("Введіть " + numberOfThreads + " значень для timeToWork (через пробіл):");
        String[] timeInput = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < numberOfThreads; i++) {
            timeToWork[i] = Integer.parseInt(timeInput[i]);
        }

        System.out.println("Введіть " + numberOfThreads + " значень для stepValue (через пробіл):");
        String[] stepInput = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < numberOfThreads; i++) {
            stepValue[i] = Integer.parseInt(stepInput[i]);
        }

        System.out.println("Введені значення:");
        for (int i = 0; i < numberOfThreads; i++) {
            System.out.println("Потік " + (i + 1) + ": timeToWork = " + timeToWork[i] + ", stepValue = " + stepValue[i]);
        }

        scanner.close();
        launchCalculations(numberOfThreads, timeToWork, stepValue);
    }
}

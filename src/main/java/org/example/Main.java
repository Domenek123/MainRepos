package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_SIZE = 20; // Максимальний розмір матриці
    private static final int MIN_RANDOM = -50; // Мінімальне рандомне значення
    private static final int MAX_RANDOM = 50;  // Максимальне рандомне значення
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = getMatrixSize("Введіть кількість рядків (не більше 20): ");
        int cols = getMatrixSize("Введіть кількість стовпців (не більше 20): ");

        int[][] matrix = chooseMatrixCreationMethod(rows, cols);

        System.out.println("Згенерована матриця:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double avg = calculateAverage(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + avg);
    }

    private static int getMatrixSize(String message) {
        int size;
        do {
            System.out.print(message);
            size = scanner.nextInt();
        } while (size <= 0 || size > MAX_SIZE);
        return size;
    }

    private static int[][] chooseMatrixCreationMethod(int rows, int cols) {
        System.out.println("Оберіть спосіб заповнення матриці:");
        System.out.println("1 - Вручну");
        System.out.println("2 - Рандомно");
        int choice;
        do {
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);

        return (choice == 1) ? fillMatrixManually(rows, cols) : fillMatrixRandomly(rows, cols);
    }

    private static int[][] fillMatrixManually(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Елемент [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixRandomly(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = MIN_RANDOM + random.nextInt(MAX_RANDOM - MIN_RANDOM + 1);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }
}

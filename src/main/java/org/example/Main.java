package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Вводимо розмір матриці
        System.out.print("Введіть кількість строчок (не більше 20): ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовбців (не більше 20): ");
        int cols = scanner.nextInt();

        if (rows > 20 || cols > 20 || rows <= 0 || cols <= 0) {
            System.out.println("Помилка! Неправильний розмір матриці!");
            return;
        }

        // Обираем спосіб заповнення
        System.out.println("Оберіть спосіб заповнення: 1 - вручну, 2 - випадковими числами");
        int choice = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        if (choice == 1) {
            System.out.println("Введіть елементи матриці:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = random.nextInt(101) - 50; // від -50 до 50
                }
            }
        }

        // Вивід матриці
        System.out.println("Матриця:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Знаходемо мінімум, максимум і середне
        int min = matrix[0][0], max = matrix[0][0], sum = 0;
        int count = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int num = matrix[i][j];
                if (num < min) min = num;
                if (num > max) max = num;
                sum += num;
            }
        }

        double avg = (double) sum / count;

        // Выводим результаты
        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальный елемент: " + max);
        System.out.println("Середне арифметичне: " + avg);

        scanner.close();
    }
}

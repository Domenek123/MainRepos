package Lab_2;

import java.util.Random;//Імпорт рандомайзера
import java.util.Scanner;//Імпорт сканера

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int MaxRand=50;
        int MinRand=-50;
        int rows = getSize(scanner, "строчок");// отримуем кількість строчок
        int cols = getSize(scanner, "стовбців");// отримуєм кількість стовпців

        if (rows <= 0 || rows > 20 || cols <= 0 || cols > 20) {//Перевіряемо чи матриція не більше 20 символів
            System.out.println("Помилка! Неправильний розмір матриці!");
            return;
        }

        int[][] matrix = new int[rows][cols];//Створюєм матрицю розміром Стр. * Стовп,
        fillMatrix(scanner, random, matrix,MaxRand,MinRand);//Заповнюєм матрицю
        printMatrix(matrix);//Виводим матрицю
        printStats(matrix);//виводим розраховані Макс. Мін. та Сер. значеня
    }

    private static int getSize(Scanner scanner, String type) {//Функція яка отримуе данні та повертае їх
        System.out.print("Введіть кількість " + type + " (не більше 20): ");// функція запрошуе від користувача значення
        return scanner.nextInt();// функція отримуе та повертае значення від користувача
    }

    private static void fillMatrix(Scanner scanner, Random random, int[][] matrix, int max, int min) {//Функція яка заповнює матрицю
        System.out.println("Оберіть спосіб заповнення: 1 - вручну, 2 - випадковими числами");
        int choice = scanner.nextInt();//вибір користувача

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //              якщо обрав 1   Отримуем значення, інакше отримуем рандомне значення
                matrix[i][j] = (choice == 1) ? scanner.nextInt() : random.nextInt(max-min+1)+min;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {//Функція яка виводить матрицю
        System.out.println("Матриця:");
        for (int[] row : matrix) {//Для кожної строки
            for (int num : row) {// для кождного чисал в строці
                System.out.print(num + "\t");//Вивести число
            }
            System.out.println();//почати нову строчку
        }
    }

    private static void printStats(int[][] matrix) {//Функція яка знаходить та виводе макс. мін. та сер. значення
        int min = matrix[0][0], max = matrix[0][0], sum = 0;
        int count = matrix.length * matrix[0].length;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) min = num;//пошук мінімального
                if (num > max) max = num;//пошук максимального
                sum += num;//сумма всих чисел 2
            }
        }

        System.out.println("Мінімальний елемент: " + min);//Вивід мінімального
        System.out.println("Максимальний елемент: " + max);//вивиід максимального
        System.out.println("Середнє арифметичне: " + (double) sum / count);//розрахунок та вивід середнього арифметичного
    }
}

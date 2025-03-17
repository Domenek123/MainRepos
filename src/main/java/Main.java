import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        System.out.println("Введіть номер місяця (1-12), щоб знайти студентів, які народилися в цьому місяці:");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Некоректний номер місяця!");
            return;
        }

        List<Student> students = studentDAO.getStudentsByMonth(month);

        if (students.isEmpty()) {
            System.out.println("Немає студентів, які народилися у цьому місяці.");
        } else {
            students.forEach(System.out::println);
        }
    }
}

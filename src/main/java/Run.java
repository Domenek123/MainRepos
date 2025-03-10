import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private String recordBookNumber;

    public Student(int id, String lastName, String firstName, String middleName, Date birthDate, String recordBookNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + firstName + ' ' + middleName + ' ' + lastName + '\'' +
                ", BirthDate=" + birthDate +
                ", RecordBookNumber='" + recordBookNumber + '\'' +
                '}';
    }
}

public class StudentDatabaseApp {
    private static final String URL = "jdbc:postgresql://localhost:5432/students_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "yourpassword";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter birth month (1-12): ");
        int month = scanner.nextInt();
        scanner.close();

        List<Student> students = getStudentsByMonth(month);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static List<Student> getStudentsByMonth(int month) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE EXTRACT(MONTH FROM birth_date) = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, month);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getDate("birth_date"),
                        rs.getString("record_book_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

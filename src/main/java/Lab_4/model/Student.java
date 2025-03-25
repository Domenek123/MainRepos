package Lab_4.model;

public class Student extends Human {
    // Конструктор за замовчуванням (необхідний для Gson)
    public Student() {}

    public Student(String firstName, String lastName, String patronymic, Sex sex) {
        super(firstName, lastName, patronymic, sex);
    }
}
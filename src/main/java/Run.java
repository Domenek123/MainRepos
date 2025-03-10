import controller.*;
import model.*;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        University university = run.createTypicalUniversity();
        System.out.println(university);
    }

    public University createTypicalUniversity() {
        // Створення голови університету
        Human universityHead = new Human("Іван", "Петров", "Іванович", Sex.MALE) {};

        // Створення університету
        UniversityCreator universityCreator = new UniversityCreator();
        University university = universityCreator.createUniversity("Національний Університет", universityHead);

        // Створення факультету
        Human facultyHead = new Human("Олена", "Сидорова", "Олексіївна", Sex.FEMALE) {};
        FacultyCreator facultyCreator = new FacultyCreator();
        Faculty faculty = facultyCreator.createFaculty("Факультет інформаційних технологій", facultyHead);
        university.addFaculty(faculty);

        // Створення кафедри
        Human departmentHead = new Human("Андрій", "Коваленко", "Володимирович", Sex.MALE) {};
        DepartmentCreator departmentCreator = new DepartmentCreator();
        Department department = departmentCreator.createDepartment("Кафедра програмного забезпечення", departmentHead);
        faculty.addDepartment(department);

        // Створення групи
        Human groupHead = new Human("Марія", "Іванова", "Петрівна", Sex.FEMALE) {};
        GroupCreator groupCreator = new GroupCreator();
        Group group = groupCreator.createGroup("Група ПЗ-21", groupHead);
        department.addGroup(group);

        // Створення студентів
        StudentCreator studentCreator = new StudentCreator();
        Student student1 = studentCreator.createStudent("Олексій", "Семенов", "Олександрович", Sex.MALE);
        Student student2 = studentCreator.createStudent("Наталія", "Коваль", "Ігорівна", Sex.FEMALE);
        group.addStudent(student1);
        group.addStudent(student2);

        return university;
    }
}
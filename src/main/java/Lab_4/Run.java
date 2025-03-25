package Lab_4;

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
        Human universityHead = new Human("Іван", "Петров", "Іванович", Sex.MALE);

        // Створення університету
        UniversityCreator universityCreator = new UniversityCreator();
        University university = universityCreator.createUniversity("Національний Університет", universityHead);

        // Створення факультетів
        Human facultyHead1 = new Human("Олена", "Сидорова", "Олексіївна", Sex.FEMALE);
        Human facultyHead2 = new Human("Андрій", "Коваленко", "Володимирович", Sex.MALE);
        FacultyCreator facultyCreator = new FacultyCreator();
        Faculty faculty1 = facultyCreator.createFaculty("Факультет інформаційних технологій", facultyHead1);
        Faculty faculty2 = facultyCreator.createFaculty("Факультет математики", facultyHead2);
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        // Створення кафедр для кожного факультету
        Human departmentHead1 = new Human("Марія", "Іванова", "Петрівна", Sex.FEMALE);
        Human departmentHead2 = new Human("Олексій", "Семенов", "Олександрович", Sex.MALE);
        DepartmentCreator departmentCreator = new DepartmentCreator();
        Department department1 = departmentCreator.createDepartment("Кафедра програмного забезпечення", departmentHead1);
        Department department2 = departmentCreator.createDepartment("Кафедра математичного аналізу", departmentHead2);
        faculty1.addDepartment(department1);
        faculty2.addDepartment(department2);

        // Створення груп для кожної кафедри
        Human groupHead1 = new Human("Наталія", "Коваль", "Ігорівна", Sex.FEMALE);
        Human groupHead2 = new Human("Олег", "Петренко", "Володимирович", Sex.MALE);
        GroupCreator groupCreator = new GroupCreator();
        Group group1 = groupCreator.createGroup("Група ПЗ-21", groupHead1);
        Group group2 = groupCreator.createGroup("Група МА-22", groupHead2);
        department1.addGroup(group1);
        department2.addGroup(group2);

        // Створення студентів для кожної групи
        StudentCreator studentCreator = new StudentCreator();
        Student student1 = studentCreator.createStudent("Олексій", "Семенов", "Олександрович", Sex.MALE);
        Student student2 = studentCreator.createStudent("Наталія", "Коваль", "Ігорівна", Sex.FEMALE);
        group1.addStudent(student1);
        group1.addStudent(student2);

        Student student3 = studentCreator.createStudent("Ірина", "Петренко", "Олегівна", Sex.FEMALE);
        Student student4 = studentCreator.createStudent("Володимир", "Іванов", "Олександрович", Sex.MALE);
        group2.addStudent(student3);
        group2.addStudent(student4);

        return university;
    }
}
package model;


import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private Human head;
    private List<Student> students;

    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Group: " + name + ", Head: " + head + ", Students: " + students;
    }
}
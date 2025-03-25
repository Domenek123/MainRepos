package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private Human head;
    private List<Group> groups;

    // Конструктор за замовчуванням (необхідний для Gson)
    public Department() {
        this.groups = new ArrayList<>();
    }

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        this.groups = new ArrayList<>();
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }

    @Override
    public String toString() {
        return "Department: " + name + ", Head: " + head + ", Groups: " + groups;
    }
}
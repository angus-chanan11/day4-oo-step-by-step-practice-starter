package oo;

import java.util.List;

public class School {
    private List<Student> students;
    private List<Teacher> teachers;

    public School(List<Student> students, List<Teacher> teachers) {
        this.students = students;
        this.teachers = teachers;
    }

    public void startSchool() {
        students.stream().forEach(student -> System.out.printf(student.introduce()));
        teachers.stream().forEach(teacher -> System.out.printf(teacher.introduce()));
    }
}

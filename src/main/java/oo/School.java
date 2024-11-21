package oo;

import java.util.List;
import java.util.stream.Collectors;

public class School {
    private static final String EMPTY_JOINING = "";
    private List<Student> students;
    private List<Teacher> teachers;

    public School(List<Student> students, List<Teacher> teachers) {
        this.students = students;
        this.teachers = teachers;
    }

    public void startSchool() {
        System.out.printf(students.stream()
                .map(Person::introduce)
                .collect(Collectors.joining(EMPTY_JOINING))
        );
        System.out.printf(teachers.stream()
                .map(Person::introduce)
                .collect(Collectors.joining(EMPTY_JOINING))
        );
    }
}

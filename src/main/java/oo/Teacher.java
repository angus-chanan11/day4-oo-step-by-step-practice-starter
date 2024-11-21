package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person{
    private List<Klass> klasses;
    private static final String TEACHER_MESSAGE = "I am a teacher.";

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
        klasses = new ArrayList<>();
    }

    @Override
    public String introduce() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s", super.introduce(), TEACHER_MESSAGE));
        String klassesAsString = klasses.stream()
                .map(klass -> klass.getNumber().toString())
                .collect(Collectors.joining(", "));
        if (!klassesAsString.isEmpty()) {
            builder.append(" I teach Class ")
                    .append(klassesAsString)
                    .append(".");
        }
        return builder.toString();
    }

    public boolean belongsTo(Klass klass) {
        return klasses.contains(klass);
    }

    public void assignTo(Klass klass) {
        if (!belongsTo(klass))
            klasses.add(klass);
    }

    public boolean isTeaching(Student student) {
        return klasses.stream()
                .anyMatch(klass -> klass.equals(student.getKlass()));
    }
}

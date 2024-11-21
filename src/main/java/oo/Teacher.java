package oo;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private List<Klass> klasses;

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
        klasses = new ArrayList<>();
    }

    @Override
    public String introduce() {
        return String.format("%s I am a teacher.", super.introduce());
    }

    public boolean belongsTo(Klass klass) {
        return klasses.contains(klass);
    }
}

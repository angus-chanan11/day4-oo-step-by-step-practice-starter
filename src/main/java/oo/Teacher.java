package oo;

public class Teacher extends Person{
    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a teacher.", name, age);
    }
}

package oo;

public class Student extends Person{
    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return String.format("%s I am a student.", super.introduce());
    }
}

package oo;

public class Student extends Person{
    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return String.format("%s I am a student.", super.introduce());
    }

    public boolean isIn(Klass klass) {
        return this.klass != null &&
                this.klass.equals(klass);
    }
}

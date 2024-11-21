package oo;

public class Student extends Person{
    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s I am a student.", super.introduce()));
        if (klass != null) {
            builder.append(String.format(" I am in class %d.", klass.getNumber()));
        }
        return builder.toString();
    }

    public boolean isIn(Klass klass) {
        return this.klass != null &&
                this.klass.equals(klass);
    }

    public void join(Klass klass) {
        this.klass = klass;
    }
}

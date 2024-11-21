package oo;

public class Student extends Person{
    private Klass klass;
    private static final String STUDENT_MESSAGE = "I am a student.";
    private static final String LEADER_MESSAGE = "I am the leader of class ";
    private static final String LEADER_MESSAGE_END = ".";

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s", super.introduce(), STUDENT_MESSAGE));
        if (klass != null) {
            Integer klassNumber = klass.getNumber();
            if (klass.isLeader(this)){
                builder.append(String.format(" %s%d%s", LEADER_MESSAGE, klassNumber, LEADER_MESSAGE_END));
            } else {
                builder.append(String.format(" I am in class %d.", klassNumber));
            }
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

    public Klass getKlass() {
        return klass;
    }
}

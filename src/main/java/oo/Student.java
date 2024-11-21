package oo;

public class Student extends Person implements KlassObserver{
    private Klass klass;
    private static final String STUDENT_MESSAGE = "I am a student.";
    private static final String LEADER_MESSAGE = "I am the leader of class ";
    private static final String MESSAGE_END = ".";
    private static final String CLASS_MESSAGE = "I am in class ";
    private static final String SPACE = " ";
    private static final String UPDATE_MESSAGE = "I am %s, student of Class %d. I know %s become Leader.";

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%s%s", super.introduce(), SPACE, STUDENT_MESSAGE));
        if (klass != null) {
            Integer klassNumber = klass.getNumber();
            if (klass.isLeader(this)){
                builder.append(String.format("%s%s%d%s", SPACE, LEADER_MESSAGE, klassNumber, MESSAGE_END));
            } else {
                builder.append(String.format("%s%s%d%s", SPACE, CLASS_MESSAGE, klassNumber, MESSAGE_END));
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

    public String getName() {
        return name;
    }

    public void update(Klass klass) {
        System.out.println(String.format(UPDATE_MESSAGE, name, klass.getNumber(), klass.getLeader().getName()));
    }
}

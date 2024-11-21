package oo;

import java.util.Objects;

public class Klass {
    private Integer number;
    private Student leader;

    public Klass(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (anotherObject instanceof Klass anotherKlass)
            return number.equals(anotherKlass.number);
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Integer getNumber() {
        return number;
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    public void assignLeader(Student student) {
        this.leader = student;
    }
}

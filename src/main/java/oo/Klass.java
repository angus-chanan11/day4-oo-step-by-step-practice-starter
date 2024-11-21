package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private Integer number;
    private Student leader;
    private List<KlassObserver> klassObservers;

    private static final String ASSIGN_LEADER_ERROR = "It is not one of us.";

    public Klass(Integer number) {
        this.number = number;
        klassObservers = new ArrayList<>();
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
        if (student.isIn(this)) {
            this.leader = student;
            klassObservers.stream().forEach(klassObserver -> klassObserver.update(this));
        }
        else {
            System.out.println(ASSIGN_LEADER_ERROR);
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void attach(KlassObserver klassObserver) {
        klassObservers.add(klassObserver);
    }
}

package oo;

import java.util.Objects;

public class Klass {
    private Integer number;

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
}

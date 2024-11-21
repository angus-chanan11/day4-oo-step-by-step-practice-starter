package oo;

import java.util.Objects;

public class Person {
    private int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (anotherObject instanceof Person anotherPerson)
            return id == anotherPerson.id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

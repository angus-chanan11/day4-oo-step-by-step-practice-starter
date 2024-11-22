package oo;

import java.util.Objects;

public class Person implements KlassObserver {
    private static final String INTRODUCE_MESSAGE = "My name is %s. I am %d years old.";
    private Integer id;
    protected String name;
    protected Integer age;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format(INTRODUCE_MESSAGE, name, age);
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (anotherObject instanceof Person anotherPerson)
            return id.equals(anotherPerson.id);
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void update(Klass klass) {}
}

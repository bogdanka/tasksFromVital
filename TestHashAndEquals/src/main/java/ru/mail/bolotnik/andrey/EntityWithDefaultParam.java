package ru.mail.bolotnik.andrey;

/**
 * Created by dron on 09.04.2018.
 */
public class EntityWithDefaultParam {

    private final int id;
    private String name;
    private String surname;

    public EntityWithDefaultParam(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }



    @Override
    public String toString() {
        return "EntityWithDefaultParam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

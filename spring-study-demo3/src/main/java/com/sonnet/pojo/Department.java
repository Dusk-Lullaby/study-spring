package com.sonnet.pojo;

public class Department {

    private Integer id;
    private String name;
    private String location;

    public Department() {}

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Department(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}

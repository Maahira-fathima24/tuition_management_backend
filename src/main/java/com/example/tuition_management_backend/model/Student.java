package com.example.tuition_management_backend.model;

public class Student {

    private Long id;
    private String name ;
    private String classLevel;

    public Student() {
    }

    public Student(Long id, String name, String classLevel) {
        this.id = id;
        this.name = name;
        this.classLevel = classLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }
}

package com.deiaa.hellospring.models;

import java.util.Objects;

public class Student {
    private int id;
    private String FirstName;
    private String LastName;
    private String Date;
    private boolean isActive;
    private String teacher;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String date, boolean isActive) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Date = date;
        this.isActive = isActive;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Date='" + Date + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}


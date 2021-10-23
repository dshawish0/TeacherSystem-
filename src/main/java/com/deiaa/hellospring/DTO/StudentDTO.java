package com.deiaa.hellospring.DTO;

public class StudentDTO {
    private String FirstName="Deiaa";
    private String LastName ="Alshawish";
    private String Date="16/06/2001";
    private boolean isActive=true;

    @Override
    public String toString() {
        return "StudentDTO{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Date='" + Date + '\'' +
                ", isActive=" + isActive +
                '}';
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

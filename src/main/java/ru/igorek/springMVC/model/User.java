package ru.igorek.springMVC.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


public class User {
    private int id;

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters long")
    private String name;

    @NotEmpty(message = "Surname can not be empty")
    @Size(min = 2, max = 100, message = "Surname must be between 2 and 100 characters long")
    private String surname;

    @Min(value = 1900, message = "The year of birth must be greater than 1900")
    @NotNull(message = "Year of birthday can not be empty")
    private Integer yearOfBirth;

    public User() {

    }

    public User(String fullName, int yearOfBirth) {
        this.name = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(yearOfBirth, user.yearOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, yearOfBirth);
    }
}

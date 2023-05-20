package ru.igorek.springMVC.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Book {
    private int id;
    @Size(min = 2, max = 50, message = "Tittle can not be longer than 50 characters")
    private String title;
    @Size(min = 2, max = 50, message = "Author name can not be longer than 50 characters")
    private String author;
    @Max(value = 2024, message = "Year of realize can not be later than 2024")
    @Min(value = 0, message = "Year of realize can not be negative")
    private int yearOfRealize;
    private boolean isFree;


    public Book(String title, String author, int yearOfRealize) {
        this.title = title;
        this.author = author;
        this.yearOfRealize = yearOfRealize;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfRealize() {
        return yearOfRealize;
    }

    public void setYearOfRealize(int yearOfRealize) {
        this.yearOfRealize = yearOfRealize;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfRealize=" + yearOfRealize +
                ", isFree=" + isFree +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && yearOfRealize == book.yearOfRealize && isFree == book.isFree && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, yearOfRealize, isFree);
    }
}

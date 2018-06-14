package com.books.liberary.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;


    @Column(name = "author")
    private String author;


    @Column(name = "year")
    private Integer year;


    @Column(name = "publisher")
    private String publisher;


    @Column(name = "small")
    private String small;


    @Column(name = "midle")
    private String midle;


    @Column(name = "large")
    private String large;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMidle() {
        return midle;
    }

    public void setMidle(String midle) {
        this.midle = midle;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(small, book.small) &&
                Objects.equals(midle, book.midle) &&
                Objects.equals(large, book.large);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, author, year, publisher, small, midle, large);
    }
}

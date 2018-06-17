package com.books.liberary.model;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class AuthorBook {

    private String name;

    private long count;

    public AuthorBook(String name, long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBook that = (AuthorBook) o;
        return count == that.count &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, count);
    }
}

package com.books.liberary.controller;


import com.books.liberary.model.Book;
import com.books.liberary.service.BooksPagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BookController {

    private final static String ALL = "*";

    @Autowired
    private BooksPagedService booksPagedService;

    @GetMapping(value = "/books")
    @PreAuthorize("isAuthenticated()")
    public Iterable<Book> books(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "q", required = false) String q) {
        Page<Book> books;
        if (q != null && !ALL.equals(q)) {
            books = booksPagedService.getBooks(page, q);
        } else {
            books = booksPagedService.getBooks(page);
        }
        return books;
    }

    @GetMapping(value = "/book/{id}")
    @PreAuthorize("isAuthenticated()")
    public Book book(@PathVariable Integer id) {
        Book book = booksPagedService.getBook(id).get();
        return book;
    }
}

package com.books.liberary.controller;


import com.books.liberary.model.Book;
import com.books.liberary.service.BooksPagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BooksPagedService booksPagedService;

    @GetMapping(value = "/books")
    public Iterable<Book> books(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "author", required = false)
                                                String author, @RequestParam(name = "title", required = false) String title) {
        Page<Book> books;
        if (author != null){
            books = booksPagedService.getBooksByAuthor(page,author);
        }
        else if (title != null) {
            books = booksPagedService.getBooksByTitle(page, title);
        } else {
            books = booksPagedService.getBooks(page);
        }
        return books;
    }

    @GetMapping(value = "/book/{id}")
    public Book book(@PathVariable Integer id) {
        Book book = booksPagedService.getBook(id).get();
        return book;
    }









    /*@GetMapping(value = "/books")
    public String books(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "author", required = false) String author, @RequestParam(name = "title", required = false) String title, Model model) {
        Page<Book> books;
        if (author != null){
            books = booksPagedService.getBooksByAuthor(page,author);
        }
        else if (title != null) {
            books = booksPagedService.getBooksByTitle(page, title);
            model.addAttribute("title", title);
        } else {
            books = booksPagedService.getBooks(page);
        }
        model.addAttribute("books", books.getContent());
        if (books.hasNext()) {
            model.addAttribute("next", String.valueOf(books.nextPageable().getPageNumber() + 1));
        } else {
            model.addAttribute("next", null);
        }
        if (books.hasPrevious()) {
            model.addAttribute("prev", String.valueOf(books.previousPageable().getPageNumber() + 1));
        } else {
            model.addAttribute("prev", null);
        }
        model.addAttribute("current", String.valueOf(page));
        return "books";
    }*/

}

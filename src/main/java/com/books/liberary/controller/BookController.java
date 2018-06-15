package com.books.liberary.controller;


import com.books.liberary.model.Book;
import com.books.liberary.service.BooksPagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    @Autowired
    private BooksPagedService booksPagedService;

    @GetMapping(value = "/books/{page}")
    public String products(@PathVariable Integer page, Model model) {
        Page<Book> books = booksPagedService.getBooks(page);
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
    }

}

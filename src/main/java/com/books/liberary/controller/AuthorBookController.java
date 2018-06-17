package com.books.liberary.controller;

import com.books.liberary.model.AuthorBook;
import com.books.liberary.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorBookController {

    @Autowired
    private AuthorBookService authorBookService;

    @GetMapping(value = "/authors")
    private String authorBooks(@RequestParam(name = "page", defaultValue = "1") Integer page, Model model) {
        Page<AuthorBook> data = authorBookService.getBooks(page);
        model.addAttribute("authors", data.getContent());
        if (data.hasNext()) {
            model.addAttribute("next", String.valueOf(data.nextPageable().getPageNumber() + 1));
        } else {
            model.addAttribute("next", null);
        }
        if (data.hasPrevious()) {
            model.addAttribute("prev", String.valueOf(data.previousPageable().getPageNumber() + 1));

        } else {
            model.addAttribute("prev", null);
        }
        model.addAttribute("current", String.valueOf(page));
        return "authors";
    }


}

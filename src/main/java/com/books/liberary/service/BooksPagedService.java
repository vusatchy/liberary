package com.books.liberary.service;

import com.books.liberary.model.Book;
import com.books.liberary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksPagedService {

    @Autowired
    private BookRepository bookRepository;

    private final int PAGE_SIZE = 28;

    public Page<Book> getBooks(int page) {
        List<Book> books = new ArrayList<>();
        PageRequest request = new PageRequest(page - 1, PAGE_SIZE);
        return bookRepository.findAll(request);
    }
}

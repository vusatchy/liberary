package com.books.liberary.service;

import com.books.liberary.model.Book;
import com.books.liberary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksPagedService {

    private static final String SORT_FIELD = "year";
    private static final int PAGE_SIZE = 28;

    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getBooks(int page) {
        PageRequest request = new PageRequest(page - 1, PAGE_SIZE, new Sort(Sort.Direction.DESC, SORT_FIELD));
        return bookRepository.findAll(request);
    }

    public Page<Book> getBooks(int page, String q) {
        PageRequest request = new PageRequest(page - 1, PAGE_SIZE, new Sort(Sort.Direction.DESC, SORT_FIELD));
        return bookRepository.findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(q, q, request);
    }

    public Optional<Book> getBook(Integer id) {
        return bookRepository.findById(id);
    }

}

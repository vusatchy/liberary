package com.books.liberary.service;

import com.books.liberary.model.AuthorBook;
import com.books.liberary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuthorBookService {

    @Autowired
    private BookRepository authorBookRepository;

    private static final int PAGE_SIZE = 20;
    private static final String SORT_FIELD = "author";

    public Page<AuthorBook> getBooks(int page) {
        PageRequest request = new PageRequest(page - 1, PAGE_SIZE, new Sort(SORT_FIELD));
        return (Page<AuthorBook>) authorBookRepository.findAuthorCount(request);
    }
}

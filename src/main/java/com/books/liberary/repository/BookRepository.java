package com.books.liberary.repository;

import com.books.liberary.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select new com.books.liberary.model.AuthorBook(b.author, count(b.title)) from Book b group by b.author")
    Page<?> findAuthorCount(Pageable pageRequest);

    Page<Book> findByTitleContainingIgnoreCase(String title,Pageable pageRequest);

    Page<Book> findByAuthorContainingIgnoreCase(String author,Pageable pageRequest);
}

package com.books.liberary.service;

import com.books.liberary.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleValidationService {

    private static final int MAX_LINE_LENGTH = 34;

    public Book validateNameAndAuthor(Book book) {
        Book result = new Book();
        result.setId(book.getId());
        result.setYear(book.getYear());
        result.setSmall(book.getSmall());
        result.setMidle(book.getMidle());
        result.setLarge(book.getLarge());
        String title = book.getTitle();
        if (title.length() > MAX_LINE_LENGTH) {
            title = title.substring(0, MAX_LINE_LENGTH - 4);
            title += "... ";
            result.setTitle(title);

        } else {
            title += "&nbsp.";
            result.setTitle(title);
        }

       /* int size = MAX_LINE_LENGTH - book.getAuthor().length();
        if (title.length() > size) {
            title = title.substring(0, size - 6);
            title += "... ";
            result.setTitle(title);
        } else {
            result.setTitle(title);
        }*/
        /*if (title.length() > MAX_LINE_LENGTH) {
            title = title.substring(0, MAX_LINE_LENGTH);
        }
        int lengthSum = book.getAuthor().length() + title.length();
        if (lengthSum > MAX_LINE_LENGTH) {
            lengthSum  = MAX_LINE_LENGTH - book.getAuthor().length();
            title = title.substring(0, lengthSum - 5);
            title += "... ";
        }*/
        result.setAuthor(book.getAuthor());
        result.setPublisher(book.getPublisher());
        return result;
    }

    public List<Book> validateNamesAndAuthors(List<Book> books) {
        return books.stream().map(this::validateNameAndAuthor).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Book book = new Book();
        TitleValidationService titleValidationService = new TitleValidationService();
        book.setTitle("The Middle Stories");
        System.out.println(book.getTitle().length());
        System.out.println(book.getTitle() + '|');
        book.setTitle(titleValidationService.validateNameAndAuthor(book).getTitle());
        System.out.println(book.getTitle().length());
        System.out.println(book.getTitle() + '|');
    }
}

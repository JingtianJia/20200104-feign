package com.jia.controller;

import com.jia.model.Book;
import com.jia.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/all")
    public List<Book> selectAll() {
        return bookService.selectAll();
    }
}

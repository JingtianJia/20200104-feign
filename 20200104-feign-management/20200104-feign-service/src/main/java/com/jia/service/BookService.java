package com.jia.service;

import com.jia.mapper.BookMapper;
import com.jia.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }
}

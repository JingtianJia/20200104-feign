package com.jia.service;

import com.jia.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
@FeignClient(value = "BOOK-PROVIDER")
public interface ISpringCloudService {
    @GetMapping("/all")
    List<Book> selectAll();
}

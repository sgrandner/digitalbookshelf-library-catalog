package com.digitalbookshelf.librarycatalog.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping("")
    String getBooks() {
        return "Hello World !";
    }
}
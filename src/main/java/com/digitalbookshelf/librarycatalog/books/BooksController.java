package com.digitalbookshelf.librarycatalog.books;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    String getBooks() {
        return "Hello World !";
    }

    @PostMapping("")
    ResponseEntity<?> addBook(@RequestBody Book book) {

        try {
            bookService.addBook(book);
        }
        catch (UnsupportedEncodingException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
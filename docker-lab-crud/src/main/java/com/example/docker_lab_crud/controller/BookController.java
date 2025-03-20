package com.example.docker_lab_crud.controller;

import com.example.docker_lab_crud.model.Book;
import com.example.docker_lab_crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/books")
    public void createBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable Integer id, @RequestBody Book book){
        if(bookRepository.findById(id).isEmpty()) return;
        book.setId(id);
        bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id){
        if(bookRepository.findById(id).isEmpty()) return;
        bookRepository.delete(bookRepository.findById(id).get());
    }
}

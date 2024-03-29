package br.com.erudio.bookservice.controller;

import br.com.erudio.bookservice.model.Book;
import br.com.erudio.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @GetMapping(value = "/{id}/{currency}")
    public Book finfBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {

        var book = repository.getById(id);
        if (book == null) throw new RuntimeException("Book not found");

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port);
        return book;
    }
}

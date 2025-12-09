package com.library.crud.service;

import com.library.crud.entity.Book;
import com.library.crud.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() { return repo.findAll(); }

    public Book getBookById(Long id) { return repo.findById(id).orElse(null); }

    public Book createBook(Book book) { return repo.save(book); }

    public Book updateBook(Long id, Book data) {
        Book book = repo.findById(id).orElse(null);
        if (book == null) return null;
        book.setTitle(data.getTitle());
        book.setAuthor(data.getAuthor());
        book.setAvailable(data.getAvailable());
        return repo.save(book);
    }

    public void deleteBook(Long id) { repo.deleteById(id); }
}

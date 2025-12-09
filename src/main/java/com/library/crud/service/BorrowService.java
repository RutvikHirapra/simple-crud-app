package com.library.crud.service;

import com.library.crud.entity.*;
import com.library.crud.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowService {

    private final BorrowRecordRepository recordRepo;
    private final UserRepository userRepo;
    private final BookRepository bookRepo;

    public BorrowService(BorrowRecordRepository recordRepo, UserRepository userRepo, BookRepository bookRepo) {
        this.recordRepo = recordRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }


    public BorrowRecord borrowBook(Long userId, Long bookId) {
        User user = userRepo.findById(userId).orElse(null);
        Book book = bookRepo.findById(bookId).orElse(null);

        if (!(user != null && book != null && book.getAvailable())) return null;

        book.setAvailable(false);
        bookRepo.save(book);

        BorrowRecord bookRecord = new BorrowRecord();
        bookRecord.setUser(user);
        bookRecord.setBook(book);
        bookRecord.setBorrowDate(LocalDateTime.now());

        return recordRepo.save(bookRecord);
    }

    public BorrowRecord returnBook(Long recordId) {
        BorrowRecord bookRecord = recordRepo.findById(recordId).orElse(null);
        if (bookRecord == null || bookRecord.getReturnDate() != null) return null;

        Book book = bookRecord.getBook();
        book.setAvailable(true);
        bookRepo.save(book);

        bookRecord.setReturnDate(LocalDateTime.now());
        return recordRepo.save(bookRecord);
    }

    public List<BorrowRecord> getAllRecords() {
        return recordRepo.findAll();
    }
}

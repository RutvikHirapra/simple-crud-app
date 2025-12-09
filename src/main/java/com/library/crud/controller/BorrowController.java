package com.library.crud.controller;

import com.library.crud.entity.BorrowRecord;
import com.library.crud.service.BorrowService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("borrow")
    public BorrowRecord borrow(@RequestParam Long userId, @RequestParam Long bookId) {
        return borrowService.borrowBook(userId, bookId);
    }

    @PostMapping("return")
    public BorrowRecord returnBook(@RequestParam Long recordId) {
        return borrowService.returnBook(recordId);
    }

    @GetMapping("borrow-records")
    public List<BorrowRecord> getAll() {
        return borrowService.getAllRecords();
    }
}

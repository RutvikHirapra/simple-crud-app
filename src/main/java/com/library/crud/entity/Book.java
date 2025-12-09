package com.library.crud.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private Boolean available = true;

    @OneToMany(mappedBy = "book")
    private List<BorrowRecord> borrowRecords;
}

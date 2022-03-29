package com.example.library.dto.response;

import java.time.LocalDate;

import com.example.library.entity.Book;
import com.example.library.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationResponse {

    private Long id;
    private Book book;
    private User user;
    private LocalDate reservedDate;
    private LocalDate dueDate;

}

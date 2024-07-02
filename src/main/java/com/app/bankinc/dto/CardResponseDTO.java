package com.app.bankinc.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CardResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String cardNumber;
    private String cardHolder;
    private LocalDate expirationDate;
    private boolean active;
    private double balance;
    private boolean blocked;
}

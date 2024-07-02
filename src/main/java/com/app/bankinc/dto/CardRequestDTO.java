package com.app.bankinc.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CardRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String productId;
    private String firstName;
    private String lastName;
}

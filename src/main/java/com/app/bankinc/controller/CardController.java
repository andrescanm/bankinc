package com.app.bankinc.controller;

import com.app.bankinc.dto.CardRequestDTO;
import com.app.bankinc.dto.CardResponseDTO;
import com.app.bankinc.model.Card;
import com.app.bankinc.model.CardType;
import com.app.bankinc.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @Operation(summary = "Get all cards")
    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @Operation(summary = "Get card by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the card"), @ApiResponse(responseCode = "404", description = "Card not found")})
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@Parameter(description = "ID of the card to be searched") @PathVariable Long id) {
        Optional<Card> card = cardService.getCardById(id);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new card", description = "Creates a new card for a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Card created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping("/{customerId}")
    public CardResponseDTO createCard(@PathVariable Long customerId, @RequestBody CardRequestDTO request, @RequestParam CardType cardType) {
        return cardService.createCard(customerId, request, cardType);
    }

    @Operation(summary = "Generate a card number")
    @GetMapping("/{productId}/number")
    public String generateCardNumber(@Parameter(description = "Product ID for the card") @PathVariable String productId) {
        return cardService.generateCardNumber(productId);
    }

    @Operation(summary = "Delete a card by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@Parameter(description = "ID of the card to be deleted") @PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}

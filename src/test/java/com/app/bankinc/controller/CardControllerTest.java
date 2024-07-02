package com.app.bankinc.controller;

import com.app.bankinc.dto.CardRequestDTO;
import com.app.bankinc.dto.CardResponseDTO;
import com.app.bankinc.model.Card;
import com.app.bankinc.model.CardType;
import com.app.bankinc.service.CardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class CardControllerTest {

    @Mock
    private CardService cardService;

    @InjectMocks
    private CardController cardController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCards() {
        List<Card> cardList = List.of(new Card());
        when(cardService.getAllCards()).thenReturn(cardList);

        List<Card> result = cardController.getAllCards();
        assertEquals(cardList, result);
    }

    @Test
    public void testGetCardById() {
        Card card = new Card();
        when(cardService.getCardById(anyLong())).thenReturn(Optional.of(card));

        ResponseEntity<Card> result = cardController.getCardById(1L);
        assertEquals(ResponseEntity.ok(card), result);
    }

    @Test
    public void testCreateCard() {
        CardRequestDTO request = new CardRequestDTO();
        CardResponseDTO response = new CardResponseDTO();
        when(cardService.createCard(anyLong(), any(CardRequestDTO.class), any(CardType.class))).thenReturn(response);

        CardResponseDTO result = cardController.createCard(1L, request, CardType.CREDIT);
        assertEquals(response, result);
    }

    @Test
    public void testGenerateCardNumber() {
        String cardNumber = "1234567890123456";
        when(cardService.generateCardNumber(any(String.class))).thenReturn(cardNumber);

        String result = cardController.generateCardNumber("123456");
        assertEquals(cardNumber, result);
    }

    @Test
    public void testDeleteCard() {
        ResponseEntity<Void> result = cardController.deleteCard(1L);
        assertEquals(ResponseEntity.noContent().build(), result);
    }
}

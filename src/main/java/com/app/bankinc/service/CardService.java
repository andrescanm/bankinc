package com.app.bankinc.service;

import com.app.bankinc.business.CardIssuer;
import com.app.bankinc.dto.CardRequestDTO;
import com.app.bankinc.dto.CardResponseDTO;
import com.app.bankinc.model.Card;
import com.app.bankinc.model.CardType;
import com.app.bankinc.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private static final int CARD_LENGTH = 16;
    private static final int PRODUCT_ID_LENGTH = 6;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardIssuer cardIssuer;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public CardResponseDTO createCard(Long customerId, CardRequestDTO request, CardType cardType) {
        return cardIssuer.issueCard(customerId, request, cardType);
    }

    public String generateCardNumber(String productId) {
        return cardIssuer.generateCardNumber(productId);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}

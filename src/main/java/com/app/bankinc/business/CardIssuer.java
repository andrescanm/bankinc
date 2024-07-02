package com.app.bankinc.business;

import com.app.bankinc.dto.CardRequestDTO;
import com.app.bankinc.dto.CardResponseDTO;
import com.app.bankinc.exception.CustomerNotFoundException;
import com.app.bankinc.exception.InvalidProductIdException;
import com.app.bankinc.model.Card;
import com.app.bankinc.model.CardType;
import com.app.bankinc.model.Customer;
import com.app.bankinc.repository.CardRepository;
import com.app.bankinc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDate;

@Component
public class CardIssuer {

    private static final int CARD_LENGTH = 16;
    private static final int PRODUCT_ID_LENGTH = 6;

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public String generateCardNumber(String productId) {
        if (productId.length() != PRODUCT_ID_LENGTH) {
            throw new InvalidProductIdException("Product ID must be " + PRODUCT_ID_LENGTH + " digits long.");
        }
        StringBuilder cardNumber = new StringBuilder(productId);
        SecureRandom random = new SecureRandom();
        while (cardNumber.length() < CARD_LENGTH) {
            int digit = random.nextInt(10);
            cardNumber.append(digit);
        }
        return cardNumber.toString();
    }

    public CardResponseDTO issueCard(Long customerId, CardRequestDTO request, CardType cardType) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
        String cardNumber = generateCardNumber(request.getProductId());
        String cardHolder = request.getFirstName().toUpperCase() + " " + request.getLastName().toUpperCase();
        LocalDate expirationDate = LocalDate.now().plusYears(3);

        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setCardHolder(cardHolder);
        card.setExpirationDate(expirationDate);
        card.setActive(false);
        card.setBalance(0.0);
        card.setBlocked(false);
        card.setCardType(cardType);
        card.setCustomer(customer);
        card = cardRepository.save(card);

        CardResponseDTO response = new CardResponseDTO();
        response.setCardNumber(card.getCardNumber());
        response.setCardHolder(card.getCardHolder());
        response.setExpirationDate(card.getExpirationDate());
        response.setActive(card.isActive());
        response.setBalance(card.getBalance());
        response.setBlocked(card.isBlocked());
        return response;
    }
}

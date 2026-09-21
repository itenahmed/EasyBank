package com.easybytes.cards.Service.impl;

import java.util.Optional;
import java.util.Random;
import com.easybytes.cards.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.easybytes.cards.Entity.Card;
import com.easybytes.cards.Exception.CardAlreadyExistsException;
import com.easybytes.cards.Repository.CardsRepository;
import com.easybytes.cards.Service.ICardsService;
import com.easybytes.cards.constants.CardsConstants;
import com.easybytes.cards.dto.CardsDto;
import com.easybytes.cards.mapper.CardsMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {
    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Card> cardOptional = cardsRepository.findByMobileNumber(mobileNumber);
        if (cardOptional.isPresent()) {
            throw new CardAlreadyExistsException("Card with mobile number " + mobileNumber + " already exists");
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Card createNewCard(String mobileNumber) {
        Card newCard = new Card();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Card card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(

                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        CardsDto cardsDto = new CardsDto();
        CardsMapper.mapToCardsDto(card, cardsDto);
        return cardsDto;
    }

    @Override
    public boolean updateCard(CardsDto cards) {
        Card Card = cardsRepository.findByMobileNumber(cards.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", cards.getMobileNumber()));
        CardsMapper.mapToCards(Card, cards);
        cardsRepository.save(Card);
        return true;
    }
}

package com.easybytes.cards.Service;

import com.easybytes.cards.dto.CardsDto;

public interface ICardsService {

    void createCard(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);

    boolean updateCard(CardsDto cards);

    boolean deleteCard(CardsDto cards);
}

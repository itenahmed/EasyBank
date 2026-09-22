package com.easybytes.cards.Controller;

import com.easybytes.cards.constants.CardsConstants;
import com.easybytes.cards.dto.ResponseDto;
import com.easybytes.cards.Service.ICardsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cards", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
@AllArgsConstructor
public class CardsController {

    private ICardsService iCardsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(
            @RequestBody @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
        // Logic to create a new card
        iCardsService.createCard(mobileNumber);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));

    }
    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCard(@RequestParam
 @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
 String mobileNumber) {
    CardsDto cardsDto = iCardsService.fetchCard(mobileNumber);
    return ResponseEntity.status(HttpStatus.Ok).body(cardsDto);
  
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto>updateCard(@Valid @RequestBody CardsDto cards){
        Boolean isUpdated =iCardsService.updateCard(cards);
        if(isUpdated){
          return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE));
        }

    }


}

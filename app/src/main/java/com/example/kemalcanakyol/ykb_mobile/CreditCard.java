package com.example.kemalcanakyol.ykb_mobile;

import java.util.List;

/**
 * Created by kemalcanakyol on 16.05.2018.
 */

public class CreditCard {


    private String cardName;
    private String cardNumber;
    private int photoId;
    public List<CreditCard> credit_card_list;
    public String getCardName()
    {
        return this.cardName;
    }
    public String getCardNumber()
    {
        return this.cardNumber;
    }
    public int getPhotoId()
    {
        return this.photoId;
    }

    public CreditCard(String cardName,String cardNumber,int photoId)
    {
        this.cardName = cardName;
        this.cardNumber= cardNumber;
        this.photoId = photoId;
    }

    public CreditCard() {

    }


}

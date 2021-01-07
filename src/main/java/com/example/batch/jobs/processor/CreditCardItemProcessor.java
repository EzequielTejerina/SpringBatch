package com.example.batch.jobs.processor;

import com.example.batch.domain.CreditCard;
import org.springframework.batch.item.ItemProcessor;


public class CreditCardItemProcessor implements ItemProcessor<CreditCard, CreditCard> {

    @Override
    public CreditCard process(CreditCard item) {
        return item;
    }
}
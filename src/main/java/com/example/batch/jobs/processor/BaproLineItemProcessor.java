package com.example.batch.jobs.processor;

import com.example.batch.domain.AltaTitularBapro;
import com.example.batch.domain.BajaIndividualBapro;
import com.example.batch.domain.BaproLine;
import com.example.batch.domain.BaproLineFormatted;
import org.springframework.batch.item.ItemProcessor;

public class BaproLineItemProcessor implements ItemProcessor<BaproLine, BaproLineFormatted> {

    @Override
    public BaproLineFormatted process(BaproLine baproLine) throws Exception {
        return new BaproLineFormatted(this.getTypeLine(baproLine.getLine()));
    }

    private String getTypeLine(String line){
        return line.length() == 21? new AltaTitularBapro(line).toString() : new BajaIndividualBapro(line).toString();
    }
}

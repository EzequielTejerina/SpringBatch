package com.example.batch.jobs.writers;

import com.example.batch.domain.CreditCard;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

public class CreditCardItemWriter implements ItemWriter<CreditCard> {

    @Override
    public void write(List<? extends CreditCard> list) throws Exception {
        FlatFileItemWriter<CreditCard> writer = new FlatFileItemWriter<>();
        writer.setResource(new ClassPathResource("output.txt"));

        PassThroughLineAggregator<CreditCard> delLineAgg = new PassThroughLineAggregator<CreditCard>();

        BeanWrapperFieldExtractor<CreditCard> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[] {"id","cardNumber","lastPay"});
        writer.setLineAggregator(delLineAgg);

        writer.close();
    }
}

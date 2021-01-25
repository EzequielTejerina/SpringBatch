package com.example.batch.jobs.writers;

import com.example.batch.domain.BaproLineFormatted;
import com.example.batch.domain.CreditCard;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

public class BaproLineItemWriter implements ItemWriter<BaproLineFormatted> {
    @Override
    public void write(List<? extends BaproLineFormatted> list) throws Exception {
        FlatFileItemWriter<BaproLineFormatted> writer = new FlatFileItemWriter<>();
        writer.setResource(new ClassPathResource("output_bapro.txt"));

        PassThroughLineAggregator<BaproLineFormatted> delLineAgg = new PassThroughLineAggregator<BaproLineFormatted>();

        writer.setLineAggregator(delLineAgg);

        writer.close();
    }
}

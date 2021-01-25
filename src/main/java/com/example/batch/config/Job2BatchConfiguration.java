package com.example.batch.config;

import com.example.batch.domain.*;
import com.example.batch.jobs.listeners.BaproJobExecutionListener;
import com.example.batch.jobs.listeners.CreditCardJobExecutionListener;
import com.example.batch.jobs.processor.BaproLineItemProcessor;
import com.example.batch.jobs.processor.CreditCardItemProcessor;
import com.example.batch.jobs.readers.BaproItemReader;
import com.example.batch.jobs.readers.CreditCardItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class Job2BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Bean
    public BaproItemReader reader() {
        return new BaproItemReader();
    }

    @Bean
    public BaproLineItemProcessor processor() {
        return new BaproLineItemProcessor();
    }

    @Bean
    public FlatFileItemWriter itemWriter() {
        return  new FlatFileItemWriterBuilder<BaproLineFormatted>()
                .name("itemBaproWriter")
                .resource(new FileSystemResource("output_bapro.txt"))
                .lineAggregator(new PassThroughLineAggregator<>())
                .build();
    }

    @Bean
    public BaproJobExecutionListener jobExecutionListener() {
        return new BaproJobExecutionListener();
    }

    @Bean
    public Job job(Step step, BaproJobExecutionListener jobExecutionListener) {
        Job job = jobBuilderFactory.get("job2")
                .listener(jobExecutionListener)
                .flow(step)
                .end()
                .build();
        return job;
    }

    @Bean
    public Step step(BaproItemReader reader,
                     FlatFileItemWriter writer,
                     BaproLineItemProcessor processor) {

        TaskletStep step = stepBuilderFactory.get("step2")
                .<BaproLine, BaproLineFormatted>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
        return step;
    }
}

package com.example.batch.jobs.readers;

import com.example.batch.domain.BaproLine;
import com.example.batch.domain.CreditCard;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class BaproItemReader implements ItemReader<BaproLine> {

    private Iterator<String> linesIterator;
    @BeforeStep
    public void before(StepExecution stepExecution) throws IOException {
        Path path = Paths.get("bapro.txt");
        Stream<String> stream = Files.lines(path);
        linesIterator = stream.iterator();
    }
    @Override
    public BaproLine read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (linesIterator != null && linesIterator.hasNext()) {
            return new BaproLine(linesIterator.next());
        } else {
            return null;
        }
    }
}

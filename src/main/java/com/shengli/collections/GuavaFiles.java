package com.shengli.collections;

import com.google.common.base.Charsets;
import com.google.common.io.LineProcessor;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by shengli on 8/21/15.
 */
public class GuavaFiles {
    public static final Logger LOG = LoggerFactory.getLogger(GuavaFiles.class);

    public static void main(String[] args) throws IOException {
        File f = new File("logs/project-name.log");
        Processor processor = new Processor();
        Files.readLines(f, Charsets.UTF_8, processor);
        LOG.info(processor.getResult().toString());
    }
}

class Processor implements LineProcessor<Integer> {

    private int lineSize = 0;

    @Override
    public boolean processLine(String line) throws IOException {
        if (line.length() > 77) {
            System.out.println("Current line is exceed line limits 77" + line);
        }
        lineSize += line.length();
        return true;
    }

    @Override
    public Integer getResult() {
        return lineSize;
    }
}
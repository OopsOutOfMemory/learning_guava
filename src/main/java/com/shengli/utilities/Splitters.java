package com.shengli.utilities;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by shengli on 8/17/15.
 */
public class Splitters {
    public static final Logger LOG = LoggerFactory.getLogger(Splitters.class);

    public static void main(String[] args) {
        Splitter.on('|').split("foo|bar|baz");

        Splitter splitter = Splitter.on("\\d+");

        Splitter splitterTrim = Splitter.on('|').trimResults();

        Iterable<String> parts = splitter.split("1|2|3|||");

        List<String> list = Lists.newArrayList(parts); // no element can be null


        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");

        String startString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys\";";

//        Map<String,String> testMap = Maps.newLinkedHashMap();
//        testMap.put("Washington D.C","Redskins");
//        testMap.put("New York City","Giants");
//        testMap.put("Philadelphia","Eagles");
//        testMap.put("Dallas","Cowboys");
        Map<String,String> splitMap = mapSplitter.split(startString);
    }

}

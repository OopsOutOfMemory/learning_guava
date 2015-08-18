package com.shengli.utilities;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shengli on 8/17/15.
 */

public class Joiners {

    public static final String DELIMITER = "|";
    public static final String COMMA_DELIMITER = "|";
    public static final String KV_DELIMITER = "=";
    public static final String FILE_JOIN_TEMP = "join_temp";
    public static final Logger LOG = LoggerFactory.getLogger(Joiners.class);

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("I");
        stringList.add("Love");
        stringList.add("MyFamily");
        stringList.add(null); // add an exception null value

        /*-------------------------Joiner Basic Usage--------------------------*/

        String oldWay = Joiners.buildString(stringList, DELIMITER);
        LOG.info("Using the old Method to build String->" + oldWay);


        String newWay = Joiner.on(DELIMITER).skipNulls().join(stringList);

        // replace the null in the list with a real value
        String newWayRplNull = Joiner.on(DELIMITER).useForNull(" : ) ").join(stringList);

        LOG.info("Using the Guava Joiner to build String->" + newWay);

        LOG.info("Using the Guava Joiner to build String, Replace NULL value->" + newWayRplNull);


        Joiner joiner = Joiner.on(DELIMITER).skipNulls();
//        joiner.useForNull("missing"); // this will generate a new instance for joiner
//        String res = joiner.join("a", "b", null); this will throw exceptions  null is not allowed like this
        String res = joiner.join(stringList);
        LOG.info("Define a joiner, apply a value on it->" + res);


        StringBuilder stringBuilder = new StringBuilder();
        Joiner joinSkipNulls = Joiner.on(DELIMITER).skipNulls();
        StringBuilder result = joinSkipNulls.appendTo(stringBuilder, "foo", "nar", "zer", null);
        LOG.info("Append a SkipNulls joiner string into a StringBuilder" + result);


        /*-------------------------Joiner to append to a file--------------------------*/

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(new File(FILE_JOIN_TEMP));
//            fileWriter = new FileWriter(new File(FILE_JOIN_TEMP));
            List<Date> dateList = getDates();
            Joiner joinerDates = Joiner.on(DELIMITER).useForNull("missing");
            joinerDates.appendTo(fileWriter, dateList);
        }
        catch (IOException ioException)
        {
            LOG.error("Error Write file to "+FILE_JOIN_TEMP,Joiner.on(DELIMITER).skipNulls().join(ioException.getStackTrace()));
        }
        finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                LOG.error("Error while close writer->", Joiner.on(DELIMITER).skipNulls().join(e.getStackTrace()));
            }
        }

        /*-------------------------Mapper join to a given Map<K,V>--------------------------*/
        Joiner.MapJoiner mapJoiner = Joiner.on(COMMA_DELIMITER).withKeyValueSeparator(KV_DELIMITER);
        Map<String,String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas", "Cowboys");
        String mapString = mapJoiner.join(testMap);
        LOG.info("Map join k=v is =>"+mapString);
    }

  public static List<Date> getDates() {
      List<Date> dateList = new ArrayList<>();
      dateList.add(new Date());
      dateList.add(new Date());
      dateList.add(new Date());
      return dateList;
  }


  //传统的buildString方法
  public static String buildString(List<String> stringList, String delimiter){
        StringBuilder builder = new StringBuilder();
        for (String s : stringList) {
        if(s !=null){ // ignore the null value in the string list
        builder.append(s).append(delimiter);
        } }
        builder.setLength(builder.length() - delimiter.length()); // ignore the last string
        return builder.toString();
        }
}

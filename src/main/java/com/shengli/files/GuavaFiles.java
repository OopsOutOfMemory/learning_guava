package com.shengli.files;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.*;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shengli on 8/26/15.
 */
public class GuavaFiles {
    public static void main(String[] args) throws IOException {
        Closer closer = Closer.create();
        //copy a file
        File origin = new File("join_temp");
        File copy = new File("target_temp");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("join_temp"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("target_temp"));

            closer.register(reader);
            closer.register(writer);

            String line;

            while ( (line = reader.readLine()) != null) {
                writer.write(line);
            }
        } catch (IOException e) {
            throw  closer.rethrow(e);
        } finally {
            closer.close();
        }

        Files.copy(origin, copy);

        File moved = new File("moved");

        //moving renaming
        Files.move(copy, moved);

        //working files as string
        List<String> lines = Files.readLines(origin, Charsets.UTF_8);

        HashCode hashCode = Files.hash(origin, Hashing.md5());
        System.out.println(hashCode);

        //file write and append
        String hamlet = "To be, or not to be it is a question\n";
        File write_and_append = new File("write_and_append");


        Files.write(hamlet, write_and_append, Charsets.UTF_8);

        Files.append(hamlet, write_and_append, Charsets.UTF_8);

//        write_and_append.deleteOnExit();

        Files.write("OverWrite the file", write_and_append, Charsets.UTF_8);

        //ByteSource ByteSink
        ByteSource fileBytes = Files.asByteSource(write_and_append);
        byte[] readBytes = fileBytes.read();
        // equals to pre line -> Files.toByteArray(write_and_append) == readBytes

        ByteSink fileByteSink = Files.asByteSink(write_and_append);
        fileByteSink.write(Files.toByteArray(write_and_append));


        BaseEncoding base64 = BaseEncoding.base64();
        System.out.println(base64.encode("123456".getBytes()));
    }
}

class ToListLineProcessor implements LineProcessor<List<String>> {

    private static final Splitter spliiter = Splitter.on(",");
    private static List<String> resultList = Lists.newArrayList();

    @Override
    public boolean processLine(String line) throws IOException {
        Iterator<String> it =  spliiter.split(line).iterator();
        while (it.hasNext()){
            resultList.add(it.next());
        }
        return true;
    }

    @Override
    public List<String> getResult() {
        return resultList;
    }
}

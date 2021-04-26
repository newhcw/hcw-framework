package com.hcw.learn.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamWordCount {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();

        String inputPath = "/Users/huangchunwu/WorkSpace/hcw-framework-pom/hcw-learn-flink/src/main/resources/hello.txt";
        DataStream<String> dataStreamSource = environment.readTextFile(inputPath);

        DataStream<Tuple2<String, Integer>> resultStream = dataStreamSource.flatMap(new WordCount.MyFlatMapper())
                .keyBy(0)
                .sum(1);

        resultStream.print();

        environment.execute();
    }
}

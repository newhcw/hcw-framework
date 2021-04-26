package com.hcw.learn.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class SocketStreamWordCount {

    public static void main(String[] args) throws Exception {

        ParameterTool fromArgs = ParameterTool.fromArgs(args);
        String host = fromArgs.get("host");
        int port = fromArgs.getInt("port");


        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> dataStreamSource = environment.socketTextStream(host,port);

        DataStream<Tuple2<String, Integer>> resultStream = dataStreamSource.flatMap(new WordCount.MyFlatMapper())
                .keyBy(0)
                .sum(1);

        resultStream.print();

        environment.execute();
    }
}

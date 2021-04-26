package com.hcw.learn.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * DataSet 针对离线数据处理
 */
public class WordCount {

    public static void main(String[] args) throws Exception {
        // 创建执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //从文件读取数据
        String path = "/Users/huangchunwu/WorkSpace/hcw-framework-pom/hcw-learn-flink/src/main/resources/hello.txt";
        DataSet<String> dataSource = env.readTextFile(path);

        //对数据进行处理，按照空格分词展开，转换成（word，1），并且进行统计
        DataSet<Tuple2<String, Integer>> resultSet = dataSource.flatMap(new MyFlatMapper())
                .groupBy(0)// 按照第一个位置的word分组
                .sum(1);// 按照第二个位置sum

        resultSet.print();
    }

    public static class MyFlatMapper implements FlatMapFunction<String, Tuple2<String,Integer>> {


        @Override
        public void flatMap(String value, Collector<Tuple2<String,Integer>> out) throws Exception {
            String[] words = value.split(" ");
            for (String word : words) {
                out.collect(new Tuple2<>(word,1));
            }
        }
    }
}

package com.xdclass.couponapp;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author William
 * @version 1.0
 * @description: JMH 高级测试必知必会
 * @date 2020/11/30 15:05
 */

public class JMHHelloWorld {

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().warmupIterations(2).measurementBatchSize(2)
                .forks(2).build();

        new Runner(options).run();
    }

    @Benchmark
    public void testStringAdd() {
        String s = "";
        for(int i = 0; i < 10; i++) {
            s += i;
        }
    }

    @Benchmark
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            sb.append(i);
        }
        sb.toString();
    }
}

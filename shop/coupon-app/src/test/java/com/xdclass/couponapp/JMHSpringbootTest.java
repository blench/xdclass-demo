package com.xdclass.couponapp;

import com.xdclass.couponapp.service.CouponService;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author William
 * @version 1.0
 * @description: TODO
 * @date 2020/11/30 15:15
 */
@State(value = Scope.Benchmark)
public class JMHSpringbootTest {

    public ConfigurableApplicationContext context;

    private CouponService couponService;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(JMHSpringbootTest.class.getName()+".*")
                .warmupIterations(2).measurementIterations(2)
                .forks(1).build();

        new Runner(options).run();
    }

    /**
     * @description: setup 初始化容器的时候只执行一次
     * @author
     * @date
     * @version 1.0
     */
    @Setup(Level.Trial)
    public void init() {
        String args = "";
        context = SpringApplication.run(CouponAppApplication.class, args);
        couponService = context.getBean(CouponService.class);
    }

    /**
     * @description: benchmark 执行多次，此注解代表触发我们所要进行基准测试的方法
     * @author
     * @date
     * @version 1.0
     */
    @Benchmark
    public void test() {
        System.out.println(couponService.getById(5));
    }
}

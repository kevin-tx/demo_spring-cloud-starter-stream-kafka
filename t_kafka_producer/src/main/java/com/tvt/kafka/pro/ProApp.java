package com.tvt.kafka.pro;

import com.tvt.kafka.pro.message.Tp01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author TX
 * @date 2021/1/12 19:12
 */
@SpringBootApplication
@EnableBinding(value = {
        Tp01.class
})
public class ProApp {
    public static void main(String[] args) {
        SpringApplication.run(ProApp.class, args);
    }
}

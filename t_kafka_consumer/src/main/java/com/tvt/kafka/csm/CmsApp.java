package com.tvt.kafka.csm;

import com.tvt.kafka.csm.message.Tp01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author TX
 * @date 2021/1/12 19:39
 */
@SpringBootApplication
@EnableBinding(value = {
        Tp01.class
})
public class CmsApp {
    public static void main(String[] args) {
        SpringApplication.run(CmsApp.class, args);
    }
}

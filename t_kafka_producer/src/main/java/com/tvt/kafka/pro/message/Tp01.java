package com.tvt.kafka.pro.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author TX
 * @date 2021/1/12 19:13
 */
public interface Tp01 {
    String OUTPUT = "Tp01";

    @Output(Tp01.OUTPUT)
    MessageChannel output();
}

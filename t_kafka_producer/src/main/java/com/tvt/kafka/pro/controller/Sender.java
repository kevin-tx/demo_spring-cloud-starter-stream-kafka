package com.tvt.kafka.pro.controller;

import com.tvt.kafka.pro.message.Tp01;
import com.tvt.kafka.pro.util.ChannelSendMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author TX
 * @date 2021/1/12 20:09
 */
@RestController
public class Sender {

    @Value("${spring.cloud.stream.bindings.Tp01.producer.partition-count}")
    private int tp01PartitionCount;
    @Autowired
    private Tp01 tp01;

    private ChannelSendMessageUtil tp01SendUtil;

    @PostConstruct
    public void init() {
        tp01SendUtil = new ChannelSendMessageUtil(tp01PartitionCount);
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String bindDevice(String data) {
        tp01SendUtil.send(tp01.output(), data);
        return data;
    }
}

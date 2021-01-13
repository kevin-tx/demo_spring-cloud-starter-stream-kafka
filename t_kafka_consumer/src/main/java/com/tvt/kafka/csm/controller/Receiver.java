package com.tvt.kafka.csm.controller;

import com.tvt.kafka.csm.message.Tp01;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;


/**
 * @author TX
 * @date 2021/1/13 9:40
 */
@Component
public class Receiver {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    @StreamListener(Tp01.INPUT)
    public void receiveReq(String data) {
        try {
            logger.info("Received: " + data);
        } catch (Exception e) {
            logger.error("Interrupted 异常!", e);
        }
    }
}

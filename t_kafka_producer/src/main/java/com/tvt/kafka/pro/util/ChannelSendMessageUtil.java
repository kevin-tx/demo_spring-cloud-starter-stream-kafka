package com.tvt.kafka.pro.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 通道发送消息工具
 */
public class ChannelSendMessageUtil {

    private int partitionCount;
    Logger logger = LoggerFactory.getLogger(ChannelSendMessageUtil.class);


    public ChannelSendMessageUtil(int partitionCount) {
        this.partitionCount = partitionCount;
    }

    /**
     * 公共方法 kafka发送消息
     *
     * @param messageChannel 发送通道
     * @param msg            发送内容
     */
    public void send(MessageChannel messageChannel, Object msg) {
        int random = (int) (Math.random() * this.partitionCount);
        logger.info("kafka发送消息到分区--------------" + random + "内容：" + msg);
        messageChannel.send(MessageBuilder.withPayload(msg).setHeader("partitionKey", random).build());
    }

    /**
     * 公共方法 kafka发送消息（同一sn发送到同一分区）
     *
     * @param messageChannel 发送通道
     * @param msg            发送内容
     * @param sn             设备SN
     */
    public void send(MessageChannel messageChannel, Object msg, String sn) {
        if (sn!=null) {
            logger.info("kafka发送消息到分区--------------SN:" + sn + "内容：" + msg);
            messageChannel.send(MessageBuilder.withPayload(msg).setHeader("partitionKey", sn).build());
        } else {
            send(messageChannel, msg);
        }
    }
}

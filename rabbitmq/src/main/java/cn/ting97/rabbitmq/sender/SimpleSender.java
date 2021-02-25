package cn.ting97.rabbitmq.sender;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className HelloSender
 * @Description
 * @date 2021-02-22
 */
@Component
public class SimpleSender {

    private final AmqpTemplate rabbitTemplate;

    public SimpleSender(AmqpTemplate rabbitTemplate) {this.rabbitTemplate = rabbitTemplate;}

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        // 不填写交换机
        this.rabbitTemplate.convertAndSend(MQConstants.HELLO_QUEUE, context);
    }

    public void send(int i) {
        String context = "hello " + i;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(MQConstants.HELLO123_QUEUE, context);
    }

}
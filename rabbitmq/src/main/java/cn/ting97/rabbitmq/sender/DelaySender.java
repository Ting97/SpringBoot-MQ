package cn.ting97.rabbitmq.sender;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DelaySender
 * @Description 延迟队列生产者
 * @date 2021-02-24
 */
@Component
public class DelaySender {
    private final AmqpTemplate rabbitTemplate;

    DelaySender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message, int ttl) {
        rabbitTemplate.convertAndSend(MQConstants.DELAY_EXCHANGE, MQConstants.DELAY_ROUTING_KEY, message, messages -> {
            // 设置过期时间
            messages.getMessageProperties().setExpiration(ttl + "");
            return messages;
        });
        System.out.println("delay message = " + message + " ttl = " + ttl + " send time = " + LocalDateTime.now());
    }

    public void toolSend(String message, int ttl) {
        rabbitTemplate.convertAndSend(MQConstants.DELAYED_EXCHANGE, MQConstants.DELAYED_ROUTING_KEY, message, messages -> {
            // 设置过期时间
            messages.getMessageProperties().setDelay(ttl);
            return messages;
        });
        System.out.println("delayed message = " + message + " ttl = " + ttl + " send time = " + LocalDateTime.now());
    }
}

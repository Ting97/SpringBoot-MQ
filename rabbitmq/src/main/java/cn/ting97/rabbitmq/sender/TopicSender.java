package cn.ting97.rabbitmq.sender;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className TopicSender
 * @Description 主题消息发送
 * @date 2021-02-23
 */
@Component
public class TopicSender {
    private final AmqpTemplate rabbitTemplate;

    public TopicSender(AmqpTemplate rabbitTemplate) {this.rabbitTemplate = rabbitTemplate;}

    public void sendTopic1() {
        rabbitTemplate.convertAndSend(MQConstants.TOPIC_EXCHANGE, MQConstants.TOPIC1_ROUTING_KEY, "hello 1");
    }

    public void sendTopic2(int i) {
        rabbitTemplate.convertAndSend(MQConstants.TOPIC_EXCHANGE, MQConstants.TOPIC2_ROUTING_KEY, "hello 2 -> " + i);
    }

}

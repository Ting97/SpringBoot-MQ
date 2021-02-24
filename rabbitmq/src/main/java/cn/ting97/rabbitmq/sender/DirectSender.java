package cn.ting97.rabbitmq.sender;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DirectSender
 * @Description 直连配置生产者
 * @date 2021-02-23
 */
@Component
public class DirectSender {

    private final AmqpTemplate rabbitTemplate;

    public DirectSender(AmqpTemplate rabbitTemplate) {this.rabbitTemplate = rabbitTemplate;}

    public void directSend1() {
        rabbitTemplate.convertAndSend(MQConstants.DIRECT_EXCHANGE, MQConstants.DIRECT1_ROUTING_KEY, "direct 1");
    }

    public void directSend2(int i) {
        rabbitTemplate.convertAndSend(MQConstants.DIRECT_EXCHANGE, MQConstants.DIRECT2_ROUTING_KEY, "direct 2 -> " + i);
    }
}

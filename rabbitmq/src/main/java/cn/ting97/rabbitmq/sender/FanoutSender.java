package cn.ting97.rabbitmq.sender;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className FanoutSender
 * @Description 广播配置队列生产者
 * @date 2021-02-24
 */
@Component
public class FanoutSender {
    private final AmqpTemplate amqpTemplate;

    public FanoutSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void fanoutSend(int i) {
        amqpTemplate.convertAndSend(MQConstants.FANOUT_EXCHANGE, "", "fanout -> " + i);
    }
}

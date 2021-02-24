package cn.ting97.rabbitmq.listener.direct;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className Direct1Listener
 * @Description 直连交换机队列1监听器
 * @date 2021-02-23
 */
@Component
@RabbitListener(queues = MQConstants.DIRECT1_QUEUE)
public class Direct1Listener {
    @RabbitHandler
    public void consumer(String message) {
        System.out.println("consumer 1" + message);
    }
}

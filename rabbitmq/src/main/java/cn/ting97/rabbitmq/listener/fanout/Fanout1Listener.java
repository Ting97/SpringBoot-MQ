package cn.ting97.rabbitmq.listener.fanout;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className Fanout1Listener
 * @Description 广播队列消费者1
 * @date 2021-02-24
 */
@Component
@RabbitListener(queues = MQConstants.FANOUT1_QUEUE)
public class Fanout1Listener {
    @RabbitHandler
    public void consumer(String message) {
        System.out.println("fanout1 message = " + message);
    }
}

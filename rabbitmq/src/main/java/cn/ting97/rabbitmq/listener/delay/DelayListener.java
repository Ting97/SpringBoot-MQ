package cn.ting97.rabbitmq.listener.delay;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DelayListener
 * @Description 延迟队列消费者
 * @date 2021-02-24
 */
@Component
public class DelayListener {

    @RabbitListener(queues = MQConstants.DEAD_QUEUE)
    public void consumer(Message message) {
        System.out.println("consumer message = " + new String(message.getBody()) + "consume time = " + LocalDateTime.now());
    }
}

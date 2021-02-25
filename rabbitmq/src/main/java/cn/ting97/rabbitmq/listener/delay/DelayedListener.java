package cn.ting97.rabbitmq.listener.delay;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DelayedListener
 * @Description 延迟队列消费者
 * @date 2021-02-24
 */
@Component
public class DelayedListener {

    /**
     * 消费者方法 在方法上添加 @RabbitListener 注解，参数类型为Message
     *
     * @param message 消息类 其中Body为消息主体
     */
    @RabbitListener(queues = MQConstants.DELAYED_QUEUE)
    public void consumer(Message message) {
        System.out.println("consumer message = " + new String(message.getBody()) + "consume time = " + LocalDateTime.now());
    }
}

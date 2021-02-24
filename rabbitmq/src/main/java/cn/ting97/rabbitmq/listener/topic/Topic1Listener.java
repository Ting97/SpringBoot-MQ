package cn.ting97.rabbitmq.listener.topic;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className Topic1Listener
 * @Description 主题交换机队列1监听消费者
 * @date 2021-02-23
 */
@Component
public class Topic1Listener {

    @RabbitListener(queues = MQConstants.TOPIC1_QUEUE)
    public void consumeMessage(Message message) throws Exception {
        try {
            String msg = new String(message.getBody());
            System.out.println("topic1 msg = " + msg);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

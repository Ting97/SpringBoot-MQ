package cn.ting97.rabbitmq.listener.fanout;

import cn.ting97.rabbitmq.utils.MQConstants;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className Fanout2Listener
 * @Description 广播队列消费者2
 * @date 2021-02-24
 */
@Component
public class Fanout2Listener {
    @RabbitListener(queues = MQConstants.FANOUT2_QUEUE)
    public void consumer(Message message) {
        MessageProperties messageProperties = message.getMessageProperties();
        Gson gson = new Gson();
        System.out.println("fanout 2 messageProperties = " + gson.toJson(messageProperties)
                + "message = " + new String(message.getBody()));
    }
}

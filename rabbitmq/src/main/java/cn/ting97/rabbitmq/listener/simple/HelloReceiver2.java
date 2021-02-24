package cn.ting97.rabbitmq.listener.simple;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className HelloReceiver2
 * @Description 接受者
 * @date 2021-02-22
 */
@Component
@RabbitListener(queues = MQConstants.HELLO123_QUEUE)
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String hello) throws Exception {
        System.out.println("Receiver2  : " + hello);
    }

}
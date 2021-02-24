package cn.ting97.rabbitmq.config.delay;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DelayedToolRabbitConfig
 * @Description enable rabbitmq_delayed_message_exchange 后
 * @date 2021-02-24
 */
@Configuration
public class DelayedToolRabbitConfig {

    /**
     * 1. 声明交换机
     */
    @Bean
    public CustomExchange customExchange() {
        Map<String, Object> args = new HashMap<>(3);
        args.put("x-delayed-type", "direct");
        return new CustomExchange(MQConstants.DELAYED_EXCHANGE, "x-delayed-message", true, false, args);
    }

    /**
     * 2. 声明消息队列
     */
    @Bean
    public Queue immediateQueue() {
        return QueueBuilder.durable(MQConstants.DELAYED_QUEUE).build();
    }

    /**
     * 3. 消息队列绑定
     */
    @Bean
    public Binding delayedBinding(@Qualifier("customExchange") CustomExchange customExchange,
                                  @Qualifier("immediateQueue") Queue immediateQueue) {
        return BindingBuilder.bind(immediateQueue).to(customExchange).with(MQConstants.DELAYED_ROUTING_KEY).noargs();
    }
}

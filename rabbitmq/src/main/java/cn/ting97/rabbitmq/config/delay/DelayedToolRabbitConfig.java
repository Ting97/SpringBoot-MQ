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
 * @Description after enable rabbitmq_delayed_message_exchange  利用rabbitmq插件实现延迟队列
 * @date 2021-02-24
 */
@Configuration
public class DelayedToolRabbitConfig {

    /**
     * 1. 声明交换机
     */
    @Bean
    public CustomExchange customExchange() {
        // 设置交换机参数，自定义交换机。
        // 交换机类型为直连交换机，自定义类型为延迟消息类型
        Map<String, Object> args = new HashMap<>(3);
        args.put("x-delayed-type", "direct");
        return new CustomExchange(MQConstants.DELAYED_EXCHANGE, "x-delayed-message", true, false, args);
    }

    /**
     * 2. 声明延迟队列
     */
    @Bean
    public Queue immediateQueue() {
        // 声明延迟队列
        return QueueBuilder.durable(MQConstants.DELAYED_QUEUE).build();
    }

    /**
     * 3. 队列绑定交换机路由Key
     */
    @Bean
    public Binding delayedBinding(@Qualifier("customExchange") CustomExchange customExchange,
                                  @Qualifier("immediateQueue") Queue immediateQueue) {
        // 延迟队列绑定交换机路由
        return BindingBuilder.bind(immediateQueue).to(customExchange).with(MQConstants.DELAYED_ROUTING_KEY).noargs();
    }
}

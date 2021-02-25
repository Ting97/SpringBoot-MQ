package cn.ting97.rabbitmq.config.delay;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DelayRabbitConfig
 * @Description 延时队列配置： 利用死信队列实现延迟队列
 * @date 2021-02-24
 */
@Configuration
public class DelayRabbitConfig {

    /**
     * 1. 声明延时队列交换机
     */
    @Bean
    public DirectExchange delayExchange() {
        return new DirectExchange(MQConstants.DELAY_EXCHANGE);
    }

    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange(MQConstants.DEAD_EXCHANGE);
    }

    /**
     * 2. 声明延时队列以及死信队列
     */
    @Bean
    public Queue delayQueue() {
        // 构建延迟队列：绑定死信交换机和死信队列路由Key
        return QueueBuilder.durable(MQConstants.DELAY_QUEUE)
                .deadLetterExchange(MQConstants.DEAD_EXCHANGE)
                .deadLetterRoutingKey(MQConstants.DEAD_ROUTING_KEY)
                .build();
    }

    @Bean
    public Queue deadQueue() {
        // 声明死信队列
        return QueueBuilder.durable(MQConstants.DEAD_QUEUE).build();
    }

    /**
     * 3. 绑定交换机路由Key
     */
    @Bean
    public Binding delayQueueBinding() {
        // 延迟队列绑定延迟队列交换机
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(MQConstants.DELAY_ROUTING_KEY);
    }

    @Bean
    public Binding deadQueueBinding() {
        // 死信队列绑定死信队列交换机
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with(MQConstants.DEAD_ROUTING_KEY);
    }
}

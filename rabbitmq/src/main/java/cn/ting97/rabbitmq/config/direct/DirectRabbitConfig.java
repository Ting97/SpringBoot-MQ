package cn.ting97.rabbitmq.config.direct;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DirectRabbitConfig
 * @Description 直连配置
 * @date 2021-02-23
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 1. 声明交换机
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(MQConstants.DIRECT_EXCHANGE);
    }

    /**
     * 2. 声明队列
     */
    @Bean
    public Queue direct1Queue() {
        return QueueBuilder.durable(MQConstants.DIRECT1_QUEUE).build();
    }

    @Bean
    public Queue direct2Queue() {
        return QueueBuilder.durable(MQConstants.DIRECT2_QUEUE).build();
    }

    /**
     * 3. 绑定路由key
     */
    @Bean
    public Binding direct1Binding() {
        return BindingBuilder.bind(direct1Queue()).to(directExchange()).with(MQConstants.DIRECT1_ROUTING_KEY);
    }

    @Bean
    public Binding direct2Binding() {
        return BindingBuilder.bind(direct2Queue()).to(directExchange()).with(MQConstants.DIRECT2_ROUTING_KEY);
    }
}

package cn.ting97.rabbitmq.config.fanout;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className FanoutRabbitConfig
 * @Description 广播配置
 * @date 2021-02-23
 */
@Configuration
public class FanoutRabbitConfig {

    /**
     * 1. 声明交换机
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(MQConstants.FANOUT_EXCHANGE);
    }

    /**
     * 2. 声明队列
     */
    @Bean
    public Queue fanout1Queue() {
        return QueueBuilder.durable(MQConstants.FANOUT1_QUEUE).build();
    }

    @Bean
    public Queue fanout2Queue() {
        return QueueBuilder.durable(MQConstants.FANOUT2_QUEUE).build();
    }

    /**
     * 3. 绑定交换机
     */
    @Bean
    public Binding fanout1Binding() {
        return BindingBuilder.bind(fanout1Queue()).to(fanoutExchange());
    }

    @Bean
    public Binding fanout2Binding() {
        return BindingBuilder.bind(fanout2Queue()).to(fanoutExchange());
    }

}
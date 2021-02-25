package cn.ting97.rabbitmq.config.topic;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className TopicRabbitConfig
 * @Description 主题rabbit配置
 * @date 2021-02-23
 */
@Configuration
public class TopicRabbitConfig {
    /**
     * 构建队列
     */
    @Bean
    public Queue topic1Queue() {
        return QueueBuilder.durable(MQConstants.TOPIC1_QUEUE).build();
    }

    @Bean
    public Queue topic2Queue() {
        return QueueBuilder.durable(MQConstants.TOPIC2_QUEUE).build();
    }

    /**
     * 构建主题交换机
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(MQConstants.TOPIC_EXCHANGE);
    }

    /**
     * 绑定路由key
     * 该绑定路由绑定 topic.1 队列
     */
    @Bean
    public Binding topic1Binding() {
        return BindingBuilder.bind(topic1Queue()).to(exchange()).with(MQConstants.TOPIC1_ROUTING_KEY);
    }

    /**
     * * 代表1个任意单词 # 代表任意个任意单词
     * 该绑定路由 可以绑定 topic.1 和 topic.2 两个队列
     */
    @Bean
    public Binding topicAllBinding() {
        return BindingBuilder.bind(topic2Queue()).to(exchange()).with(MQConstants.TOPIC_ALL_ROUTING_KEY);
    }

}

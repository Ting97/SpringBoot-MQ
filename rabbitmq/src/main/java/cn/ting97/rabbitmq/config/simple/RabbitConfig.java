package cn.ting97.rabbitmq.config.simple;

import cn.ting97.rabbitmq.utils.MQConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className RabbitConfig
 * @Description 队列rabbit配置
 * @date 2021-02-22
 */
@Configuration
public class RabbitConfig {
    /**
     * 构建简单的队列，不声明交换机，队列会自动绑定默认的交换机，不声明绑定路由关系，默认路由Key为队列名
     */
    @Bean
    public Queue helloQueue() {
        return new Queue(MQConstants.HELLO_QUEUE);
    }

    @Bean
    public Queue hello123Queue() {
        return new Queue(MQConstants.HELLO123_QUEUE);
    }
}

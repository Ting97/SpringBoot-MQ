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
    @Bean
    public Queue HelloQueue() {
        return new Queue(MQConstants.HELLO_QUEUE);
    }

    @Bean
    public Queue Hello123Queue() {
        return new Queue(MQConstants.HELLO123_QUEUE);
    }
}

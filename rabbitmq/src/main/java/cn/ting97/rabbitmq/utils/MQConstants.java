package cn.ting97.rabbitmq.utils;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className MQConstants
 * @Description 队列常量
 * @date 2021-02-23
 */
public class MQConstants {
    /**
     * 简单队列
     */
    public static final String HELLO_QUEUE = "hello";
    /**
     * 一对多队列
     */
    public static final String HELLO123_QUEUE = "hello123";

    /**
     * 主题交换机
     */
    public static final String TOPIC_EXCHANGE = "topicExchange";
    /**
     * 主题队列1
     */
    public static final String TOPIC1_QUEUE = "topic.1";
    /**
     * 主题队列2
     */
    public static final String TOPIC2_QUEUE = "topic.2";
    /**
     * 主题队列1规则
     */
    public static final String TOPIC1_ROUTING_KEY = "topic.1.key";
    /**
     * 主题队列2规则
     */
    public static final String TOPIC2_ROUTING_KEY = "topic.2.key";
    /**
     * 主题队列ALL规则
     */
    public static final String TOPIC_ALL_ROUTING_KEY = "topic.#";

    /**
     * 直连配置交换机
     */
    public static final String DIRECT_EXCHANGE = "directExchange";
    /**
     * 直连配置队列 1
     */
    public static final String DIRECT1_QUEUE = "direct.1";
    /**
     * 直连配置队列 2
     */
    public static final String DIRECT2_QUEUE = "direct.2";
    /**
     * 直连配置队列1路由key
     */
    public static final String DIRECT1_ROUTING_KEY = "direct.1.key";
    /**
     * 直连配置队列2路由key
     */
    public static final String DIRECT2_ROUTING_KEY = "direct.2.key";

    /**
     * 广播配置交换机
     * 1. 广播交换机没有路由key的说法，只要绑定交换机之后队列都可以收到。
     */
    public static final String FANOUT_EXCHANGE = "fanoutExchange";
    /**
     * 广播配置队列 1
     */
    public static final String FANOUT1_QUEUE = "fanout.1";
    /**
     * 广播配置队列 2
     */
    public static final String FANOUT2_QUEUE = "fanout.2";

    /**
     * 延时交换机
     */
    public static final String DELAY_EXCHANGE = "delayExchange";
    /**
     * 死信交换机
     */
    public static final String DEAD_EXCHANGE = "deadExchange";
    /**
     * 延时队列
     */
    public static final String DELAY_QUEUE = "delay";
    /**
     * 死信队列
     */
    public static final String DEAD_QUEUE = "dead";
    /**
     * 延时队列路由key
     */
    public static final String DELAY_ROUTING_KEY = "delay.key";
    /**
     * 死信队列路由key
     */
    public static final String DEAD_ROUTING_KEY = "dead.key";

    /**
     * 延迟队列交换机2
     */
    public static final String DELAYED_EXCHANGE = "delayedExchange";
    /**
     * 延迟队列
     */
    public static final String DELAYED_QUEUE = "delayed.queue";
    /**
     * 延迟队列路由
     */
    public static final String DELAYED_ROUTING_KEY = "delayed.routing.key";
}

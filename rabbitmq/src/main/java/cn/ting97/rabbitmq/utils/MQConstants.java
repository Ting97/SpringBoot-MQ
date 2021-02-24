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
    public static final String HELLO_QUEUE = "cn.ting97.queues.hello";
    /**
     * 一对多队列
     */
    public static final String HELLO123_QUEUE = "cn.ting97.queues.hello123";

    /**
     * 主题交换机
     */
    public static final String TOPIC_EXCHANGE = "cn.ting97.queues.topicExchange";
    /**
     * 主题队列1
     */
    public static final String TOPIC1_QUEUE = "cn.ting97.queues.topic.1";
    /**
     * 主题队列2
     */
    public static final String TOPIC2_QUEUE = "cn.ting97.queues.topic.2";
    /**
     * 主题队列1规则
     */
    public static final String TOPIC1_ROUTING_KEY = "cn.ting97.queues.topic.1.key";
    /**
     * 主题队列2规则
     */
    public static final String TOPIC2_ROUTING_KEY = "cn.ting97.queues.topic.2.key";
    /**
     * 主题队列ALL规则
     */
    public static final String TOPIC_ALL_ROUTING_KEY = "cn.ting97.queues.topic.#";

    /**
     * 直连配置交换机
     */
    public static final String DIRECT_EXCHANGE = "cn.ting97.queues.directExchange";
    /**
     * 直连配置队列 1
     */
    public static final String DIRECT1_QUEUE = "cn.ting97.queues.direct.1";
    /**
     * 直连配置队列 2
     */
    public static final String DIRECT2_QUEUE = "cn.ting97.queues.direct.2";
    /**
     * 直连配置队列1路由key
     */
    public static final String DIRECT1_ROUTING_KEY = "cn.ting97.queues.direct.1.key";
    /**
     * 直连配置队列2路由key
     */
    public static final String DIRECT2_ROUTING_KEY = "cn.ting97.queues.direct.2.key";

    /**
     * 广播配置交换机
     * 1. 广播交换机没有路由key的说法，只要绑定交换机之后队列都可以收到。
     */
    public static final String FANOUT_EXCHANGE = "cn.ting97.queues.fanoutExchange";
    /**
     * 广播配置队列 1
     */
    public static final String FANOUT1_QUEUE = "cn.ting97.queues.fanout.1";
    /**
     * 广播配置队列 2
     */
    public static final String FANOUT2_QUEUE = "cn.ting97.queues.fanout.2";

    /**
     * 延时交换机
     */
    public static final String DELAY_EXCHANGE = "cn.ting97.queues.delayExchange";
    /**
     * 死信交换机
     */
    public static final String DEAD_EXCHANGE = "cn.ting97.queues.deadExchange";
    /**
     * 延时队列
     */
    public static final String DELAY_QUEUE = "cn.ting97.queues.delay";
    /**
     * 死信队列
     */
    public static final String DEAD_QUEUE = "cn.ting97.queues.dead";
    /**
     * 延时队列路由key
     */
    public static final String DELAY_ROUTING_KEY = "cn.ting97.queues.delay.key";
    /**
     * 死信队列路由key
     */
    public static final String DEAD_ROUTING_KEY = "cn.ting97.queues.dead.key";

    /**
     * 延迟队列交换机2
     */
    public static final String DELAYED_EXCHANGE = "cn.ting97.queues.delayedExchange";
    /**
     * 延迟队列
     */
    public static final String DELAYED_QUEUE = "cn.ting97.queues.delayed.queue";
    /**
     * 延迟队列路由
     */
    public static final String DELAYED_ROUTING_KEY = "cn.ting97.queues.delayed.routing.key";
}

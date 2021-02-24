package cn.ting97.rabbitmq.controller;

import cn.ting97.rabbitmq.sender.TopicSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className TopicController
 * @Description 主题controller
 * @date 2021-02-23
 */
@RestController
@RequestMapping("/rabbitmq/topic")
public class TopicController {
    private final TopicSender topicSender;

    public TopicController(TopicSender topicSender) {this.topicSender = topicSender;}

    @RequestMapping(value = "/topic1", method = RequestMethod.GET)
    public String topic1() {
        topicSender.sendTopic1();
        return "topic 1";
    }

    @RequestMapping(value = "/topic2", method = RequestMethod.GET)
    public String topic2() {
        int times = 10;
        for (int i = 0; i < times; ++i) {
            topicSender.sendTopic2(i);
        }
        return "topic 2";
    }
}

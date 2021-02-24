package cn.ting97.rabbitmq.controller;

import cn.ting97.rabbitmq.sender.DelaySender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DelayController
 * @Description 延迟队列
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/rabbitmq/delayQueue")
public class DelayController {
    private final DelaySender delaySender;

    public DelayController(DelaySender delaySender) {this.delaySender = delaySender;}

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String delaySender(String message, Integer ttl) {
        delaySender.send(message, ttl);
        return message;
    }

    @RequestMapping(value = "/toolSend", method = RequestMethod.GET)
    public String delayedSender(String message, Integer ttl) {
        delaySender.toolSend(message, ttl);
        return message;
    }

}

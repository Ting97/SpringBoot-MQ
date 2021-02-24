package cn.ting97.rabbitmq.controller;

import cn.ting97.rabbitmq.sender.SimpleSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className Hello123Controller
 * @Description 队列发送controller
 * @date 2021-02-23
 */
@RestController
@RequestMapping("/rabbitmq/queue")
public class SimpleQueueController {
    private final SimpleSender simpleSender;

    public SimpleQueueController(SimpleSender simpleSender) {this.simpleSender = simpleSender;}

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        simpleSender.send();
        return "hello 1";
    }

    @RequestMapping(value = "/hello123", method = RequestMethod.GET)
    public String hello123() {
        int max = 10;
        for (int i = 0; i < max; ++i) {
            simpleSender.send(i);
        }
        return "hello 10";
    }
}

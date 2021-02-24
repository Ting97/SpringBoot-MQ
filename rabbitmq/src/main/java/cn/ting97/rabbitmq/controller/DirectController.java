package cn.ting97.rabbitmq.controller;

import cn.ting97.rabbitmq.sender.DirectSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className DirectController
 * @Description 直连交换机
 * @date 2021-02-23
 */
@RestController
@RequestMapping("/rabbitmq/direct")
public class DirectController {

    private final DirectSender directSender;

    public DirectController(DirectSender directSender) {this.directSender = directSender;}

    @RequestMapping(value = "/direct1", method = RequestMethod.GET)
    public String topic1() {
        directSender.directSend1();
        return "direct 1";
    }

    @RequestMapping(value = "/direct2", method = RequestMethod.GET)
    public String topic2() {
        int times = 10;
        for (int i = 0; i < times; ++i) {
            directSender.directSend2(i);
        }
        return "direct 2";
    }
}

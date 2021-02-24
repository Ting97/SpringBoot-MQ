package cn.ting97.rabbitmq.controller;

import cn.ting97.rabbitmq.sender.FanoutSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className FanoutController
 * @Description 广播交换机配置队列测试
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/rabbitmq/fanout")
public class FanoutController {
    private final FanoutSender fanoutSender;

    FanoutController(FanoutSender fanoutSender) {
        this.fanoutSender = fanoutSender;
    }

    @RequestMapping(value = "/fanout", method = RequestMethod.GET)
    public String fanout() {
        int times = 10;
        for (int i = 0; i < times; ++i) {
            fanoutSender.fanoutSend(i);
        }
        return "fanout 1";
    }
}

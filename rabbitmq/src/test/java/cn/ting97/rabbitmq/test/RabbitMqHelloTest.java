package cn.ting97.rabbitmq.test;

import cn.ting97.rabbitmq.sender.SimpleSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className Test
 * @Description hello测试
 * @date 2021-02-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private SimpleSender simpleSender;

    /**
     * 简单使用
     */
    @Test
    public void hello() {
        simpleSender.send();
    }

    /**
     * 发送:接收 一对多
     */
    @Test
    public void hello123() {
        for (int i = 0; i < 100; ++i) {
            simpleSender.send(i);
        }
    }

}
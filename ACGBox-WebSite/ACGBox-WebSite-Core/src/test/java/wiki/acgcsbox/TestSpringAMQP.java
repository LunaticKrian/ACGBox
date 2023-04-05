package wiki.acgcsbox;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Krian
 * @version 1.0
 * @description: SpringAMQP 测试类
 * @date 2023/4/4 0004 15:36
 */
@SpringBootTest
public class TestSpringAMQP {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2SimpleQueue() {
        String queueName = "simple.queue";
        String message = "hello, this is spring amqp !";
        // 发送消息给消息队列：
        rabbitTemplate.convertAndSend(queueName, message);
    }

}

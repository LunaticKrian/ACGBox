package wiki.acgbox.mall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krian
 * @version 1.0
 * @description: OrderApplication，端口号 9002
 * @date 2023/5/15 0015 9:32
 */
@MapperScan("wiki.acgbox.mall.order.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}

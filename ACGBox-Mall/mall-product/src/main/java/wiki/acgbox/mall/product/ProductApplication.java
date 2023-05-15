package wiki.acgbox.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krian
 * @version 1.0
 * @description: ProductApplication 启动类，端口 9001
 * @date 2023/5/15 0015 9:03
 */
@MapperScan("wiki.acgbox.mall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}

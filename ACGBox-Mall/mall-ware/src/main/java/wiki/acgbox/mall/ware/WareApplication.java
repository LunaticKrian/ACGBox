package wiki.acgbox.mall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krian
 * @version 1.0
 * @description: WareApplication 端口号 9005
 * @date 2023/5/15 0015 12:34
 */
@MapperScan("wiki.acgbox.mall.ware.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class WareApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class, args);
    }
}

package wiki.acgbox.mall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krian
 * @version 1.0
 * @description: CouponApplication 启动类，端口 9003
 * @date 2023/5/15 0015 12:28
 */
@MapperScan("wiki.acgbox.mall.coupon.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class CouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }
}

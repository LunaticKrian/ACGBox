package wiki.acgbox.mall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krian
 * @version 1.0
 * @description: MemberApplication 端口号 9004
 * @date 2023/5/15 0015 12:30
 */
@MapperScan("wiki.acgbox.mall.user.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}

package wiki.csbox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author Krian
 * @version 1.0
 * @description: RedisTemplate测试类
 * @date 2023/4/17 0017 9:23
 */
@SpringBootTest(classes = wiki.acgcsbox.MediaApplication.class)
public class RedisTemplateTest {

    class Person {
        String username;
        int age;

        public Person(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void testSetObjectValue() {
        // 获取RedisTemplate操作集合对象：
        ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();
        // 向Redis中存储对象：
        valueOperations.set("userInfo", new Person("krian", 22));
        //从Redis中获取对象，然后解析对象：
        Person person = (Person) valueOperations.get("userInfo");
        System.out.println("从缓存中获取对象信息：" + person);
    }
}

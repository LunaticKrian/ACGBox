package wiki.acgcsbox.tool;

import cn.hutool.core.util.ObjectUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author : XiaoBai
 * @apiNote :
 * @date : 2023/4/4 22:26
 */
@Slf4j
@Component
public class WorkerIdProvider {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

    @Setter
    @Value("${spring.application.name:empty}")
    private String serviceName;

    private static final String KEY_PRE = "SnowFlakeWorkerId";

    /**
     * 获取当前服务的当前实例的workerId
     *
     * @param max workerId最大值。从0开始,比如支持32个机器则最大值为31
     * @return java.lang.Long
     * @author : huangyunyang
     * @date : 2020/4/15 15:19
     */
    public Long nextWorkerId(long max) {

        String key = KEY_PRE + ":" + serviceName;
        Long workerId = stringRedisTemplate.opsForValue().increment(key, 1);
        if (ObjectUtil.isNull(workerId)) {
            return max;
        }

        // workerId已经超过最大值则重置
        if (workerId > max) {
            workerId = workerId % max - 1;
            // 同时将redis中的数据重置
            cas(key, workerId, max);
        }
        log.warn("WorkerId提供[{}]： [{}]服务获取workerId[{}]", KEY_PRE, serviceName, workerId);
        return workerId;
    }

    private void cas(String key, Long workerId, Long max) {

        stringRedisTemplate.execute(
                (RedisCallback<Object>)
                        connection -> {
                            while (true) {
                                byte[] keyBytes = stringRedisSerializer.serialize(key);
                                connection.watch(keyBytes);
                                assert keyBytes != null;
                                long redisWorkerId =
                                        Long.parseLong(
                                                Objects.requireNonNull(stringRedisSerializer.deserialize(connection.get(keyBytes))));
                                connection.multi();
                                // 只有当redis中的值超过max范围或者当前要设置的workerId比redis中的值大时，才进行设置
                                if (redisWorkerId > max || workerId > redisWorkerId) {
                                    connection.set(
                                            keyBytes, Objects.requireNonNull(stringRedisSerializer.serialize(workerId.toString())));
                                }
                                try {
                                    connection.exec();
                                } catch (Exception e) {
                                    continue;
                                }
                                break;
                            }
                            return null;
                        });
    }
}

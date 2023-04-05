package wiki.acgcsbox.util;

/**
 * @author Krian
 * @version 1.0
 * @description: 日期时间工具类
 * @date 2023/4/3 0003 16:34
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 获取当前系统时间
     *
     * @return String 系统时间
     */
    public static String getLocalTime() {
        // 获取当前时间：
        Date date = new Date();
        // 格式化时间：
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}

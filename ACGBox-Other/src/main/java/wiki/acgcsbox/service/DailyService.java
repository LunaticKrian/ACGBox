package wiki.acgcsbox.service;

import wiki.acgcsbox.constant.Result;

/**
 * @author Krian
 * @version 1.0
 * @description: 日常安排Service抽象层
 * @date 2023/4/12 0012 16:50
 */
public interface DailyService {

    /**
     * 给定一个随机参数，使用这个随机参数获取今天要吃什么
     *
     * @param number 随机参数
     * @return 吃的信息
     */
    Result<String> getEatInfo(int number);
}

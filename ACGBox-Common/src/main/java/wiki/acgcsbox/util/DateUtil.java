package wiki.acgcsbox.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author : XiaoBai
 * @apiNote :
 * @date : 2023/4/4 22:35
 */
public class DateUtil {

    /** 一秒有多少毫秒 **/
    public static final long RATE_SECOND = 1000;
    /** 一分钟有多少毫秒 **/
    public static final long RATE_MINUTE = 60 * RATE_SECOND;
    /** 一小时有多少毫秒 **/
    public static final long RATE_HOUR = 60 * RATE_MINUTE;
    /** 一天有多少毫秒 **/
    public static final long RATE_DAY = 24 * RATE_HOUR;

    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_DM = "yyyy-MM-dd HH:mm";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT_yyyyMMdd = "yyyyMMdd";
    public static final String DATETIME_FORMAT_MONTH = "yyyy-MM";
    public static final String DATETIME_FORMAT_CN= "yyyy年MM月dd日";
    /**
     * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";
    // 时间格式化
    private static DateFormat dateTimeFormat = null;
    private static DateFormat dateFormat = null;
    private static DateFormat dateFormatMonth = null;
    private static DateFormat dateFormatDM = null;
    private static DateFormat dateFormatyyyyMMdd = null;
    private static Calendar gregorianCalendar = null;
    private static DateFormat dateFormatCN = null;
    private static DateFormat dateFormatYYYYMMDDHHMISS = null;

    static {
        dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        dateFormatDM = new SimpleDateFormat(DATETIME_FORMAT_DM);
        dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        dateFormatMonth = new SimpleDateFormat(DATETIME_FORMAT_MONTH);
        gregorianCalendar = new GregorianCalendar();
        dateFormatyyyyMMdd=new SimpleDateFormat(DATETIME_FORMAT_yyyyMMdd);
        dateFormatCN = new SimpleDateFormat(DATETIME_FORMAT_CN);
        dateFormatYYYYMMDDHHMISS = new SimpleDateFormat(DATE_TIME_FORMAT_YYYYMMDDHHMISS);
    }

    public static Date addYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static Date addHour(Date date, int hourNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hourNum);
        return calendar.getTime();
    }

    public static Date addMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static Date addSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    public static Date addMillisecond(Date date, int millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, millisecond);
        return calendar.getTime();
    }

    public static Date setYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    public static Date setMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static Date setDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static Date setMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static Date setSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    public static Date setMillisecond(Date date, int millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return calendar.getTime();
    }

    /**
     * 转换为标准的字符串, 如 2012-08-08 20:00:00.000
     *
     * @param date 待处理的日期
     * @return 日期字符串
     */
    public static String toNormativeString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(date);
    }

    /**
     * 转换为日期字符串, 如 2012-08-08
     *
     * @param date 待处理的日期
     * @return 日期字符串
     */
    public static String toDateString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    /**
     * 转换为日期字符串, 如 20120808
     *
     * @param date 待处理的日期
     * @return 日期字符串
     */
    public static String toNoSymbolDateString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    /**
     * 转换为日期字符串, 如 2012年8月8日
     *
     * @param date 待处理的日期
     * @return 日期字符串
     */
    public static String toCNDateString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
        return sdf.format(date);
    }

    /**
     * 转换为时间字符串, 如 20:00:00.000
     *
     * @param date 待处理的日期
     * @return 时间字符串
     */
    public static String toTimeString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 转换为日期加时间字符串, 如 2012-08-08 20:00:00
     *
     * @param date 待处理的日期
     * @return 日期字符串
     */
    public static String toDateTimeString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 转换为第1时间<br>
     * Calendar.YEAR=当年第1时间, Calendar.MONTH=当月第1时间, Calendar.DAY_OF_MONTH=当日第1时间, ...<br>
     * 如 toFirstTime(2016-08-08 20:30:40.500, Calendar.YEAR) --- 2016-01-01 00:00:00.000<br>
     * 如 toFirstTime(2016-08-08 20:30:40.500, Calendar.MONTH) --- 2016-08-01 00:00:00.000<br>
     * 如 toFirstTime(2016-08-08 20:30:40.500, Calendar.DAY_OF_MONTH) --- 2016-08-08 00:00:00.000<br>
     * 如 toFirstTime(2016-08-08 20:30:40.500, Calendar.HOUR_OF_DAY) --- 2016-08-08 20:00:00.000<br>
     * 如 toFirstTime(2016-08-08 20:30:40.500, Calendar.MINUTE) --- 2016-08-08 20:30:00.000<br>
     * 如 toFirstTime(2016-08-08 20:30:40.500, Calendar.SECOND) --- 2016-08-08 20:30:40.000<br>
     *
     * @param date 待处理的日期
     * @param field 类型
     * @return 第1时间
     */
    public static Date toFirstTime(Date date, int field) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (field) {
            case Calendar.YEAR:
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
            case Calendar.MONTH:
                calendar.set(Calendar.DAY_OF_MONTH, 1);
            case Calendar.DAY_OF_MONTH:
                calendar.set(Calendar.HOUR_OF_DAY, 0);
            case Calendar.HOUR_OF_DAY:
                calendar.set(Calendar.MINUTE, 0);
            case Calendar.MINUTE:
                calendar.set(Calendar.SECOND, 0);
            case Calendar.SECOND:
                calendar.set(Calendar.MILLISECOND, 0);
        }
        return calendar.getTime();
    }

    /**
     * 转换为最后时间<br>
     * Calendar.YEAR=当年最后时间, Calendar.MONTH=当月最后时间, Calendar.DAY_OF_MONTH=当日最后时间, ...<br>
     * 如 toLastTime(2016-08-08 20:30:40.500, Calendar.YEAR) --- 2016-12-31 23:59:59.999<br>
     * 如 toLastTime(2016-08-08 20:30:40.500, Calendar.MONTH) --- 2016-08-31 23:59:59.999<br>
     * 如 toLastTime(2016-08-08 20:30:40.500, Calendar.DAY_OF_MONTH) --- 2016-08-08 23:59:59.999<br>
     * 如 toLastTime(2016-08-08 20:30:40.500, Calendar.HOUR_OF_DAY) --- 2016-08-08 20:59:59.999<br>
     * 如 toLastTime(2016-08-08 20:30:40.500, Calendar.MINUTE) --- 2016-08-08 20:30:59.999<br>
     * 如 toLastTime(2016-08-08 20:30:40.500, Calendar.SECOND) --- 2016-08-08 20:30:40.999<br>
     *
     * @param date 待处理的日期
     * @param field 类型
     * @return 最后时间
     */
    public static Date toLastTime(Date date, int field) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (field) {
            case Calendar.YEAR:
                calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            case Calendar.MONTH:
                // 下月1日的前一天
                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            case Calendar.DAY_OF_MONTH:
                calendar.set(Calendar.HOUR_OF_DAY, 23);
            case Calendar.HOUR_OF_DAY:
                calendar.set(Calendar.MINUTE, 59);
            case Calendar.MINUTE:
                calendar.set(Calendar.SECOND, 59);
            case Calendar.SECOND:
                calendar.set(Calendar.MILLISECOND, 999);
        }
        return calendar.getTime();
    }

    /**
     * 转换为结束时间, 即设置时分秒为00:00:00
     *
     * @param date 待处理的日期
     * @return 结束时间
     */
    public static Date toStartTime(Date date) {
        if (date == null) {
            return null;
        }
        return toFirstTime(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 转换为结束时间, 即设置时分秒为23:59:59
     *
     * @param date 待处理的日期
     * @return 结束时间
     */
    public static Date toEndTime(Date date) {
        if (date == null) {
            return null;
        }
        return toLastTime(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当天的毫秒数
     *
     * @param date
     * @return
     */
    public static long getMillisOfDay(Date date) {
        Date start = toStartTime(date);
        return date.getTime() - start.getTime();
    }

    /**
     * 时间格式化
     *
     * @param date yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getDateTimeFormat(String date) {
        try {
            return dateTimeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 时间格式化
     *
     * @param date yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateTimeFormat(Date date) {
        return dateTimeFormat.format(date);
    }

    /**
     * 时间格式化
     *
     * @param date yyyy-MM-dd HH:mm
     * @return
     */
    public static Date getDateTimeFormatDM(String date) {
        try {
            return dateFormatDM.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间格式化
     *
     * @param date yyyy-MM-dd
     * @return
     */
    public static String getDateFormat(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 获取指定月的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        String dateFormat = getDateFormat(gregorianCalendar.getTime());
        return getDateFormat(dateFormat);
    }

    /**
     * 获取指定月的第一天 yyyy-mm-dd
     *
     * @param date
     * @return
     */
    public static String getStringFirstDayofMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        String dateFormat = getDateFormat(gregorianCalendar.getTime());
        return dateFormat;
    }

    /**
     * 获取指定月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        gregorianCalendar.add(Calendar.MONTH, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        String dateFormat = getDateFormat(gregorianCalendar.getTime());
        return getDateFormat(dateFormat);
    }

    /**
     * 获取指定月的第一天 00:00:00
     *
     * @param date
     * @return
     */
    public static String getFirstDayTimeOfMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        return getDateTimeFormat(getCurrentStart(gregorianCalendar.getTime()));
    }

    /**
     * 获取指定月的最后一天 23:59:59
     *
     * @param date
     * @return
     */
    public static String getLastDayTimeOfMonth(Date date) {
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        gregorianCalendar.add(Calendar.MONTH, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        return getDateTimeFormat(getCurrentend(gregorianCalendar.getTime()));
    }

    /**
     * 获取日期前一天
     *
     * @param date
     * @return
     */
    public static Date getDayBefore(Date date) {
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day - 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 日期格式化
     * yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static Date getDateFormat(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDateFormatHFS(String yyyyMMdd) {
        try {
            return dateFormatyyyyMMdd.parse(yyyyMMdd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDateFormat14(String yyyyMMddHHmmss) {
        try {
            return dateFormatYYYYMMDDHHMISS.parse(yyyyMMddHHmmss);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStringFormatHFS(Date yyyyMMdd) {
        return dateFormatyyyyMMdd.format(yyyyMMdd);
    }

    /**
     * yyyy-MM 转换
     * @param date
     * @return
     */
    public static Date getDateFormatMonth(String date) {
        try {
            return dateFormatMonth.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * yyyy-MM 转换
     * @param date
     * @return
     */
    public static String getDateFormatMonth(Date date) {
        return dateFormatMonth.format(date);
    }
    /**
     * 获取日期后一天
     *
     * @param date
     * @return
     */
    public static Date getDayAfter(Date date) {
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day + 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取某一天的开始时间
     *
     * @param date
     * @return
     */
    public static Date getCurrentStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date start = calendar.getTime();
        return start;
    }

    /**
     * 获取某一天的结束时间
     *
     * @param date
     * @return
     */
    public static Date getCurrentend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date end = calendar.getTime();

        return end;
    }
    /**
     * 获取当前年
     *
     * @return
     */
    public static int getNowYear() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static int getNowMonth() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当月天数
     *
     * @return
     */
    public static int getNowMonthDay() {
        Calendar d = Calendar.getInstance();
        return d.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取时间段的每一天
     *
     * @return 日期列表
     */
    public static List<Date> getEveryDay(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        // 格式化日期(yy-MM-dd)
        startDate = DateUtil.getDateFormat(getDateFormat(startDate));
        endDate = DateUtil.getDateFormat(getDateFormat(endDate));
        List<Date> dates = new ArrayList<Date>();
        gregorianCalendar.setTime(startDate);
        dates.add(gregorianCalendar.getTime());
        while (gregorianCalendar.getTime().compareTo(endDate) < 0) {
            // 加1天
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, 1);
            dates.add(gregorianCalendar.getTime());
        }
        return dates;
    }

    /**
     * 获取提前多少个月
     *
     * @param monty
     * @return
     */
    public static Date getFirstMonth(int monty) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -monty);
        return c.getTime();
    }

    /**
     * 获取当年的第一天
     *
     * @return
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     *
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 获取当前日期上个月时间
     *
     * @param date
     * @return
     */
    public static Date getBeforeDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取当前日期下个月时间
     *
     * @param date
     * @return
     */
    public static Date getAfterDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1); // 设置为下一个月
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取前30天
     */
    public static Date getBeforeMonth(Date today) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String endDate = sdf.format(today);//当前日期
        //获取三十天前日期
        Calendar theCa = Calendar.getInstance();
        theCa.setTime(today);
        theCa.add(Calendar.DATE, -30);//最后一个数字30可改，30天的意思
        Date start = theCa.getTime();


        return start;
    }


    /**
     * 获取当前年月yy-mm
     */
    public static String getNowYearMonth() {
        /**
         * 获取当前日期前30天
         * */
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        if (month < 10) {
            return year + "-0" + month;
        } else {
            return year + "-" + month;
        }
    }


    /**
     * 获取两个日期的24小时相差天数
     */
    public static long getBetweenDays(Date start, Date end) {
        long time = 0;
        try {
            start = dateFormat.parse(dateFormat.format(start));
            end = dateFormat.parse(dateFormat.format(end));
            gregorianCalendar.setTime(start);
            long time1 = gregorianCalendar.getTimeInMillis();
            gregorianCalendar.setTime(end);
            long time2 = gregorianCalendar.getTimeInMillis();

            time = (time2 - time1) / (1000 * 3600 * 24);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return time;
    }

    /**
     * 获取某月有多少天
     *
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取某天是星期几 Wed
     *
     * @return
     */
    public static String getWeekByDate(Date date) {
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE", Locale.CANADA);
        String currSun = dateFm.format(date);
        return currSun.substring(0, 3);
    }

    /**
     * 获取某一天凌晨四点
     * @param date
     * @return
     */
    public static Date getCurrentDay4Am(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date end = calendar.getTime();
        return end;
    }
    /**
     * 获取前一天一天凌晨四点
     * @param date
     * @return
     */
    public static Date getBeforeDay4Am(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day - 1);
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        Date end = calendar.getTime();
        return end;
    }

    /**
     * 获取当前时间后一天凌晨4点
     * @param date
     * @return
     */
    public static Date getAfterDay4Am(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day + 1);
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        Date end = calendar.getTime();
        return end;
    }

    /**
     * 获取天 yyyy-MM-dd
     * @param date
     * @return
     */
    public static Date getDay(Date date) {
        return getDateFormat(getDateFormat(date));
    }
    /**
     * 获取当前日期上个个月时间
     *
     * @param date
     * @return
     */
    public static Date getMornDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        return date;
    }
    /**
     * 获得当天23时59分59秒
     * @return
     */
    public Date firstDateByDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
    /**
     * 获得当天0时0分0秒
     * @return
     */
    public Date listDateByDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    /**
     * 得到几天前的0点时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        return now.getTime();
    }
    /**
     * 得到当天的23.59.59点时间
     *
     * @param d
     * @param
     * @return
     */
    public static Date getNewdDayTime(Date d) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.HOUR, 23);
        now.set(Calendar.MINUTE, 59);
        now.set(Calendar.SECOND, 59);
        return now.getTime();
    }

    /**
     * 判断某个时间是否在区间内
     * @param nowTime  当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @Author 蔡迪
     * @Description 获取两个日期之间的所有日期集合
     * @Date 18:56 2019/5/15
     * @Param [startTime yyyy-MM-dd, endTime yyyy-MM-dd]
     * @return yyyy-MM-dd的list
     **/
    public static List<String> getDays(String startTime, String endTime) {

        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }

    /**
     * @Author 蔡迪
     * @Description 获取两个日期之间的所有日期集合
     * @Date 18:56 2019/5/15
     * @Param [startTime, endTime]
     * @return 返回Date的list
     **/
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }
    /**
     * 获取明日日期
     * @Param
     * @return
     */
    public static String getTomorrowFormat(Date d){
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + 1);//把日期往后增加一天.整数往后推,负数往前移动
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(now.getTime());
        return dateString;
    }
    /**
     * 获取某个月之前的日期
     * @Param
     * @return
     */
    public static String getSomeAfterMonth(Date d){
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) - 3);//把日期往后增加一天.整数往后推,负数往前移动
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(now.getTime());
        return dateString;
    }
    /**
     * 获取日期前某天
     *
     * @param date
     * @return
     */
    public static Date getDayBefore1(Date date,Integer days) {
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day - days);
        return gregorianCalendar.getTime();
    }
    //获取本周的开始时间
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    //获取本周的结束时间
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    //获取某个日期的开始时间
    public static Date getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d){
            calendar.setTime(d);
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }
        return calendar.getTime();
    }

    //获取某个日期的结束时间
    public static Date getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d){
            calendar.setTime(d);
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
            calendar.set(Calendar.MILLISECOND, 999);
        }
        return calendar.getTime();
    }

    /**
     * 转换为日期字符串, 如 8月8日9:00
     *
     * @param date 待处理的日期
     * @return 日期字符串
     */
    public static String toMDHMDateString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("M月d日H:mm");
        return sdf.format(date);
    }

    /**
     * 获取日期后几天
     *
     * @param date
     * @return
     */
    public static Date getDayAfter(Date date, int num) {
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day + num);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前月份, 如 01
     * @return 日期字符串
     */
    public static String getCurrentMonth(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month = cal.get(Calendar.MONTH) + 1;
        if (month > 9) {
            return month + "";
        } else {
            return  "0" + month;
        }
    }
    /**
     * 转换为日期字符串, 如 2019年8月8日9:00:01
     *
     * @param date 待处理的日期
     * @return 日期字符串
     */
    public static String toYMDHMSDateString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 根据生日获取年龄
     * @param birthDay
     * @return
     */
    public static int getAgeByBirth(Date birthDay) {
        int age = 0;
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;//当前日期在生日之前，年龄减一
                }
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        age=age<0?0:age;
        return age;
    }

    /**
     * 根据日期获取季度数值
     * @param date
     * @return
     */
    public static int getQuarter(Date date) {
        gregorianCalendar.setTime(date);
        int month = gregorianCalendar.get(Calendar.MONTH)+1;
        Double quarter = Math.ceil((float)month/3);
        return quarter.intValue();
    }

    /**
     * 功能描述: 获取指定日期所属季度的起始时间
     *
     * @auther: 盛夏
     * @date: 2020/10/29 11:00
     */
    public static String getQuarterStartTime(Date date) {
        int quarter = getQuarter(date);
        int month = (quarter-1)*3;// Calendar月份从0开始计数，要-1
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(gregorianCalendar.get(Calendar.YEAR), month, 1, 0, 0, 0);
        return getDateTimeFormat(gregorianCalendar.getTime());
    }

    /**
     * 功能描述: 获取当前日期的上个季度的第一天
     *
     * @auther: 盛夏
     * @date: 2020/10/29 16:09
     */
    public static Date lastQuarterStartDate(Date date) {
        int quarter = getQuarter(date);
        int month = (quarter-1)*3;// Calendar月份从0开始计数，要-1
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(gregorianCalendar.get(Calendar.YEAR), month, 1, 0, 0, 0);
        gregorianCalendar.add(Calendar.MONTH,-3);
        return gregorianCalendar.getTime();
    }

    /**
     * 时间格式化
     *
     * @param date yyyy年MM月dd日
     * @return
     */
    public static String getDateFormatCN(Date date) {
        return dateFormatCN.format(date);
    }

    /**
     * 获取指定时间范围的间隔分钟数
     *
     * @param start 起始时间
     * @param end   结束时间
     * @return 间隔分钟数
     */
    public static long getIntervalMinute(LocalDateTime start, LocalDateTime end) {
        return getInterval(start, end).toMinutes();
    }

    /**
     * 获取指定时间范围的间隔
     *
     * @param start 起始时间
     * @param end   结束时间
     * @return 间隔
     */
    private static Duration getInterval(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end);
    }

    /**
     * Date转LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        // 转为时间戳
        Instant instant = date.toInstant();
        // UTC时间(世界协调时间,UTC + 00:00)转北京(北京,UTC + 8:00)时间
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转Date
     *
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}

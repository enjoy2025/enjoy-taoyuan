package com.taoyuan.enjoy.framework.common.utils;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * 日期处理
 *
 * @author enjoy
 * @version 1.0
 */
public class DateUtils {
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 设置时区 默认系统时区
     */
    public static final ZoneId ZONE_ID = ZoneId.systemDefault();

    /**
     * yyyy-MM-dd HH
     */
    public static final String DEFAULT_HOUR_FORMAT = "yyyy-MM-dd HH";

    /**
     * yyyyMMdd
     */
    public static final String DATE_FORMAT = "yyyyMMdd";

    /**
     * 获取两个日期相差的天数
     *
     * @param startDateStr 开始日期字符串
     * @param endDateStr   结束日期字符串
     * @param format       格式
     * @return 相差天数
     */
    public static long getDaysBetween(String startDateStr, String endDateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * 判断日期是否是今天
     *
     * @param date 指定日期
     * @return 是否
     */
    public static boolean isDateToday(Date date) {
        return isDateToday(toLocalDate(date));
    }

    /**
     * 判断日期是否是今天
     *
     * @param date 指定日期
     * @return 是否
     */
    public static boolean isDateToday(LocalDate date) {
        return LocalDate.now().isEqual(date);
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param date1 日期
     * @param date2 日期
     * @return 是否
     */
    public static boolean isSameDay(Date date1, Date date2) {
        return isSameDay(toLocalDate(date1), toLocalDate(date2));
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param date1 日期
     * @param date2 日期
     * @return 是否
     */
    public static boolean isSameDay(LocalDate date1, LocalDate date2) {
        return date1.isEqual(date2);
    }

    /**
     * 时间戳转字符串时间格式 yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr 日期字符串
     * @param format  日期格式字符串
     * @return 指定字符串时间格式
     */
    public static Date formatDate(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return toDate(date);
    }

    /**
     * 时间戳转字符串时间格式 yyyy-MM-dd HH:mm:ss
     *
     * @param timeStamp 时间戳
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String formatDate(long timeStamp) {
        return formatDate(timeStamp, DATE_TIME_PATTERN);
    }

    /**
     * 时间戳转字符串时间格式
     *
     * @param timeStamp 时间戳
     * @param format    指定格式
     * @return 指定字符串时间格式
     */
    public static String formatDate(long timeStamp, String format) {
        return Instant.ofEpochMilli(timeStamp).atZone(ZONE_ID).format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 时间戳转LocalDateTime
     *
     * @param timeStamp 时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(long timeStamp) {
        return Instant.ofEpochMilli(timeStamp).atZone(ZONE_ID).toLocalDateTime();
    }

    /**
     * LocalDateTime转时间戳
     *
     * @param dateTime
     * @return timeStamp
     */
    public static long toTimeStamp(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 时间戳转LocalDate
     *
     * @param timeStamp 时间戳
     * @return LocalDate
     */
    public static LocalDate toLocalDate(long timeStamp) {
        return Instant.ofEpochMilli(timeStamp).atZone(ZONE_ID).toLocalDate();
    }

    /**
     * Date转LocalDate
     *
     * @param date Date日期
     * @return LocalDate日期
     */
    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalDate();
    }

    /**
     * Date转LocalDateTime
     *
     * @param date Date
     * @return LocalDateTime日期时间
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalDateTime();
    }

    /**
     * LocalDate转Date
     *
     * @param date LocalDate日期
     * @return Dater日期
     */
    public static Date toDate(LocalDate date) {
        return Date.from(date.atStartOfDay().atZone(ZONE_ID).toInstant());
    }

    /**
     * LocalDateTime转Date
     *
     * @param date LocalDateTime日期时间
     * @return Dater日期
     */
    public static Date toDate(LocalDateTime date) {
        return Date.from(date.atZone(ZONE_ID).toInstant());
    }

    /**
     * 获取当前DateTime
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String nowDateTime() {
        return nowDateTime(DATE_TIME_PATTERN);
    }

    /**
     * 获取当前DateTime
     *
     * @return yyyyMMdd
     */
    public static String nowDate() {
        return localDateStr(LocalDate.now(), DATE_FORMAT);
    }

    /**
     * 获取指定日期格式的当前日期
     *
     * @param format 指定日期格式
     * @return 获取指定日期格式的当前日期
     */
    public static String nowDateTime(String format) {
        return localDateTimeStr(LocalDateTime.now(), format);
    }

    /**
     * LocalDate日期转String
     *
     * @param date LocalDate日期
     * @return yyyy-MM-dd
     */
    public static String localDateStr(LocalDate date) {
        return localDateStr(date, DATE_PATTERN);
    }

    /**
     * LocalDate日期转String
     *
     * @param date   LocalDate日期
     * @param format 指定日期格式
     * @return 指定日期格式字符串
     */
    public static String localDateStr(LocalDate date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * LocalDateTime转String
     *
     * @param dateTime LocalDateTime
     * @return 指定日期格式字符串
     */
    public static String localDateTimeStr(LocalDateTime dateTime) {
        return localDateTimeStr(dateTime, DATE_TIME_PATTERN);
    }

    /**
     * LocalDateTime转String
     *
     * @param dateTime LocalDateTime
     * @param format   指定日期格式
     * @return 指定日期格式字符串
     */
    public static String localDateTimeStr(LocalDateTime dateTime, String format) {
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 指定日期格式化
     *
     * @param date   Date日期
     * @param format 指定日期格式
     * @return 指定日期格式的字符串
     */
    public static String formatStr(Date date, String format) {
        return localDateTimeStr(toLocalDateTime(date), format);
    }

    /**
     * 默认日期格式化
     *
     * @param date Date日期
     * @return 指定日期格式的字符串
     */
    public static String formatStr(Date date) {
        return localDateTimeStr(toLocalDateTime(date), DATE_TIME_PATTERN);
    }

    /**
     * 指定日期格式化
     *
     * @param date   日期字符串
     * @param format 指定日期格式
     * @return 指定格式的日期字符串
     */
    public static String formatStr(String date, String format) {
        return localDateTimeStr(LocalDateTime.parse(date), format);
    }

    /**
     * @param date   日期字符串
     * @param format 指定日期格式
     * @return 指定日期
     */
    public static LocalDateTime localDateTime(String date, String format) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * @param date 日期字符串
     * @return 指定日期
     */
    public static LocalDateTime localDateTime(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    /**
     * 字符串时间转日期
     *
     * @param date   日期字符串
     * @param format 指定日期格式
     * @return 指定日期
     */
    public static LocalDate localDate(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 获取指定日期的最小时间
     *
     * @param date 指定日期 Date
     * @return 返回指定日期的最小时间yyyy-MM-dd '00:00'
     */
    public static Date toMinTime(Date date) {
        return toDate(LocalDateTime.of(toLocalDate(date), LocalTime.MIN));
    }

    /**
     * 根据指定日期获取下一天的最小时间
     *
     * @param date 指定日期
     * @return yyyy-MM-dd 00:00:00
     */
    public static Date toMinTimeNextDay(Date date) {
        return toDate(LocalDateTime.of(toLocalDate(date).plusDays(1L), LocalTime.MIN));
    }

    /**
     * 获取指定日期的最大时间
     *
     * @param date 指定日期 Date
     * @return 返回指定日期的最大时间yyyy-MM-dd '23:59:59.999999999'
     */
    public static Date toMaxTime(Date date) {
        return toDate(LocalDateTime.of(toLocalDate(date), LocalTime.MAX));
    }

    /**
     * 获取指定日期的最小时间
     *
     * @param date 指定日期 LocalDate
     * @return 返回指定日期的最小时间yyyy-MM-dd '00:00'
     */
    public static LocalDateTime toMinTime(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MIN);
    }

    /**
     * 获取指定日期的最大时间
     *
     * @param date 指定日期 LocalDate
     * @return 返回指定日期的最大时间yyyy-MM-dd '23:59:59.999999999'
     */
    public static LocalDate toMaxDate(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MAX).toLocalDate();
    }

    public static LocalDateTime toMaxTime(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MAX);
    }

    /**
     * 比较日期是否相同 dateA = dateB
     *
     * @param dateA 2021-10-16
     * @param dateB 2021-10-16
     * @return 是否
     */
    public static boolean beEqual(LocalDate dateA, LocalDate dateB) {
        return dateA.isEqual(dateB);
    }

    /**
     * 比较日期是否小于 dateA < dateB
     *
     * @param dateA 2021-10-15
     * @param dateB 2021-10-16
     * @return 是否
     */
    public static boolean lessThan(LocalDate dateA, LocalDate dateB) {
        return dateA.isBefore(dateB);
    }

    /**
     * 比较日期是否小于等于 dateA <= dateB
     *
     * @param dateA 2021-10-15
     * @param dateB 2021-10-16
     * @return 是否
     */
    public static boolean lessThanOrEqual(LocalDate dateA, LocalDate dateB) {
        return dateA.isBefore(dateB) || dateA.isEqual(dateB);
    }

    /**
     * 比较日期是否大于 dateA > dateB
     *
     * @param dateA 2021-10-16
     * @param dateB 2021-10-15
     * @return 是否
     */
    public static boolean greaterThan(LocalDate dateA, LocalDate dateB) {
        return dateA.isAfter(dateB);
    }

    /**
     * 比较日期是否大于等于 dateA >= dateB
     *
     * @param dateA 2021-10-16
     * @param dateB 2021-10-15
     * @return 是否
     */
    public static boolean greaterThanOrEqual(LocalDate dateA, LocalDate dateB) {
        return dateA.isAfter(dateB) || dateA.isEqual(dateB);
    }

    /**
     * 获取一天中的时间(从当前时间开始递减)
     *
     * @param hours 递减小时
     * @return yyyy-MM-dd HH 格式的字符串数组
     */
    public static String[] inMultipleHour(int hours) {
        String[] hoursString = new String[hours];
        LocalDateTime now = LocalDateTime.now();
        hoursString[0] = localDateTimeStr(now, DEFAULT_HOUR_FORMAT);
        for (int i = 1; i < hoursString.length; i++) {
            LocalDateTime newTime = now.minusHours(i);
            hoursString[i] = localDateTimeStr(newTime, DEFAULT_HOUR_FORMAT);
        }
        return hoursString;
    }

    /**
     * 根据当前日期递减指定的天数
     *
     * @param days 递减天数
     * @return 指定多少天内的字符串日期数组 yyyy-MM-dd
     */
    public static String[] inMultipleDay(int days) {
        return inMultipleDay(days, DATE_PATTERN);
    }

    /**
     * 根据当前日期递减指定的天数
     *
     * @param days   递减天数
     * @param format 指定日期格式
     * @return 指定多少天内的字符串日期数组
     */
    public static String[] inMultipleDay(int days, String format) {
        String[] daysString = new String[days];
        LocalDateTime now = LocalDateTime.now();
        daysString[0] = localDateTimeStr(now, format);
        for (int i = 1; i < daysString.length; i++) {
            LocalDateTime newTime = now.minusDays(i);
            daysString[i] = localDateTimeStr(newTime, format);
        }
        return daysString;
    }

    /**
     * 计算两个日期之间相差小时数
     *
     * @param temporal1 时间1
     * @param temporal2 时间2
     * @param formatter 对应的字符串日期格式
     * @return 相差小时数
     */
    public static long betweenHours(String temporal1, String temporal2, String formatter) {
        return between(temporal1, temporal2, formatter, DateUnitEnum.HOUR);
    }

    /**
     * 计算两个日期之间相差天数
     *
     * @param temporal1 时间1
     * @param temporal2 时间2
     * @param formatter 对应的字符串日期格式
     * @return 相差天数
     */
    public static long betweenDays(String temporal1, String temporal2, String formatter) {
        return between(temporal1, temporal2, formatter, DateUnitEnum.DAY);
    }

    /**
     * 计算两个日期之间相差值
     *
     * @param temporal1 时间1
     * @param temporal2 时间2
     * @param formatter 对应的字符串日期格式
     * @param dateUnit  指定日期单位：年、月、日、时、分、秒、周、毫秒、微秒、纳秒
     * @return 相差值
     */
    public static long between(String temporal1, String temporal2, String formatter, DateUnitEnum dateUnit) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        LocalDateTime time1 = LocalDateTime.parse(temporal1, dateTimeFormatter);
        LocalDateTime time2 = LocalDateTime.parse(temporal2, dateTimeFormatter);
        return between(time1, time2, dateUnit);
    }

    /**
     * Description: 计算两个日期之间相差数
     *
     * @param temporal1 时间1
     * @param temporal2 时间2
     * @param dateUnit  指定日期单位：年、月、日、时、分、秒、周、毫秒、微秒、纳秒
     * @return 根据DateUnitEnum间相差数
     */
    public static long between(Date temporal1, Date temporal2, DateUnitEnum dateUnit) {
        return between(toLocalDateTime(temporal1), toLocalDateTime(temporal2), dateUnit);
    }

    /**
     * 计算两个日期之间相差值
     *
     * @param temporal1 时间1
     * @param temporal2 时间2
     * @param dateUnit  指定日期单位：年、月、日、时、分、秒、周、毫秒、微秒、纳秒
     * @return 相差值
     */
    public static long between(LocalDateTime temporal1, LocalDateTime temporal2, DateUnitEnum dateUnit) {
        switch (dateUnit) {
            case YEAR:
                return ChronoUnit.YEARS.between(temporal1, temporal2);
            case MONTH:
                return ChronoUnit.MONTHS.between(temporal1, temporal2);
            case DAY:
                return ChronoUnit.DAYS.between(temporal1, temporal2);
            case HOUR:
                return ChronoUnit.HOURS.between(temporal1, temporal2);
            case MINUTE:
                return ChronoUnit.MINUTES.between(temporal1, temporal2);
            case SECOND:
                return ChronoUnit.SECONDS.between(temporal1, temporal2);
            case WEEK:
                return ChronoUnit.WEEKS.between(temporal1, temporal2);
            case MILLI:
                return ChronoUnit.MILLIS.between(temporal1, temporal2);
            case MICRO:
                return ChronoUnit.MICROS.between(temporal1, temporal2);
            case NANO:
                return ChronoUnit.NANOS.between(temporal1, temporal2);
            default:
                break;
        }
        return 0;
    }

    /**
     * 日期时间分割获取指定日期单元的开始日期和结束日期
     *
     * @param date 指定分割日期
     * @return yyyy-MM-dd(当天和第二天)
     */
    public static Date[] dateSplit(Date date) {
        return dateSplit(date, DateUnitEnum.DAY);
    }

    /**
     * 日期时间分割获取指定日期单元的开始日期和结束日期
     *
     * @param date     指定分割日期
     * @param dateUnit 日期单位 ：年、月、日、周
     * @return yyyy-MM-dd 年(当年的第一天和最后一天)、月(当月的第一天和最后一天)、日(当天和第二天)、周(当周的第一天和最后一天)
     */
    public static Date[] dateSplit(Date date, DateUnitEnum dateUnit) {
        LocalDate[] localDates = dateSplit(toLocalDate(date), dateUnit);
        if (localDates.length == 0) {
            return new Date[0];
        }
        Date[] split = new Date[2];
        split[0] = toDate(localDates[0]);
        split[1] = toDate(localDates[1]);
        return split;
    }

    /**
     * 日期时间分割获取指定日期单元的开始日期和结束日期
     *
     * @param date     指定分割日期
     * @param dateUnit 日期单位 ：年、月、日、周
     * @return yyyy-MM-dd 年(当年的第一天和最后一天)、月(当月的第一天和最后一天)、日(当天和第二天)、周(当周的第一天和最后一天)
     */
    public static LocalDate[] localDateSplit(Date date, DateUnitEnum dateUnit) {
        return dateSplit(toLocalDate(date), dateUnit);
    }

    /**
     * 日期时间分割获取指定日期单元的开始日期和结束日期
     *
     * @param localDate 指定分割日期
     * @param dateUnit  日期单位 ：年、月、日、周
     * @return yyyy-MM-dd 年(当年的第一天和最后一天)、月(当月的第一天和最后一天)、日(当天和第二天)、周(当周的第一天和最后一天)
     */
    public static LocalDate[] dateSplit(LocalDate localDate, DateUnitEnum dateUnit) {
        LocalDate[] split = new LocalDate[2];
        switch (dateUnit) {
            case YEAR:
                split[0] = localDate.with(TemporalAdjusters.firstDayOfYear());
                split[1] = localDate.with(TemporalAdjusters.lastDayOfYear());
                return split;
            case MONTH:
                split[0] = localDate.with(TemporalAdjusters.firstDayOfMonth());
                split[1] = localDate.with(TemporalAdjusters.lastDayOfMonth());
                return split;
            case WEEK:
                TemporalField temporalField = WeekFields.of(Locale.FRANCE).dayOfWeek();
                split[0] = localDate.with(temporalField, 1);
                split[1] = localDate.with(temporalField, 7);
                return split;
            case DAY:
                split[0] = localDate;
                split[1] = localDate.plusDays(1);
                return split;
            default:
                break;
        }
        return new LocalDate[0];
    }

    /**
     * 日期时间分割获取指定日期单元的开始时间和结束时间
     *
     * @param date     指定分割日期
     * @param dateUnit 日期单位 ：年、月、日、周
     * @return yyyy-MM-dd HH:mm:ss 年(今年的开始时间和结束时间)、月(本月的开始时间和结束时间)、日(本天的开始时间和结束时间)、周(本周的开始时间和结束时间)
     */
    public static Date[] dateTimeSplit(Date date, DateUnitEnum dateUnit) {
        LocalDateTime[] localDateTimes = localDateTimeSplit(date, dateUnit);
        if (localDateTimes.length == 0) {
            return new Date[0];
        }
        Date[] split = new Date[2];
        split[0] = toDate(localDateTimes[0]);
        split[1] = toDate(localDateTimes[1]);
        return split;
    }

    /**
     * 日期时间分割获取指定日期单元的开始时间和结束时间
     *
     * @param date     指定分割日期
     * @param dateUnit 日期单位 ：年、月、日、周
     * @return yyyy-MM-dd HH:mm:ss 年(今年的开始时间和结束时间)、月(本月的开始时间和结束时间)、日(本天的开始时间和结束时间)、周(本周的开始时间和结束时间)
     */
    public static LocalDateTime[] localDateTimeSplit(Date date, DateUnitEnum dateUnit) {
        return dateTimeSplit(localDateSplit(date, dateUnit), dateUnit);
    }

    /**
     * 日期时间分割获取指定日期单元的开始时间和结束时间
     *
     * @param localDate 指定分割日期
     * @param dateUnit  日期单位 ：年、月、日、周
     * @return yyyy-MM-dd HH:mm:ss 年(今年的开始时间和结束时间)、月(本月的开始时间和结束时间)、日(本天的开始时间和结束时间)、周(本周的开始时间和结束时间)
     */
    public static LocalDateTime[] localDateTimeSplit(LocalDate localDate, DateUnitEnum dateUnit) {
        return dateTimeSplit(dateSplit(localDate, dateUnit), dateUnit);
    }

    /**
     * LocalDate[]转LocalDateTime[]
     *
     * @param localDates LocalDate[]
     * @param dateUnit   日期单位 ：年、月、日、周
     * @return LocalDateTime[]
     */
    private static LocalDateTime[] dateTimeSplit(LocalDate[] localDates, DateUnitEnum dateUnit) {
        if (localDates.length == 0) {
            return new LocalDateTime[0];
        }
        LocalDateTime[] split = new LocalDateTime[2];
        split[0] = LocalDateTime.of(localDates[0], LocalTime.MIN);
        if (Objects.requireNonNull(dateUnit) == DateUnitEnum.DAY) {
            split[1] = LocalDateTime.of(localDates[1].minusDays(1), LocalTime.MAX);
        }
        split[1] = LocalDateTime.of(localDates[1], LocalTime.MAX);
        return split;
    }

    /**
     * 根据指定日期 + 周期 判断是否是今天
     *
     * @param startDate 指定日期
     * @param dateUnit  周期单位
     * @param cycle     周期
     * @return true|false
     */
    public static boolean isToday(LocalDate startDate, DateUnitEnum dateUnit, long cycle) {
        LocalDate generationDate = null;
        LocalDate currentDate = LocalDate.now();
        if (beEqual(startDate, currentDate)) {
            return true;
        }
        switch (dateUnit) {
            case YEAR:
                while (Objects.isNull(generationDate) || lessThan(generationDate, currentDate)) {
                    generationDate = (Objects.isNull(generationDate)) ? startDate.plusYears(cycle) : generationDate.plusYears(cycle);
                }
                break;
            case MONTH:
                while (Objects.isNull(generationDate) || lessThan(generationDate, currentDate)) {
                    generationDate = (Objects.isNull(generationDate)) ? startDate.plusMonths(cycle) : generationDate.plusMonths(cycle);
                }
                break;
            case WEEK:
                while (Objects.isNull(generationDate) || lessThan(generationDate, currentDate)) {
                    generationDate = (Objects.isNull(generationDate)) ? startDate.plusWeeks(cycle) : generationDate.plusWeeks(cycle);
                }
                break;
            case DAY:
                while (Objects.isNull(generationDate) || lessThan(generationDate, currentDate)) {
                    generationDate = (Objects.isNull(generationDate)) ? startDate.plusDays(cycle) : generationDate.plusDays(cycle);
                }
                break;
            default:
                return false;
        }
        return beEqual(generationDate, currentDate);
    }

    public static String datePath() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.now().format(formatter);
    }


    /**
     * 日期单位枚举
     */
    public enum DateUnitEnum {
        /**
         * 年
         */
        YEAR,
        /**
         * 月
         */
        MONTH,
        /**
         * 日
         */
        DAY,
        /**
         * 周
         */
        WEEK,
        /**
         * 小时
         */
        HOUR,
        /**
         * 分钟
         */
        MINUTE,
        /**
         * 秒
         */
        SECOND,
        /**
         * 毫秒
         */
        MILLI,
        /**
         * 微秒
         */
        MICRO,
        /**
         * 纳秒
         */
        NANO
    }

}

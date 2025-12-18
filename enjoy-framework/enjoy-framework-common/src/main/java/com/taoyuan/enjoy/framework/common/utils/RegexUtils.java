package com.taoyuan.enjoy.framework.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * 提供常用的正则验证和处理功能
 *
 * @author enjoy
 * @version 1.0
 */
public class RegexUtils {

    // 常用正则表达式模式
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PHONE_PATTERN = "^1[3-9]\\d{9}$";
    private static final String ID_CARD_PATTERN = "^[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}[\\dXx]$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8,}$";
    private static final String URL_PATTERN = "^https?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
    private static final String IP_PATTERN = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    private static final String CHINESE_PATTERN = "^[\\u4e00-\\u9fa5]+$";
    private static final String NUMBER_PATTERN = "^-?\\d+(\\.\\d+)?$";
    private static final String POSITIVE_INTEGER_PATTERN = "^[1-9]\\d*$";
    private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final String TIME_PATTERN = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";
    private static final String HEX_COLOR_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
    private static final String BANK_CARD_PATTERN = "^[1-9]\\d{15,18}$";
    private static final String POSTAL_CODE_PATTERN = "^[1-9]\\d{5}$";

    // 编译后的Pattern对象，提高性能
    private static final Pattern EMAIL_COMPILED = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern PHONE_COMPILED = Pattern.compile(PHONE_PATTERN);
    private static final Pattern ID_CARD_COMPILED = Pattern.compile(ID_CARD_PATTERN);
    private static final Pattern PASSWORD_COMPILED = Pattern.compile(PASSWORD_PATTERN);
    private static final Pattern URL_COMPILED = Pattern.compile(URL_PATTERN);
    private static final Pattern IP_COMPILED = Pattern.compile(IP_PATTERN);
    private static final Pattern CHINESE_COMPILED = Pattern.compile(CHINESE_PATTERN);
    private static final Pattern NUMBER_COMPILED = Pattern.compile(NUMBER_PATTERN);
    private static final Pattern POSITIVE_INTEGER_COMPILED = Pattern.compile(POSITIVE_INTEGER_PATTERN);
    private static final Pattern DATE_COMPILED = Pattern.compile(DATE_PATTERN);
    private static final Pattern TIME_COMPILED = Pattern.compile(TIME_PATTERN);
    private static final Pattern HEX_COLOR_COMPILED = Pattern.compile(HEX_COLOR_PATTERN);
    private static final Pattern BANK_CARD_COMPILED = Pattern.compile(BANK_CARD_PATTERN);
    private static final Pattern POSTAL_CODE_COMPILED = Pattern.compile(POSTAL_CODE_PATTERN);

    // 私有构造函数，防止实例化
    private RegexUtils() {}

    /**
     * 验证邮箱格式
     * @param email 邮箱地址
     * @return 是否有效
     */
    public static boolean isEmail(String email) {
        return email != null && EMAIL_COMPILED.matcher(email).matches();
    }

    /**
     * 验证手机号格式
     * @param phone 手机号
     * @return 是否有效
     */
    public static boolean isPhone(String phone) {
        return phone != null && PHONE_COMPILED.matcher(phone).matches();
    }

    /**
     * 验证身份证号格式
     * @param idCard 身份证号
     * @return 是否有效
     */
    public static boolean isIdCard(String idCard) {
        return idCard != null && ID_CARD_COMPILED.matcher(idCard).matches();
    }

    /**
     * 验证密码强度（至少8位，包含大小写字母和数字）
     * @param password 密码
     * @return 是否符合要求
     */
    public static boolean isStrongPassword(String password) {
        return password != null && PASSWORD_COMPILED.matcher(password).matches();
    }

    /**
     * 验证URL格式
     * @param url URL地址
     * @return 是否有效
     */
    public static boolean isUrl(String url) {
        return url != null && URL_COMPILED.matcher(url).matches();
    }

    /**
     * 验证IP地址格式
     * @param ip IP地址
     * @return 是否有效
     */
    public static boolean isIp(String ip) {
        return ip != null && IP_COMPILED.matcher(ip).matches();
    }

    /**
     * 验证是否为中文
     * @param text 文本
     * @return 是否为中文
     */
    public static boolean isChinese(String text) {
        return text != null && CHINESE_COMPILED.matcher(text).matches();
    }

    /**
     * 验证数字格式
     * @param num 数字字符串
     * @return 是否为数字
     */
    public static boolean isNumber(String num) {
        return num != null && NUMBER_COMPILED.matcher(num).matches();
    }

    /**
     * 验证正整数
     * @param num 数字字符串
     * @return 是否为正整数
     */
    public static boolean isPositiveInteger(String num) {
        return num != null && POSITIVE_INTEGER_COMPILED.matcher(num).matches();
    }

    /**
     * 验证日期格式 (YYYY-MM-DD)
     * @param date 日期字符串
     * @return 是否有效
     */
    public static boolean isDate(String date) {
        return date != null && DATE_COMPILED.matcher(date).matches();
    }

    /**
     * 验证时间格式 (HH:MM:SS)
     * @param time 时间字符串
     * @return 是否有效
     */
    public static boolean isTime(String time) {
        return time != null && TIME_COMPILED.matcher(time).matches();
    }

    /**
     * 验证十六进制颜色值
     * @param color 颜色值
     * @return 是否有效
     */
    public static boolean isHexColor(String color) {
        return color != null && HEX_COLOR_COMPILED.matcher(color).matches();
    }

    /**
     * 验证银行卡号
     * @param cardNumber 银行卡号
     * @return 是否有效
     */
    public static boolean isBankCard(String cardNumber) {
        return cardNumber != null && BANK_CARD_COMPILED.matcher(cardNumber).matches();
    }

    /**
     * 验证邮政编码
     * @param postalCode 邮政编码
     * @return 是否有效
     */
    public static boolean isPostalCode(String postalCode) {
        return postalCode != null && POSTAL_CODE_COMPILED.matcher(postalCode).matches();
    }

    /**
     * 提取字符串中的数字
     * @param str 输入字符串
     * @return 数字列表
     */
    public static List<String> extractNumbers(String str) {
        List<String> numbers = new ArrayList<>();
        if (str != null) {
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                numbers.add(matcher.group());
            }
        }
        return numbers;
    }

    /**
     * 提取字符串中的邮箱
     * @param str 输入字符串
     * @return 邮箱列表
     */
    public static List<String> extractEmails(String str) {
        List<String> emails = new ArrayList<>();
        if (str != null) {
            Matcher matcher = EMAIL_COMPILED.matcher(str);
            while (matcher.find()) {
                emails.add(matcher.group());
            }
        }
        return emails;
    }

    /**
     * 提取字符串中的URL
     * @param str 输入字符串
     * @return URL列表
     */
    public static List<String> extractUrls(String str) {
        List<String> urls = new ArrayList<>();
        if (str != null) {
            Matcher matcher = URL_COMPILED.matcher(str);
            while (matcher.find()) {
                urls.add(matcher.group());
            }
        }
        return urls;
    }

    /**
     * 提取字符串中的手机号
     * @param str 输入字符串
     * @return 手机号列表
     */
    public static List<String> extractPhones(String str) {
        List<String> phones = new ArrayList<>();
        if (str != null) {
            Matcher matcher = PHONE_COMPILED.matcher(str);
            while (matcher.find()) {
                phones.add(matcher.group());
            }
        }
        return phones;
    }

    /**
     * 替换敏感词（用*代替）
     * @param str 原始字符串
     * @param keywords 敏感词数组
     * @return 替换后的字符串
     */
    public static String replaceSensitiveWords(String str, String[] keywords) {
        if (str == null || keywords == null) {
            return str;
        }

        String result = str;
        for (String keyword : keywords) {
            if (keyword != null && !keyword.isEmpty()) {
                String replacement = "*".repeat(keyword.length());
                result = result.replaceAll("(?i)" + Pattern.quote(keyword), replacement);
            }
        }
        return result;
    }

    /**
     * 脱敏处理（隐藏部分字符）
     * @param str 原始字符串
     * @param start 开始位置
     * @param end 结束位置
     * @param mask 掩码字符，默认为*
     * @return 脱敏后的字符串
     */
    public static String mask(String str, int start, int end, char mask) {
        if (str == null || str.length() <= start + end) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, start));
        sb.append(String.valueOf(mask).repeat(str.length() - start - end));
        sb.append(str.substring(str.length() - end));
        return sb.toString();
    }

    /**
     * 脱敏处理（使用默认掩码*）
     * @param str 原始字符串
     * @param start 开始位置
     * @param end 结束位置
     * @return 脱敏后的字符串
     */
    public static String mask(String str, int start, int end) {
        return mask(str, start, end, '*');
    }

    /**
     * 手机号脱敏
     * @param phone 手机号
     * @return 脱敏后的手机号
     */
    public static String maskPhone(String phone) {
        return mask(phone, 3, 4);
    }

    /**
     * 身份证脱敏
     * @param idCard 身份证号
     * @return 脱敏后的身份证号
     */
    public static String maskIdCard(String idCard) {
        return mask(idCard, 6, 4);
    }

    /**
     * 邮箱脱敏
     * @param email 邮箱地址
     * @return 脱敏后的邮箱
     */
    public static String maskEmail(String email) {
        if (email == null) {
            return null;
        }

        int atIndex = email.indexOf('@');
        if (atIndex == -1) {
            return email;
        }

        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex);
        String maskedUsername = mask(username, 1, 1);
        return maskedUsername + domain;
    }

    /**
     * 自定义验证
     * @param str 待验证字符串
     * @param pattern 正则表达式
     * @return 是否匹配
     */
    public static boolean validate(String str, String pattern) {
        return str != null && Pattern.compile(pattern).matcher(str).matches();
    }

    /**
     * 自定义验证
     * @param str 待验证字符串
     * @param pattern 编译后的正则表达式
     * @return 是否匹配
     */
    public static boolean validate(String str, Pattern pattern) {
        return str != null && pattern.matcher(str).matches();
    }

    /**
     * 获取匹配结果
     * @param str 输入字符串
     * @param pattern 正则表达式
     * @return 匹配结果列表
     */
    public static List<String> match(String str, String pattern) {
        List<String> matches = new ArrayList<>();
        if (str != null) {
            Pattern compiled = Pattern.compile(pattern);
            Matcher matcher = compiled.matcher(str);
            while (matcher.find()) {
                matches.add(matcher.group());
            }
        }
        return matches;
    }

    /**
     * 获取匹配结果
     * @param str 输入字符串
     * @param pattern 编译后的正则表达式
     * @return 匹配结果列表
     */
    public static List<String> match(String str, Pattern pattern) {
        List<String> matches = new ArrayList<>();
        if (str != null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                matches.add(matcher.group());
            }
        }
        return matches;
    }

    /**
     * 替换匹配的内容
     * @param str 原始字符串
     * @param pattern 正则表达式
     * @param replacement 替换内容
     * @return 替换后的字符串
     */
    public static String replace(String str, String pattern, String replacement) {
        return str != null ? str.replaceAll(pattern, replacement) : null;
    }

    /**
     * 替换匹配的内容
     * @param str 原始字符串
     * @param pattern 编译后的正则表达式
     * @param replacement 替换内容
     * @return 替换后的字符串
     */
    public static String replace(String str, Pattern pattern, String replacement) {
        return str != null ? pattern.matcher(str).replaceAll(replacement) : null;
    }

    /**
     * 分割字符串
     * @param str 原始字符串
     * @param pattern 分割模式
     * @return 分割后的数组
     */
    public static String[] split(String str, String pattern) {
        return str != null ? str.split(pattern) : new String[0];
    }

    /**
     * 清理HTML标签
     * @param html HTML字符串
     * @return 纯文本
     */
    public static String stripHtml(String html) {
        return html != null ? html.replaceAll("<[^>]*>", "") : null;
    }

    /**
     * 清理多余空格
     * @param str 原始字符串
     * @return 清理后的字符串
     */
    public static String cleanSpaces(String str) {
        return str != null ? str.replaceAll("\\s+", " ").trim() : null;
    }

    /**
     * 转换为驼峰命名
     * @param str 原始字符串
     * @return 驼峰命名字符串
     */
    public static String toCamelCase(String str) {
        if (str == null) {
            return null;
        }

        Pattern pattern = Pattern.compile("-([a-z])");
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 转换为短横线命名
     * @param str 驼峰命名字符串
     * @return 短横线命名字符串
     */
    public static String toKebabCase(String str) {
        return str != null ? str.replaceAll("([A-Z])", "-$1").toLowerCase() : null;
    }

    /**
     * 转义特殊字符
     * @param str 原始字符串
     * @return 转义后的字符串
     */
    public static String escapeRegExp(String str) {
        return str != null ? str.replaceAll("([.*+?^${}()|\\[\\]\\\\])", "\\\\$1") : null;
    }
}
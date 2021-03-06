package com.ruoyi.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author 海
 * @version 1.0
 * @date 2019\6\16 0016 12:56
 */
public class UUIDGenUtil {

    /**
     * 用户id和随机数总长度
     */
    private static final int maxLength = 5;

    /**
     * 随即编码
     */
    private static final String[] code = new String[]{"A", "B", "C", "D", "E", "F", "G", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    /**
     * 更具id进行加密+加随机数组成固定长度编码
     */
    private static String toCode(Long id) {
        String idStr = id.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1; i >= 0; i--) {
            idsbs.append(code[idStr.charAt(i) - '0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }

    /**
     * 生成时间戳
     */
    private static String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    /**
     * 生成固定长度随机码
     *
     * @param len 长度
     */
    private static long getRandom(long len) {
        long min = 1, max = 9;
        for (int i = 1; i < len; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }

    /**
     * 生成不带类别标头的编码
     *
     */
    public static synchronized String getCode() {
        //id = id == null ? 1000 : id;
        int count = 0;
        String result = "";
        try {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                count = random.nextInt(51) + 10;
            }
            result = getDateTime() + toCode(Long.valueOf(count));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getCode());

    }

    public static String getHashCode(String preFix) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString().replace("-", "");
        if (!StringUtils.isEmpty(preFix))
            uuidStr = uuidStr + preFix;
        return uuidStr;
    }
}
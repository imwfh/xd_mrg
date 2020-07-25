package com.ruoyi.common.redis;

/**
 * Created by MR.Wu on 2019-06-12.
 */
public class RedisKey {

    /**
     * 过期时间 5 分钟
     */
    public static final int TIME_OUT_MIN = 60 * 5;

    /**
     * 手机号前缀
     */
    public static final String PRE_FIX_PHONE = "PRE_FIX_PHONE";

    /**
     * 验证码前缀
     */
    public static final String PRE_FIX_SMS_CODE = "PRE_FIX_SMS_CODE";

    /**
     * 验证码前缀 60S限制
     */
    public static final String PRE_FIX_SMS_CODE_SIX = "SIX_PRE_FIX_SMS_CODE";

    /**
     * 商品属性
     */
    public static final String GOODS_ATTR = "GOODS_ATTR";

    /**
     * 商品信息
     */
    public static final String GOODS_INFO = "GOODS_INFO";

    /**
     * 用户登录
     */
    public static final String LOGIN_USER_INFO = "LOGIN_USER_INFO";

    /**
     * 购物车列表
     */
    public static final String SHOPPING_CART_LIST = "SHOPPING_CART_LIST";

    /**
     * 物流类型
     */
    public static final String SHIPPING_TYPES = "SHIPPING_TYPES";

    /**
     * 登录RSA key
     */
    public static final String LOGIN_USER_RSA_KEY = "LOGIN_USER_RSA_KEY";

    /**
     * 银行卡信息
     */
    public static final String BANK_INFO_KEY = "BANK_INFO_KEY";

    public static final String SMS_PHONE = "SMS_PHONE";

    public static final String NOTICE_DATAS = "NOTICE_DATAS";

    public static final String SY_CONFIG = "SY_CONFIG";

    public static final String SY_GAME_RATE_ = "SY_GAME_RATE_";

}

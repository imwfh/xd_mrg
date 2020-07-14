package com.ruoyi.common.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

/**
 */

public class JsonStringRedisSerializer implements RedisSerializer<Object> {

    private  Charset charset= Charset.forName("UTF8");


    public JsonStringRedisSerializer() {
        this(Charset.forName("UTF8"));
    }


    public JsonStringRedisSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }

    public <T> T deserialize(byte[] source, Class<T> type) throws SerializationException {
        Assert.notNull(type, "Deserialization type must not be null! Pleaes provide Object.class to make use of Jackson2 default typing.");
        if (isEmpty(source)) {
            return null;
        } else {
            try {
                return JSON.parseObject(source, String.class);
            } catch (Exception var4) {
                throw new SerializationException("Could not read JSON: " + var4.getMessage(), var4);
            }
        }
    }

    @Override
    public Object deserialize(byte[] source) throws SerializationException {
        return this.deserialize(source, Object.class);
    }


    @Override
    public byte[] serialize(Object source) {
        return source == null ? null : JSON.toJSONString(source).getBytes(this.charset);
    }
    boolean isEmpty(byte[] data) {
        return data == null || data.length == 0;
    }

}

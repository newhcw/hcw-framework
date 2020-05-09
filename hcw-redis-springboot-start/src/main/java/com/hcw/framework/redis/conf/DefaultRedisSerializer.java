package com.hcw.framework.redis.conf;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

public class DefaultRedisSerializer implements RedisSerializer<Object> {

    private final Charset charset;

    public DefaultRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public DefaultRedisSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }


    @Override
    public byte[] serialize(Object o) throws SerializationException {
        return o == null ? null : String.valueOf(o).getBytes(charset);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return bytes == null ? null : new String(bytes, charset);

    }
}
package com.leleplus.core.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Redis使用FastJson序列化
 *
 * @author witt
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {


    /**
     * 阿里巴巴的fastJson 报错com.alibaba.fastjson.JSONException: autoType is not support
     * 此错误出现在将json序列化和反序列化 从Redis中拿出和存放时，频繁出现，需要添加一个白名单，同时会报类型转换异常，反序列化的JSON对象不能转换为Java对象
     */
    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        ParserConfig.getGlobalInstance().addAccept("com.leleplus.core.security.LoginUser");

    }

    @SuppressWarnings("unused")
    private ObjectMapper objectMapper = new ObjectMapper();

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    /**
     * JSON序列化
     *
     * @param t
     * @return
     * @throws SerializationException
     */
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    /**
     * JSON 反序列化
     *
     * @param bytes
     * @return
     * @throws SerializationException
     */
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);

        // 反序列化
        return JSON.parseObject(str, clazz);
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        Assert.notNull(objectMapper, "'objectMapper' must not be null");
        this.objectMapper = objectMapper;
    }

    protected JavaType getJavaType(Class<?> clazz) {
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}

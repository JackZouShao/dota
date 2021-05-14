package com.alex.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.redisson.client.codec.BaseCodec;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.Encoder;

/**
 * @version 1.0.0
 * @className FastJson2RedissonAdapter.java
 * @author: yz
 * @date: 2021/5/14 19:11
 */
public class FastJson2RedissonAdapter extends BaseCodec {

//    private final Encoder encoder = in ->{
//        ByteBuf out = ByteBufAllocator.DEFAULT.buffer();
//    };

    @Override
    public Decoder<Object> getValueDecoder() {
        return null;
    }

    @Override
    public Encoder getValueEncoder() {
        return null;
    }
}

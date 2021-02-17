package com.alex.common.util;


import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应消息主体
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RJson<T> {


    private static final long serialVersionUID = 1L;

    private String msg;

    private int code;

    private T data;

    public static <T> RJson<T> ok(){
        return createRJson();
    }

    private static <T> RJson<T> createRJson(){

        RJson rJson = new RJson();

        return rJson;
    }


}

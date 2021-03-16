package com.alex.common.util;


import com.alex.common.constants.HttpStatusCode;
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
        return createRJson(HttpStatusCode.SUCCESS, null, null);
    }

    public static <T> RJson<T> ok(T data){
        return createRJson(HttpStatusCode.SUCCESS, null, data);
    }

    public static <T> RJson<T> ok(T data, String msg){
        return createRJson(HttpStatusCode.SUCCESS, msg, data);
    }

    public static <T> RJson<T> failed(){
        return createRJson(HttpStatusCode.FAILED, null, null);
    }

    public static <T> RJson<T> failed(String msg){
        return createRJson(HttpStatusCode.FAILED, msg, null);
    }

    public static <T> RJson<T> failed(T data){
        return createRJson(HttpStatusCode.FAILED, null, data);
    }

    public static <T> RJson<T> failed(T data, String msg){
        return createRJson(HttpStatusCode.FAILED, msg, data);
    }

    private static <T> RJson<T> createRJson(int code, String msg, T data){
        RJson rJson = new RJson(msg, code, data);
        return rJson;
    }


}

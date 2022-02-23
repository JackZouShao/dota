package com.alex.common.util;


import com.alex.common.constants.HttpStatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 响应消息主体
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class R<T> {


    private static final long serialVersionUID = 1L;

    private String msg;

    private int code;

    private T data;

    public static <T> R<T> ok(){
        return createRJson(HttpStatusCode.SUCCESS, null, null);
    }

    public static <T> R<T> ok(T data){
        return createRJson(HttpStatusCode.SUCCESS, null, data);
    }

    public static <T> R<T> ok(T data, String msg){
        return createRJson(HttpStatusCode.SUCCESS, msg, data);
    }

    public static <T> R<T> failed(){
        return createRJson(HttpStatusCode.FAILED, null, null);
    }

    public static <T> R<T> failed(String msg){
        return createRJson(HttpStatusCode.FAILED, msg, null);
    }

    public static <T> R<T> failed(T data){
        return createRJson(HttpStatusCode.FAILED, null, data);
    }

    public static <T> R<T> failed(T data, String msg){
        return createRJson(HttpStatusCode.FAILED, msg, data);
    }

    public static <T> R<T> failed(String msg, int code){
        return createRJson(code, msg, null);
    }

    private static <T> R<T> createRJson(int code, String msg, T data){
        R<T> r = new R(msg, code, data);
        return r;
    }


    public static R error(int i, String msg) {
        return createRJson(i, msg, null);
    }
}

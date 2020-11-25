package com.pas.mall.entity;

/**
 * 响应回前端的结果封装类
 */
public class RespBean {
    private int code;
    private String msg;
    private Object data;

    private RespBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private RespBean(int code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public static RespBean ok(String msg){

        return new RespBean(200,msg);
    }

    public static RespBean ok(String msg, Object data){

        return new RespBean(200,msg,data);
    }

    public static RespBean error(String msg){

        return new RespBean(500,msg);
    }

    public static RespBean error(String msg, Object data){

        return new RespBean(500,msg,data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

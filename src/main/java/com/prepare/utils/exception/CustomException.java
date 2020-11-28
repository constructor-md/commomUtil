package com.prepare.utils.exception;

import com.prepare.utils.entity.UtilConstant;

public class CustomException extends RuntimeException {


    private String msg;
    private int code;

    public CustomException(String msg){
        super(msg);
        this.msg = msg;
    }

    public CustomException(int code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CustomException(UtilConstant utilConstant){
        super(utilConstant.getMsg());
        this.code = utilConstant.getCode();
        this.msg = utilConstant.getMsg();
    }

    public CustomException(String msg ,Throwable e){
        super(msg,e);
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

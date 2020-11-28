package com.prepare.utils.entity;

public enum UtilConstant{

    ERROR_FILE_IS_NULL(2000,"文件不可为空"),
    ERROR_PARAM_IS_NULL(2001,"参数不可为空");


    private int code;
    private String msg;

    UtilConstant(int code, String msg){
        this.code = code;
        this.msg = msg;
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
}

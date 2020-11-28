package com.prepare.utils.common;

import com.prepare.utils.entity.UtilConstant;
import lombok.Data;

import java.util.HashMap;

/**
 * 通常响应体
 */
@Data
public class R extends HashMap<String,Object> {

    private int code;
    private String msg;

    public R(){
        this.put("code",0);
        this.put("msg","success");
    }

    public static R ok(){
        return new R();
    }

    public static R error(int code,String msg){
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static R error(UtilConstant utilConstant){
        R r = new R();
        r.put("code",utilConstant.getCode());
        r.put("msg",utilConstant.getMsg());
        return r;
    }

}

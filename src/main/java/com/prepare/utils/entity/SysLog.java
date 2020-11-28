package com.prepare.utils.entity;


import lombok.Data;

import java.util.Date;

@Data
public class SysLog {

    private String path;
    private String method;
    private String remark;
    private String params;
    private String visitor;

    private String ip;
    private String netType;

    private long methodExecuteTime;

    private Date visitTime;

}

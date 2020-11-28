package com.prepare.utils.aspect;

import com.alibaba.fastjson.JSON;
import com.prepare.utils.annotation.VisitLogger;
import com.prepare.utils.utils.HttpContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class VisitLoggerAspect {

    /**
     * 需要记录的日志内容：
     * 接口路径、接口备注、HTTP方法、方法入参、方法执行时长、访问者IP地址、访问者网络类型、访问者请求头内容（希望监控爬虫）
     * 访问时间、访问者身份（建立鉴权或用户系统）
     */

    @Pointcut("@annotation(com.prepare.utils.annotation.VisitLogger)")
    public void visitLogPointCut(){

    }

    @Around("visitLogPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        //记录方法执行开始时间
        long begin = System.currentTimeMillis();

        //执行方法
        Object result = point.proceed();

        //记录方法执行时长
        long time = System.currentTimeMillis() - begin;

        //持久化方法执行信息
        saveLog(point,time);

        return result;
    }

    private void saveLog(ProceedingJoinPoint point,long time){
        //获取被代理对象的属性名称集合
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        //获取方法
        Method method = methodSignature.getMethod();
        //获取该方法上该注解
        VisitLogger visitLogger = method.getAnnotation(VisitLogger.class);
        //获取注解内容
        String remark = visitLogger.interfaceRemark();

        //获取被代理的对象，获取类名
        String className = point.getTarget().getClass().getName();
        //获取被代理的方法名称
        String methodName = methodSignature.getName();

        //获取方法入参
        Object[] args = point.getArgs();
        try{
            //线程安全的可变长度字符串
            StringBuffer stringBuffer = new StringBuffer();
            if (args.length > 0){
                for (int i = 0 ; i < args.length ; i ++){
                    if (i == args.length -1){
                        stringBuffer.append(JSON.toJSONString(args[i]));
                    }else{
                        stringBuffer.append(JSON.toJSONString(args[i])).append(";");
                    }
                }
            }

        }catch (Exception e){

        }

        //获取IP
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        if (request != null){
            String ip = HttpContextUtils.getIpAddr(request);
        }


    }

}

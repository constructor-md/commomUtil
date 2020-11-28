package com.prepare.utils.annotation;

import java.lang.annotation.*;

/**
 * 访问记录注解
 */
//说明注解使用范围
@Target(ElementType.METHOD)
//注解会保存在Class文件中，JVM加载文件后仍存在   --RetentionPolicy.CLASS--只保留在Class文件，加载后不存在--默认   RetentionPolicy.SOURCE--只保留在源文件，Class文件中没有
@Retention(RetentionPolicy.RUNTIME)
//加了该注解，在生成javadoc的时候，方法上会有本注解
@Documented
public @interface VisitLogger {

    //记录访问接口备注
    String interfaceRemark() default "";
}

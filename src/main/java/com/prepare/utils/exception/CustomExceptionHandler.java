package com.prepare.utils.exception;

import com.prepare.utils.common.R;
import com.prepare.utils.exception.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 处理自定义异常
     * @param ec
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R customExceptionHandler(CustomException ec){
        ec.printStackTrace();
        return R.error(ec.getCode(),ec.getMsg());
    }


}

package com.lyf.dryd.web.utils;

import com.lyf.dryd.common.enums.ErrorMessage;
import com.lyf.dryd.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice( annotations = RestController.class )
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( BizException.class )
    public ResponseEntity<ViewResult> otherException(BizException e) {
        log.error( "业务异常: {}", e );

        return new ResponseEntity<>(ViewResult.fail(e.getCode(), e.getMsg()), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ViewResult> exceptionHandler(Exception e) {
        return new ResponseEntity<>(ViewResult.fail(ErrorMessage.SYSTEM_ERROR.getCode(), ErrorMessage.SYSTEM_ERROR.getMsg()), HttpStatus.OK);
    }
}

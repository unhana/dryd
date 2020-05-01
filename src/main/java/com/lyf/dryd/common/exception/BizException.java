package com.lyf.dryd.common.exception;

import com.lyf.dryd.common.enums.ErrorMessage;

public class BizException extends RuntimeException {

    private String code;

    private String msg;

    private ErrorMessage errorMessage;

    public BizException(){

    }

    public BizException(String msg){
        this.msg = msg;
    }

    public BizException(ErrorMessage errorMessage, String...params){
        setErrorMessage(errorMessage, params);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage, String...params) {
        this.code = errorMessage.getCode();
        this.msg = errorMessage.getMsg(params);
        this.errorMessage = errorMessage;
    }

}

package com.lyf.dryd.web.utils;

import lombok.Data;

@Data
public class ViewResult {

    private Boolean success;

    private String code;

    private String msg;

    private Object data;


    public static ViewResult success(){
        ViewResult viewResult = new ViewResult();
        viewResult.setSuccess(true);
        return viewResult;
    }
    public static ViewResult success(Object data){
        ViewResult viewResult = new ViewResult();
        viewResult.setSuccess(true);
        viewResult.setData(data);
        return viewResult;
    }

    public static ViewResult fail(String code, String msg){
        ViewResult viewResult = new ViewResult();
        viewResult.setSuccess(false);
        viewResult.setCode(code);
        viewResult.setMsg(msg);
        return viewResult;
    }
}

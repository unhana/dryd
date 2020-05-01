package com.lyf.dryd.common.enums;

import com.lyf.dryd.common.i18n.I18nUtils;

/**
 * 错误信息提示
 */
public enum ErrorMessage {

    SYSTEM_ERROR("SYSTEM_ERROR", MsgType.SIMPLE, "系统异常,请重试"),

    MEMBER_FULL("MEMBER_FULL", MsgType.FORMAT, "课程{0}已满员")

    ;
    private enum MsgType{
        SIMPLE,FORMAT
    }
    private String code;

    private String msg;

    private MsgType type;

    ErrorMessage(String code, MsgType type, String msg) {
        this.code = code;
        this.msg = msg;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getMsg(String...params) {
        //国际化
        String value = I18nUtils.getOrDefault("error.msg." + code, msg);
        if(this.type == MsgType.SIMPLE){
            return value;
        } else {
            return I18nUtils.formatMsg(value, params);
        }
    }
}

package com.lyf.dryd.common.enums;

import com.lyf.dryd.common.i18n.I18nUtils;

import java.util.stream.Stream;

/**
 * 账号类型
 */
public enum AccountType {


    SYSTEM("SYSTEM", 0, "管理员"),

    MEMBER("MEMBER", 1, "会员"),

    COACH("COACH", 2, "教练")
    ;

    private String code;

    private Integer mappingValue;

    private String value;


    AccountType(String code, Integer mappingValue, String value) {
        this.code = code;
        this.value = value;
        this.mappingValue = mappingValue;
    }

    public String getCode() {
        return code;
    }

    public Integer getMappingValue(){
        return mappingValue;
    }

    public String getValue() {
        //国际化
        return I18nUtils.getOrDefault("enum.accountType." + code, value);
    }

    public static AccountType valueByMappingValue(Integer mappingValue){
        return Stream.of(AccountType.values()).filter(accountType -> accountType.mappingValue.equals(mappingValue)).findFirst()
                .orElse(null);

    }

}

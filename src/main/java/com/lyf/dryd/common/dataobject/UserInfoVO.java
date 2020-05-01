package com.lyf.dryd.common.dataobject;

import com.lyf.dryd.common.enums.AccountType;
import lombok.Data;

@Data
public class UserInfoVO {

    /**
     * 登录名
     */
    private String userName;

    /**
     * 语言
     */
    private String language;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 账号类型
     */
    private AccountType accountType;

}

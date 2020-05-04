package com.lyf.dryd.common.dataobject;

import com.lyf.dryd.common.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {

    /**
     * 用户ID
     */
    private Long id;

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
     * 是否记住密码
     */
    private Boolean rememberPwd;

    /**
     * 账号类型
     */
    private AccountType accountType;

}

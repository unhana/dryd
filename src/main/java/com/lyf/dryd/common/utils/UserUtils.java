package com.lyf.dryd.common.utils;

import com.lyf.dryd.common.dataobject.UserInfoVO;

public class UserUtils {

    private static ThreadLocal<UserInfoVO> users = new ThreadLocal<>();

    public static UserInfoVO getUserInfo(){
        return users.get();
    }

    public static void saveUserInfo(UserInfoVO user){
        users.set(user);
    }

    public static void remove(){
        users.remove();
    }
}

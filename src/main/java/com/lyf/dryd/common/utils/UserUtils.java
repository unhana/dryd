package com.lyf.dryd.common.utils;

import com.lyf.dryd.common.dataobject.UserInfoVO;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserUtils {

    private final static Map<String ,UserInfoVO> USER_INFO_MAP = new ConcurrentHashMap<>();

    public static String saveToCache(UserInfoVO user){
        UUID uuid = UUID.randomUUID();
        String finalUUID = uuid.toString().replace("-", "");
        USER_INFO_MAP.put(finalUUID, user);
        return finalUUID;
    }

    public static UserInfoVO getFromCache(String sessionId){
        return USER_INFO_MAP.get(sessionId);
    }

    public static UserInfoVO removeFromCache(String sessionId){
        return USER_INFO_MAP.remove(sessionId);
    }



    private static final ThreadLocal<UserInfoVO> users = new ThreadLocal<>();

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

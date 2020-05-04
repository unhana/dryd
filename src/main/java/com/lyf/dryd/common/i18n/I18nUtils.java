package com.lyf.dryd.common.i18n;

import com.lyf.dryd.common.dataobject.UserInfoVO;
import com.lyf.dryd.common.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public class I18nUtils {



    public static String getOrDefault(String key, String defaultValue){
        UserInfoVO userInfo = UserUtils.getUserInfo();
        String value = getWithLanguage(key, userInfo == null ? "zh-cn" : userInfo.getLanguage() );
        return StringUtils.isEmpty(value) ? defaultValue : value;
    }

    public static String get(String key){
        return getWithLanguage(key, UserUtils.getUserInfo().getLanguage());
    }

    private static String getWithLanguage(String key, String language) {
        return null;
    }

    public static String formatMsg(String value, String[] params){
        Object[] object = new Object[params.length];
        System.arraycopy(params, 0, object, 0, params.length);
        return MessageFormat.format(value, object);
    }
}

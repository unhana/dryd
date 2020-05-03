package com.lyf.dryd.common.i18n;

import com.lyf.dryd.common.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public class I18nUtils {



    public static String getOrDefault(String key, String defaultValue){
        String value = getWithLanguage(key, UserUtils.getUserInfo().getLanguage());
        return StringUtils.isEmpty(value) ? defaultValue : value;
    }

    public static String get(String key){
        return getWithLanguage(key, UserUtils.getUserInfo().getLanguage());
    }

    private static String getWithLanguage(String key, String language) {
        return null;
    }

    public static String formatMsg(String value, String[] params){
        return MessageFormat.format(value, params);
    }
}

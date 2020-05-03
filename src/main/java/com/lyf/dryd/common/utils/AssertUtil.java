package com.lyf.dryd.common.utils;

import com.lyf.dryd.common.enums.ErrorMessage;
import com.lyf.dryd.common.exception.BizException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public class AssertUtil {


    public static void checkTrue(Boolean b, ErrorMessage errorMessage, String...params){
        if(BooleanUtils.isTrue(b)){
            throw new BizException(errorMessage, params);
        }
    }

    public static void checkNull(Object obj, ErrorMessage errorMessage, String...params){
        if(obj == null){
            throw new BizException(errorMessage, params);
        }
    }

    public static void checkEmpty(Object obj, ErrorMessage errorMessage, String...params){
        checkNull(obj, errorMessage, params);
        boolean empty = false;
        if(obj instanceof String){
            empty = StringUtils.isEmpty(obj.toString());
        }
        if(obj instanceof Collection){
            empty = CollectionUtils.isEmpty((Collection) obj);
        }
        if(empty){
            throw new BizException(errorMessage, params);
        }
    }
}

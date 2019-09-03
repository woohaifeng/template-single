package com.company.template.common.util;

import org.apache.commons.lang3.StringUtils;

public class SQLUtil {

    public static String leftLike(String value) {
        if(StringUtils.isNotBlank(value)) {
            return "%"+value;
        }
        return value;
    }

    public static String rightLike(String value) {
        if(StringUtils.isNotBlank(value)) {
            return value+"%";
        }
        return value;
    }

    public static String like(String value) {
        if(StringUtils.isNotBlank(value)) {
            return "%"+value+"%";
        }
        return value;
    }

}

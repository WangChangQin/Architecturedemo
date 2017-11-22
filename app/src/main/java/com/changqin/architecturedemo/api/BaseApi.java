package com.changqin.architecturedemo.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangchangqin on 2017/10/14.
 */

public class BaseApi {
    public static String getUrl(String url, Object... args) {
        Pattern p = Pattern.compile("\\{\\w+\\}");
        Matcher m = p.matcher(url);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (m.find()) {
            m.appendReplacement(sb, args[i++].toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }
}

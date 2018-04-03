package com.laoyao.normal.whutzdh15.Tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Laoyao on 2018/4/3.
 */

public  class StringDispose
{
    public static boolean IsTotalNumber(String values)
    {
        if(values != null && !values.isEmpty())
        {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(values);
            if (!isNum.matches()) {
                return false;
            }
            return true;
        }
        else
        {
            return false ;
        }

    }
}

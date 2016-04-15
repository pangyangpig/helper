package com.example.pangyang.helper.util;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pangyang on 2016/4/11.
 */
public class Utils {
    public static final String BASEDOMAIN_DOUBAN = "https://api.douban.com/";

    public static Map<String, String> simpleBean2Map(Object obj){
        Map<String,String> stringMap = new HashMap<>();
        try {
            Class<?> objClazz = Class.forName(obj.getClass().getName());
            Field[] fields = objClazz.getFields();
            Method[] methods = objClazz.getDeclaredMethods();
            for(Field field : fields ){
                stringMap.put(field.getName(),field.get(obj) == null ? "" : String.valueOf(field.get(obj)));
            }

            for(Method method : methods){
                String methodName = method.getName();
                if(methodName.startsWith("get") ){
                    stringMap.put(methodName.substring(3).toLowerCase(), method.invoke(obj) == null ? "" : String.valueOf(method.invoke(obj)));
                }
            }
        } catch ( IllegalArgumentException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            Log.e("simpleBean2Map", e.getMessage());
        }

        return stringMap;
    }
}

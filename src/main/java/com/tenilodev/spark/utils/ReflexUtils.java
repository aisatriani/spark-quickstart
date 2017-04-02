package com.tenilodev.spark.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by azisa on 4/2/2017.
 */
public class ReflexUtils {
    private static ReflexUtils ourInstance = new ReflexUtils();

    public static ReflexUtils getInstance() {
        return ourInstance;
    }

    private ReflexUtils() {
    }

    public Object toMethod(String clsMethod, String dir, Object... params){
        Object invoke = null;
        Method execMethod = null;
        try {

            String[] ctrl = clsMethod.split("@");
            String cls = ctrl[0];
            String method = ctrl[1];
            Class<?> classType = null;

            classType = Class.forName( dir + "." + cls);

            Object o = classType.newInstance();

            if(params.length > 0){
                execMethod = o.getClass().getMethod(method,String.class);
                invoke =  execMethod.invoke(o,params);
            }else{
                execMethod = o.getClass().getMethod(method);
                invoke =  execMethod.invoke(o);
            }

            //invoke =  execMethod.invoke(o,params);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return invoke;
    }
}

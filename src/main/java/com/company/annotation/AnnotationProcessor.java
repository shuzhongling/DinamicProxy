package com.company.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by szl on 2016/4/12.
 */
public class AnnotationProcessor {

    private Map<String, String> map = new HashMap<String, String>();

    public void process(Class<?> inf) {
        Method[] methods = inf.getMethods();
        for (Method method : methods) {
            boolean hasAnnotation = method.isAnnotationPresent(MessageAnnotation.class);
            if (hasAnnotation) {
                MessageAnnotation messageAnnotation = method.getAnnotation(MessageAnnotation.class);
                map.put(method.getName(), messageAnnotation.value());
                //System.out.println(messageAnnotation.value());
            }

            hasAnnotation = method.isAnnotationPresent(ActionAnnotation.class);
            if (hasAnnotation) {
                ActionAnnotation actionAnnotation = method.getAnnotation(ActionAnnotation.class);
                map.put(method.getName(), actionAnnotation.value());
                //System.out.println(actionAnnotation.value());
            }

        }
    }

    public void call(String method) {
        System.out.println(map.get(method));
    }

}

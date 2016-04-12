package com.company;

import com.company.annotation.AnnotationProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by szl on 2016/4/12.
 */
@Configuration
public class PrinterProxy implements InvocationHandler {

    private String[] args;
    private AnnotationProcessor processor = new AnnotationProcessor();


    @Bean
    MessagePrinter getPrinter() {
        return (MessagePrinter) bind(MessagePrinter.class, null);
    }


    public Object bind(Class<?> intface, String[] args) {
        processor.process(intface);
        Class<?>[] clazzs = new Class<?>[1];
        clazzs[0] = intface;
        this.args = args;
        return Proxy.newProxyInstance(intface.getClassLoader(), clazzs, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        processor.call(methodName);
        return null;
    }
}

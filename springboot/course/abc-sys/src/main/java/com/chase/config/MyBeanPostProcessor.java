package com.chase.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/** bean 初始化相关方法回调
 * @author chase
 * Date: 2021/2/6
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    //bean初始化方法调用前被调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (bean != null && bean.toString().contains("com.chase"))
//            System.out.println("before:" + beanName + ":" + bean);
        return bean;
    }
    //bean初始化方法调用后被调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (bean != null && bean.toString().contains("com.chase"))
//
//            System.out.println("after:" + beanName + ":" + bean);
        return bean;
    }
}

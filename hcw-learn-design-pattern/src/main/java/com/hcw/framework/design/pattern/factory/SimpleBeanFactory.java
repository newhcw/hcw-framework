package com.hcw.framework.design.pattern.factory;

import java.lang.reflect.InvocationTargetException;

import com.hcw.framework.design.pattern.entity.Bean;

/**
 * 工厂模式与反射结合,用于对象获取.
 */
public class SimpleBeanFactory implements BeanFactory {

    @Override
    public Bean getBean(String beanName) {
        try {
            return (Bean) Class.forName(beanName).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    
}
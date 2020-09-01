package com.sanstwy27.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
		/**
		 *  public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)

            //1. ClassLoader loader ： class loader
            //2. Class<?>[] interfaces : the interface of target object
            //3. InvocationHandler h : the trigger method of target object
		 */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK proxy start");
                        Object returnVal = method.invoke(target, args);
                        System.out.println("JDK proxy end");
                        return returnVal;
                    }
                });
    }
}

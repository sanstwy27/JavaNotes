package com.sanstwy27.jvmquestions.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class MetaspaceDemo {

    static class OOMTest {

    }

    // -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
    public static void main(String[] args) {
        int i = 0;

        try {
            while (true) {
                ++i;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println("Throw Exception... i = " + i);
            e.printStackTrace();
        }

        /**
         * Throw Exception... i = 488
         * org.springframework.cglib.core.CodeGenerationException: java.lang.OutOfMemoryError-->Metaspace
         * 	at org.springframework.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:514)
         * 	at org.springframework.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:363)
         * 	at org.springframework.cglib.proxy.Enhancer.generate(Enhancer.java:585)
         * 	at org.springframework.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:131)
         * 	at org.springframework.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:319)
         * 	at org.springframework.cglib.proxy.Enhancer.createHelper(Enhancer.java:572)
         * 	at org.springframework.cglib.proxy.Enhancer.create(Enhancer.java:387)
         * 	at com.sanstwy27.jvmquestions.oom.MetaspaceDemo.main(MetaspaceDemo.java:35)
         * Caused by: java.lang.OutOfMemoryError: Metaspace
         * 	at java.base/java.lang.ClassLoader.defineClass1(Native Method)
         * 	at java.base/java.lang.System$2.defineClass(System.java:2196)
         * 	at java.base/java.lang.invoke.MethodHandles$Lookup.defineClass(MethodHandles.java:1648)
         * 	at java.base/jdk.internal.reflect.GeneratedMethodAccessor2.invoke(Unknown Source)
         * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * 	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
         * 	at org.springframework.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:509)
         * 	... 7 more
         *
         * Process finished with exit code 0
         */
    }
}

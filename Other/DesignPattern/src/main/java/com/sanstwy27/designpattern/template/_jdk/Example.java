package com.sanstwy27.designpattern.template._jdk;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Example {
    public static void main(String[] args) {
        // Spring IOC
        // ConfigurableApplicationContext
        /**
         * 1.
         * public interface ConfigurableApplicationContext extends ApplicationContext, Lifecycle, Closeable {
         *     ...
         *     void refresh() throws BeansException, IllegalStateException;   -> template method
         *     ...
         * }
         *
         *
         * 2.
         * public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
         *     ...
         *     public void refresh() throws BeansException, IllegalStateException {
         *         synchronized(this.startupShutdownMonitor) {
         *             this.prepareRefresh();
         *             ConfigurableListableBeanFactory beanFactory = this.obtainFreshBeanFactory();
         *             ...
         *             this.postProcessBeanFactory(beanFactory);
         *             ...
         *             this.onRefresh();
         *             ...
         *     }
         *     ...
         *
         *
         * 3.
         *     protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
         *         this.refreshBeanFactory();
         *         return this.getBeanFactory();
         *     }
         *
         * 4.
         *     protected abstract void refreshBeanFactory() throws BeansException, IllegalStateException;
         *     ...
         *     public abstract ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;
         *
         * 5.
         *     protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
         *     }
         *
         * 6.
         *     protected void onRefresh() throws BeansException {
         *     }
         *
         *
         * 7.
         * public class GenericApplicationContext extends AbstractApplicationContext implements BeanDefinitionRegistry {
         *     ...
         *     protected final void refreshBeanFactory() throws IllegalStateException {
         *         if (!this.refreshed.compareAndSet(false, true)) {
         *             throw new IllegalStateException("GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once");
         *         } else {
         *             this.beanFactory.setSerializationId(this.getId());
         *         }
         *     }
         *     ...
         * }
         *
         * Summary:
         *     getBeanFactory === abstract method
         *     refreshBeanFactory === abstract method
         *     postProcessBeanFactory === hook method
         *     onRefresh === hook method (call it in ConfigurableApplicationContext)
         *
         */
    }
}

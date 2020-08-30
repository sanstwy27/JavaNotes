package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

/**
 *  1.
 *     Object bean = applicationContext.getBean("id01");
 *
 *  2.
 *     public Object getBean(String name) throws BeansException {
 *         this.assertBeanFactoryActive();
 *         return this.getBeanFactory().getBean(name);
 *     }
 *
 *  3.
 *     public Object getBean(String name) throws BeansException {
 *         return this.doGetBean(name, (Class)null, (Object[])null, false);
 *     }
 *
 *  4.
 *     protected <T> T doGetBean(String name, @Nullable Class<T> requiredType, @Nullable Object[] args, boolean typeCheckOnly) throws BeansException {
 *         String beanName = this.transformedBeanName(name);
 *         Object sharedInstance = this.getSingleton(beanName);
 *         Object bean;
 *         ...
 *         } else if (mbd.isPrototype()) {
 *         ...
 *     }
 *
 *
 */
public class ProtoTypeTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        Object bean = applicationContext.getBean("id01");
        System.out.println("bean" + bean);

        Object bean2 = applicationContext.getBean("id01");
        System.out.println("bean2" + bean2);

        System.out.println(bean == bean2);

        /**
         * monster created..
         * beanMonster [id=10, nickname=Princess Iron-Fan, skill=Palm-leaf fan]
         * monster created..
         * bean2Monster [id=10, nickname=Princess Iron-Fan, skill=Palm-leaf fan]
         * false
         */
    }
}

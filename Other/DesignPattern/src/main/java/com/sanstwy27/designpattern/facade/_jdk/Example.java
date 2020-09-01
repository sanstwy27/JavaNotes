package com.sanstwy27.designpattern.facade._jdk;

import org.apache.ibatis.session.Configuration;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Example {
    public static void main(String[] args) {
        //Configuration
        /**
         * 1.
         *   public class Configuration {
         *       ...
         *       protected ReflectorFactory reflectorFactory;
         *       protected ObjectFactory objectFactory;
         *       protected ObjectWrapperFactory objectWrapperFactory;
         *       ...
         *       public Configuration() {
         *           ...
         *           this.reflectorFactory = new DefaultReflectorFactory();
         *           this.objectFactory = new DefaultObjectFactory();
         *           this.objectWrapperFactory = new DefaultObjectWrapperFactory();
         *           ...
         *       }
         *
         *       public MetaObject newMetaObject(Object object) {
         *           return MetaObject.forObject(object, this.objectFactory, this.objectWrapperFactory, this.reflectorFactory);
         *       }
         *       ...
         *
         * 2.
         *   private MetaObject(Object object, ObjectFactory objectFactory, ObjectWrapperFactory objectWrapperFactory, ReflectorFactory reflectorFactory) {
         *       this.originalObject = object;
         *       this.objectFactory = objectFactory;
         *       this.objectWrapperFactory = objectWrapperFactory;
         *       this.reflectorFactory = reflectorFactory;
         *       if (object instanceof ObjectWrapper) {
         *           this.objectWrapper = (ObjectWrapper)object;
         *       } else if (objectWrapperFactory.hasWrapperFor(object)) {
         *           this.objectWrapper = objectWrapperFactory.getWrapperFor(this, object);
         *       } else if (object instanceof Map) {
         *           this.objectWrapper = new MapWrapper(this, (Map)object);
         *       } else if (object instanceof Collection) {
         *           this.objectWrapper = new CollectionWrapper(this, (Collection)object);
         *       } else {
         *           this.objectWrapper = new BeanWrapper(this, object);
         *       }
         *
         *   }
         *
         *   public static MetaObject forObject(Object object, ObjectFactory objectFactory, ObjectWrapperFactory objectWrapperFactory, ReflectorFactory reflectorFactory) {
         *       return object == null ? SystemMetaObject.NULL_META_OBJECT : new MetaObject(object, objectFactory, objectWrapperFactory, reflectorFactory);
         *   }
         *
         *
         */
    }
}

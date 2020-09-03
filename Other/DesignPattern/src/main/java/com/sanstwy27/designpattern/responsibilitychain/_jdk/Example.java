package com.sanstwy27.designpattern.responsibilitychain._jdk;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Example {
    public static void main(String[] args) {
        //DispatcherServlet
        /**
         * 1.
         *   public class DispatcherServlet extends FrameworkServlet {
         *       ...
         *       protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
         *           ...
         *           HandlerExecutionChain mappedHandler = null;
         *           ...
         *                     mappedHandler = this.getHandler(processedRequest);
         *                     ...
         *                     if (!mappedHandler.applyPreHandle(processedRequest, response)) {
         *                         return;
         *                     }
         *                     ...
         *                     mappedHandler.applyPostHandle(processedRequest, response, mv);
         *                     ...
         *
         *
         * 2.
         * public class HandlerExecutionChain {
         *     ...
         *     boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
         *         HandlerInterceptor[] interceptors = this.getInterceptors();
         *         if (!ObjectUtils.isEmpty(interceptors)) {
         *             for(int i = 0; i < interceptors.length; this.interceptorIndex = i++) {
         *                 HandlerInterceptor interceptor = interceptors[i];
         *                 if (!interceptor.preHandle(request, response, this.handler)) {
         *                     this.triggerAfterCompletion(request, response, (Exception)null);
         *                     return false;
         *                 }
         *             }
         *         }
         *
         *         return true;
         *     }
         *     ...
         *
         * 3.
         * public class HandlerExecutionChain {
         *     ...
         *     void triggerAfterCompletion(HttpServletRequest request, HttpServletResponse response, @Nullable Exception ex) throws Exception {
         *         HandlerInterceptor[] interceptors = this.getInterceptors();
         *         if (!ObjectUtils.isEmpty(interceptors)) {
         *             for(int i = this.interceptorIndex; i >= 0; --i) {
         *                 HandlerInterceptor interceptor = interceptors[i];
         *
         *                 try {
         *                     interceptor.afterCompletion(request, response, this.handler, ex);
         *                 } catch (Throwable var8) {
         *                     logger.error("HandlerInterceptor.afterCompletion threw exception", var8);
         *                 }
         *             }
         *         }
         *
         *     }
         *
         *
         */
    }
}

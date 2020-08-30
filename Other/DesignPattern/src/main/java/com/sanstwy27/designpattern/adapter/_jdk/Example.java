package com.sanstwy27.designpattern.adapter._jdk;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Example {
    public static void main(String[] args) {
        //SpringMVC
        //DispatcherServlet

        /**
         * 1.
         * public class DispatcherServlet extends FrameworkServlet {
         *     ...
         *     protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
         *         ...
         *         mappedHandler = this.getHandler(processedRequest);
         *         ...
         *         HandlerAdapter ha = this.getHandlerAdapter(mappedHandler.getHandler());
         *         ...
         *
         * 2.
         *     protected HandlerAdapter getHandlerAdapter(Object handler) throws ServletException {
         *         if (this.handlerAdapters != null) {
         *             Iterator var2 = this.handlerAdapters.iterator();
         *
         *             while(var2.hasNext()) {
         *                 HandlerAdapter adapter = (HandlerAdapter)var2.next();
         *                 if (adapter.supports(handler)) {
         *                     return adapter;
         *                 }
         *             }
         *         }
         *
         *         throw new ServletException("No adapter for handler [" + handler + "]: The DispatcherServlet configuration needs to include a HandlerAdapter that supports this handler");
         *     }
         *
         *
         * 3.
         * public interface HandlerAdapter {
         *     boolean supports(Object var1);
         *
         *     @Nullable
         *     ModelAndView handle(HttpServletRequest var1, HttpServletResponse var2, Object var3) throws Exception;
         *
         *     long getLastModified(HttpServletRequest var1, Object var2);
         * }
         *
         * -> public abstract class AbstractHandlerMethodAdapter extends WebContentGenerator implements HandlerAdapter, Ordered
         * -> public class HandlerFunctionAdapter implements HandlerAdapter, Ordered
         * -> public class HttpRequestHandlerAdapter implements HandlerAdapter
         * -> public class SimpleControllerHandlerAdapter implements HandlerAdapter
         * -> public class SimpleServletHandlerAdapter implements HandlerAdapter
         *
         *
         * 4.
         *     // ModelAndView
         *     mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
         *
         *
         */
    }
}

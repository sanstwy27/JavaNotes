package com.sanstwy27.designpattern.adapter._jdk.springmvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class DispatchServlet {
    public static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    public DispatchServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    public void doDispatch() {
        HttpController controller = new HttpController();
        //AnnotationController controller = new AnnotationController();
        //SimpleController controller = new SimpleController();

        HandlerAdapter adapter = getHandler(controller);
        adapter.handle(controller);
    }

    public HandlerAdapter getHandler(Controller controller) {
        for (HandlerAdapter adapter : this.handlerAdapters) {
            if (adapter.supports(controller)) {
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // HTTP
        new DispatchServlet().doDispatch();
    }
}

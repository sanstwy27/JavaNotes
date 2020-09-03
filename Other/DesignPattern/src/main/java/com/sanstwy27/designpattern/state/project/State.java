package com.sanstwy27.designpattern.state.project;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public interface State {
    void checkEvent(Context context);
    void checkFailEvent(Context context);
    void makePriceEvent(Context context);
    void acceptOrderEvent(Context context);
    void notPeopleAcceptEvent(Context context);
    void payOrderEvent(Context context);
    void orderFailureEvent(Context context);
    void feedBackEvent(Context context);


    String getCurrentState();
}

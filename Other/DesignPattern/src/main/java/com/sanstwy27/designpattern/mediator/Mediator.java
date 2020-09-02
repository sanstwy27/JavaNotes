package com.sanstwy27.designpattern.mediator;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public abstract class Mediator {
    public abstract void Register(String colleagueName, Colleague colleague);
    public abstract void GetMessage(int stateChange, String colleagueName);
    public abstract void SendMessage();
}

package com.sanstwy27.designpattern.observer.after;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

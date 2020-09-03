package com.sanstwy27.designpattern.responsibilitychain.sample;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public abstract class Approver {
    Approver nextApprover;
    String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void processRequest(PurchaseRequest purchaseRequest);
}

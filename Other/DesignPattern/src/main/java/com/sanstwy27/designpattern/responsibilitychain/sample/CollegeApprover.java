package com.sanstwy27.designpattern.responsibilitychain.sample;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class CollegeApprover extends Approver {
    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() > 5000 && purchaseRequest.getPrice() <= 10000) {
            System.out.println(" request id = " + purchaseRequest.getId() + " name: " + this.name + " ");
        } else {
            nextApprover.processRequest(purchaseRequest);
        }
    }
}

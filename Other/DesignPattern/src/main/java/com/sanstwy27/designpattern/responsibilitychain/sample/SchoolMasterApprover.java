package com.sanstwy27.designpattern.responsibilitychain.sample;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class SchoolMasterApprover extends Approver {
    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() > 30000) {
            System.out.println(" request id = " + purchaseRequest.getId() + " name: " + this.name + " ");
        } else {
            nextApprover.processRequest(purchaseRequest);
        }
    }
}

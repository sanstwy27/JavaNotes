package com.sanstwy27.designpattern.responsibilitychain.sample;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Client {
    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 9000, 1);

        DepartmentApprover departmentApprover = new DepartmentApprover("Alice");
        CollegeApprover collegeApprover = new CollegeApprover("Bob");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("Charlie");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("David");

        departmentApprover.setNextApprover(collegeApprover);
        collegeApprover.setNextApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setNextApprover(schoolMasterApprover);
        schoolMasterApprover.setNextApprover(departmentApprover);

        departmentApprover.processRequest(purchaseRequest);
        viceSchoolMasterApprover.processRequest(purchaseRequest);

        /**
         *  request id = 1 name: Bob
         *  request id = 1 name: Bob
         *
         */
    }
}

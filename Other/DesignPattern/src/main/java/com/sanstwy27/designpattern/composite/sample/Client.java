package com.sanstwy27.designpattern.composite.sample;

import com.sanstwy27.designpattern.composite.sample.composite.College;
import com.sanstwy27.designpattern.composite.sample.composite.University;
import com.sanstwy27.designpattern.composite.sample.leaf.Department;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Client {
    public static void main(String[] args) {
        OrganizationComponent university = new University("ABC University", " ABCU ");

        OrganizationComponent computerCollege = new College("Department of Computer Science", " CS ");
        OrganizationComponent infoEngineercollege = new College("Department of Education", " EDU ");

        computerCollege.add(new Department("CS1", " CS1 "));
        computerCollege.add(new Department("CS2", " CS2 "));
        computerCollege.add(new Department("CS3", " CS3 "));

        infoEngineercollege.add(new Department("EDU1", " EDU1 "));
        infoEngineercollege.add(new Department("EDU2", " EDU2 "));

        university.add(computerCollege);
        university.add(infoEngineercollege);

        university.print();
        //infoEngineercollege.print();

        /**
         * --------------ABC University--------------
         * --------------Department of Computer Science--------------
         * CS1
         * CS2
         * CS3
         * --------------Department of Education--------------
         * EDU1
         * EDU2
         */
    }
}

package com.sanstwy27.designpattern.principle.demeter.before;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());

        /**
         * ------------ CollegeEmployee ------------
         * CollegeEmployee id= 0
         * CollegeEmployee id= 1
         * CollegeEmployee id= 2
         * CollegeEmployee id= 3
         * CollegeEmployee id= 4
         * CollegeEmployee id= 5
         * CollegeEmployee id= 6
         * CollegeEmployee id= 7
         * CollegeEmployee id= 8
         * CollegeEmployee id= 9
         * ------------ SchoolManager ------------
         * CollegeEmployee id= 0
         * CollegeEmployee id= 1
         * CollegeEmployee id= 2
         * CollegeEmployee id= 3
         * CollegeEmployee id= 4
         *
         */
    }
}

class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class CollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("CollegeEmployee id= " + i);
            list.add(emp);
        }
        return list;
    }
}

// the friend classes of SchoolManager are Employee and CollegeManager,
// but CollegeEmployee is a stranger class of SchoolManager -><- Demeter principle
class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("CollegeEmployee id= " + i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(CollegeManager sub) {
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("------------ CollegeEmployee ------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }

        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------ SchoolManager ------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
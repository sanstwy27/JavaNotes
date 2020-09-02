package com.sanstwy27.designpattern.iterator.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Client {
    public static void main(String[] args) {
        List<College> collegeList = new ArrayList<College>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        OutPutImpl outPutImpl = new OutPutImpl(collegeList);
        outPutImpl.printCollege();

        /**
         * === ComputerCollege=====
         * C1
         * C2
         * C3
         * === InfoCollege=====
         * I1
         * I2
         * I3
         *
         */
    }
}

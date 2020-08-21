package com.sanstwy27.countdownlatch;
/**
 * @author Sanstwy27
 * @create 8/21/2020
 */

public enum EmployeeEnum {
    ONE(1, "Alice"),
    TWO(2, "Bob"),
    THREE(3, "Charlie"),
    FOUR(4, "David"),
    FIVE(5, "Eve"),
    SIX(6, "Frank");

    private Integer retCode;
    private String retEmpName;

    EmployeeEnum(Integer retCode, String retEmpName) {
        this.retCode = retCode;
        this.retEmpName = retEmpName;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetEmpName() {
        return retEmpName;
    }

    public void setRetEmpName(String retEmpName) {
        this.retEmpName = retEmpName;
    }

    public static EmployeeEnum getMsg(int index) {
        EmployeeEnum[] employee = EmployeeEnum.values();
        for (EmployeeEnum employeeEnum : employee) {
            if (employeeEnum.getRetCode() == index) {
                return employeeEnum;
            }
        }
        return null;
    }
}

/**
 * mysql dbName = EmployeeEnum
 *
 * table
 * ID    userName    age    birth    userEmail
 * 1     Alice       ...    ...      ...
 * 2     Bob         ...    ...      ...
 * 3     Charlie     ...    ...      ...
 * ...   ...         ...    ...      ...
 */

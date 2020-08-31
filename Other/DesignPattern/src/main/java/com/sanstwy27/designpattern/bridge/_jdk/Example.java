package com.sanstwy27.designpattern.bridge._jdk;


import com.mysql.jdbc.Driver;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Example {
    public static void main(String[] args) {
        //Driver

        /**
         * 1. [com.mysql.jdbc.Driver]
         *   public class Driver extends com.mysql.cj.jdbc.Driver
         *
         * 2. [com.mysql.cj.jdbc.Driver]
         *   public class Driver extends NonRegisteringDriver implements java.sql.Driver {
         *     public Driver() throws SQLException {
         *     }
         *
         *     static {
         *         try {
         *             DriverManager.registerDriver(new Driver());
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         *   }
         *
         * 3. [DriverManager]
         *     public class DriverManager {
         *         ...
     *             public static Connection getConnection(String url,
         *             java.util.Properties info) throws SQLException
         *         ...
     *             public static Connection getConnection(String url,
         *             String user, String password) throws SQLException
         *         ...
         *
         * 4. [Connection]
         *     public interface Connection  extends Wrapper, AutoCloseable
         *
         * 5. [ConnectionImpl]
         *   public class ConnectionImpl extends ConnectionPropertiesImpl implements MySQLConnection
         *
         *
         *
         *
         */
    }
}

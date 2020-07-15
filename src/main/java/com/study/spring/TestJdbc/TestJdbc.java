package com.study.spring.TestJdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";
        String driver = "com.mysql.cj.jdbc.Driver";

        String user = "customermanager";
        String pass = "customermanager";

        // get connection to database
        try {

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            myConn.close();

            System.out.println("Connection success");

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

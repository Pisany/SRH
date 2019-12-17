package com.webapp.DbUtils;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;

public class Driver {

    private static final String JDBC_MYSQL_127_0_0_1_3306_SRH = "jdbc:mysql://127.0.0.1:3306/SRH";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String TIMEZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private String foo = "";

    Connection myConnection;


    Statement prepareConnection(){
        try {
            myConnection = DriverManager.getConnection(JDBC_MYSQL_127_0_0_1_3306_SRH, USER, PASSWORD);
            return myConnection.createStatement();
        }catch (CommunicationsException e){
            System.out.println("Kurva!!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    void closeConnection(){
        try {
            myConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
//TODO
//add logs



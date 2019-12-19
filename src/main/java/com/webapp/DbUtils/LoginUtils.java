package com.webapp.DbUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginUtils extends Driver {
    private final Logger logger = LoggerFactory.getLogger(LoginUtils.class);
    private Driver driver = new Driver();
    HttpServletRequest req;

    //TODO select * from users - need id and acctype


    public Map getSingleUser(String login) {
        Map<String, String> userMap = new HashMap<>();
        try {
            ResultSet results = driver.prepareConnection().executeQuery("SELECT * FROM users WHERE userLogin ='" + login + "' ");
            while (results.next()) {
                userMap.put("userID", results.getString("userID"));
                userMap.put("accType", results.getString("accType"));
                userMap.put("login", results.getString("userLogin"));
                userMap.put("password", results.getString("password"));
            }
            driver.closeConnection();
        } catch (NullPointerException e) {
            System.out.println("Database probably is not connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userMap;
    }

    public void insertIntoUSERINFO(HttpServletRequest req) {
        String query = "INSERT INTO `userinfo`(`userID`, `userLogin`, `loginTime`)" + "VALUES (?,?,now()) ";
        this.req = req;
        //TODO check cast (Integer) vs parse
        var userIdAtt = req.getSession().getAttribute("userID");
        var loginAtt = req.getSession().getAttribute("login");
        System.out.println("AAAA:" + req.getSession().getAttribute("login"));
        try {
            driver.prepareConnection();
            PreparedStatement preparedStmt = driver.myConnection.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(String.valueOf(userIdAtt)));
            preparedStmt.setString(2, String.valueOf(loginAtt));

            preparedStmt.executeUpdate();
            driver.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertInToUSERINFOLogoutTime() {
        var userIdAtt = req.getSession().getAttribute("userID");

        String query = "UPDATE userinfo SET `logoutTime`= now() WHERE `ID` = " +
                "(SELECT ID FROM `userinfo` WHERE `userID` = " + userIdAtt + " ORDER BY loginTime DESC LIMIT 1);";
        try {
            driver.prepareConnection();
            PreparedStatement preparedStmt = driver.myConnection.prepareStatement(query);
            preparedStmt.executeUpdate();
            driver.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertIntoLOGINATTEMPT(HttpServletRequest req) {
        String query = "INSERT INTO `loginattempt`(`userLogin`, `password`, `login`)" + "VALUES (?,?,now()) ";
        var loginParam = req.getParameter("login");
        var passwordParam = req.getParameter("password");
        try {
            driver.prepareConnection();
            PreparedStatement preparedStmt = driver.myConnection.prepareStatement(query);
            preparedStmt.setString(1, loginParam);
            preparedStmt.setString(2, passwordParam);

            preparedStmt.executeUpdate();
            driver.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

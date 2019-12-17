package com.webapp.Model;

public class Users {

    private int userID;
    private int accType;
    private String login;
    private String password;

    public Users(int userID, int accType, String login, String password) {
        this.userID = userID;
        this.accType = accType;
        this.login = login;
        this.password = password;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAccType() {
        return accType;
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userID=" + userID +
                ", accType=" + accType +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

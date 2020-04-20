package com.example.food_app.Model;

public class User {
    private String Password;
    private String Community;
    private String Email;
    private String Phone_no;
    public User() {

    }

    public User(String password, String community, String email, String phone_no) {
        Password = password;
        Community = community;
        Email = email;
        Phone_no = phone_no;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCommunity() {
        return Community;
    }

    public void setCommunity(String community) {
        Community = community;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(String phone_no) {
        Phone_no = phone_no;
    }
}

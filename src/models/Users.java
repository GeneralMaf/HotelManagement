/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author I2S
 */
public class Users {
    private long user_id ;
    private String username ;
    private String password ;
    private String role ;
    private String full_name ;
    private String mail ;
    private String phone ;
    private Date created_at ;

    public Users(String username, String password, String role, String full_name,String mail, String phone, Date created_at) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.full_name = full_name;
        this.mail=mail;
        this.phone = phone;
        this.created_at = created_at;
    }

    public Users(int user_id, String username, String password, String role, String full_name, String phone, String string5, Date created_at) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.full_name = full_name;
        this.phone = phone;
        this.created_at = created_at;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    
    

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFull_name() {
        return full_name;
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
}

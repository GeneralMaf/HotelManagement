/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import java.sql.Timestamp;
/**
 *
 * @author I2S
 */
public class Reservations {
    
    private int reservation_id ;
    private int user_id  ;
    private String client_name  ;
    private String client_email ;
    private String client_phone ;
    private int room_id ;
    private Date check_in_date ;
    private Date check_out_date ;
    private String 	status ;
    private Timestamp	created_at ;

    public Reservations(int user_id, String client_name, String client_email, String client_phone, int room_id, Date check_in_date, Date check_out_date, String status) {
        this.user_id = user_id;
        this.client_name = client_name;
        this.client_email = client_email;
        this.client_phone = client_phone;
        this.room_id = room_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.status = status;
       
    }
    
    public Reservations(int reservation_id, int user_id, String client_name, String client_email, String client_phone, int room_id, Date check_in_date, Date check_out_date, String status) {
        this.reservation_id = reservation_id;
        this.user_id = user_id;
        this.client_name = client_name;
        this.client_email = client_email;
        this.client_phone = client_phone;
        this.room_id = room_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.status = status;
        
    }

   

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }

    public Date getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(Date check_out_date) {
        this.check_out_date = check_out_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    
    
    
}

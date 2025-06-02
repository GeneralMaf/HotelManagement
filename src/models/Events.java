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
public class Events {
    private int event_id ;
    private int hall_id  ;
    private String event_name ;
    private Date event_date ;
    
    private Date start_time ;
    private Date end_time ;
    private String client_name ;
    private String client_email ;
    private String client_phone ;
    private String 	status ;
    private Date created_at ;

    public Events(int hall_id, String event_name, Date event_date, Date start_time, Date end_time, String client_name, String client_email, String client_phone, String status, Date created_at) {
        this.hall_id = hall_id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.client_name = client_name;
        this.client_email = client_email;
        this.client_phone = client_phone;
        this.status = status;
        this.created_at = created_at;
    }

    public Events(int event_id, int hall_id, String event_name, Date event_date, Date start_time, Date end_time, String client_name, String client_email, String client_phone, String status, Date created_at) {
        this.event_id = event_id;
        this.hall_id = hall_id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.client_name = client_name;
        this.client_email = client_email;
        this.client_phone = client_phone;
        this.status = status;
        this.created_at = created_at;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
    
}

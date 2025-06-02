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
public class ClientServices {
    private int service_id ;
    private int reservation_id ;
    private String service_type ;
    private String 	status ;
    private Date request_date ;
    private Date 	completion_date ;
    private String description ;

    public ClientServices(int reservation_id, String service_type, String status, Date request_date, Date completion_date, String description) {
        this.reservation_id = reservation_id;
        this.service_type = service_type;
        this.status = status;
        this.request_date = request_date;
        this.completion_date = completion_date;
        this.description = description;
    }

    public ClientServices(int service_id, int reservation_id, String service_type, String status, Date request_date, Date completion_date, String description) {
        this.service_id = service_id;
        this.reservation_id = reservation_id;
        this.service_type = service_type;
        this.status = status;
        this.request_date = request_date;
        this.completion_date = completion_date;
        this.description = description;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public Date getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(Date completion_date) {
        this.completion_date = completion_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}

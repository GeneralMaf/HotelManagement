/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author I2S
 */
public class Rooms {
    private int room_id ;
    private String room_number  ;
    private String room_type ;
    private String status ;
    private float price ;
    private String 	description ;

    public Rooms(String room_number, String room_type, String status, float price, String description) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public Rooms(int room_id, String room_number, String room_type, String status, float price, String description) {
        this.room_id = room_id;
        this.room_number = room_number;
        this.room_type = room_type;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}

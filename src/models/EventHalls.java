/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author I2S
 */
public class EventHalls {
    
    private int hall_id ;
    private String hall_name ;
    private int  capacity ;
    private String  equipment ;
    private String  status ;

    public EventHalls(String hall_name, int capacity, String equipment, String status) {
        this.hall_name = hall_name;
        this.capacity = capacity;
        this.equipment = equipment;
        this.status = status;
    }

    public EventHalls(int hall_id, String hall_name, int capacity, String equipment, String status) {
        this.hall_id = hall_id;
        this.hall_name = hall_name;
        this.capacity = capacity;
        this.equipment = equipment;
        this.status = status;
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public String getHall_name() {
        return hall_name;
    }

    public void setHall_name(String hall_name) {
        this.hall_name = hall_name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

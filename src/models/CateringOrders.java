/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import java.time.LocalDate;
/**
 *
 * @author I2S
 */
public class CateringOrders {

    private int order_id;
    private int reservation_id;
    private int menu_item_id;
    private int quantity;
    private LocalDate order_date;
    private String status;

    public CateringOrders(int reservation_id, int menu_item_id, int quantity, LocalDate order_date, String status) {
        this.reservation_id = reservation_id;
        this.menu_item_id = menu_item_id;
        this.quantity = quantity;
        this.order_date = order_date;
        this.status=status;
    }

    public CateringOrders(int order_id, int reservation_id, int menu_item_id, int quantity, LocalDate order_date, String status) {
        this.order_id = order_id;
        this.reservation_id = reservation_id;
        this.menu_item_id = menu_item_id;
        this.quantity = quantity;
        this.order_date = order_date;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getMenu_item_id() {
        return menu_item_id;
    }

    public void setMenu_item_id(int menu_item_id) {
        this.menu_item_id = menu_item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

}

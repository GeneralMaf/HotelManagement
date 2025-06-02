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
public class EventInvoices {
    private int invoice_id;
    private int event_id;
    private float amount;
    private Date issue_date;
    private String status;

    public EventInvoices(int event_id, float amount, Date issue_date, String status) {
        this.event_id = event_id;
        this.amount = amount;
        this.issue_date = issue_date;
        this.status = status;
    }

    public EventInvoices(int invoice_id, int event_id, float amount, Date issue_date, String status) {
        this.invoice_id = invoice_id;
        this.event_id = event_id;
        this.amount = amount;
        this.issue_date = issue_date;
        this.status = status;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

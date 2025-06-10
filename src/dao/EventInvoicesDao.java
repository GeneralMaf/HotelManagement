/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.EventInvoices;

/**
 *
 * @author I2S
 */
public class EventInvoicesDao {

    static final String sql_select = "SELECT * FROM `event_invoices` WHERE 1";
    static final String sql_select_by_event_id = "SELECT * FROM `event_invoices` WHERE 1";

    static final String sql_insert = "INSERT INTO `event_invoices` ( `event_id`, `amount`,`status`) VALUES (?, ?, ?)";
    static final String sql_update = "UPDATE `event_invoices` SET `event_id` = ?, `amount` = ?, `status` =? WHERE `event_invoices`.`invoice_id` =?";
    static final String sql_delete = " DELETE FROM event_invoices WHERE `event_invoices`.`invoice_id` = ?";
//    Cette methode permet de creer une facture

    public static EventInvoices createEventInvoices(EventInvoices ei) throws SQLException, ClassNotFoundException {
        int idinserted = (int) DatabaseService.executeInsertWithGeneratedKey(sql_insert, ei.getEvent_id(), ei.getAmount(), ei.getStatus());
        ei.setInvoice_id(idinserted);
        return ei;
    }
//    Cette methode permet de convertir un resultSet en EventInvoices

    public static EventInvoices convertResultSettoEventInvoices(ResultSet rs) throws SQLException, ClassNotFoundException {
        return new EventInvoices(rs.getInt("invoice_id"), rs.getInt("event_id"), rs.getFloat("amount"), rs.getDate("issue_date"), rs.getString("status"));
    }

    //    Cette methode permet de selectionner tous les factures
    public static List<EventInvoices> selectEventInvoices() throws SQLException, ClassNotFoundException {
        List<EventInvoices> mylist = new ArrayList<>();
        ResultSet rs = DatabaseService.executeQuery(sql_select);
        while (rs.next()) {
            mylist.add(convertResultSettoEventInvoices(rs));
        }
        return mylist;
    }

    //    Cette methode permet de selectionner une facture
    public static EventInvoices selectEventInvoicesby_event_id() throws SQLException, ClassNotFoundException {

        ResultSet rs = DatabaseService.executeQuery(sql_select_by_event_id);
        if (rs.next()) {
            return convertResultSettoEventInvoices(rs);
        }
        return null;
    }

    //    Cette methode permet de modifier une facture 
    public static int updateEventInvoices(EventInvoices ev) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_update, ev.getEvent_id(), ev.getAmount(), ev.getStatus(), ev.getInvoice_id());
    }

    //    Cette methode permet de supprimer une facure une facture 
    public static int deleteEventInvoices(EventInvoices ev) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_delete, ev.getInvoice_id());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Reservations;
import models.Users;

/**
 *
 * @author I2S
 */
public class ReservationsDao {

    static final String sql_insert = "INSERT INTO `reservations` (`user_id`, `client_name`, `client_email`, `client_phone`, `room_id`, `check_in_date`, `check_out_date`, `status`) VALUES (?, ?,?,? ,?, ?,?,?)";
    static final String sql_select = "SELECT * FROM `reservations`";
    static final String sql_selectbyid = "SELECT * FROM `reservations where reservation_id=? `";
    static final String sql_update = "UPDATE `reservations` SET `user_id` = ?, `client_name` = ?, `client_email` = ?, `client_phone` = ?, `room_id` = ?, `check_in_date` = ?, `check_out_date` = ?, `status` =? WHERE `reservations`.`reservation_id` =?";
    static final String sql_delete = " DELETE FROM reservations WHERE `reservations`.`reservation_id` = ?";
    static final String sql_recherchebyemail = "SELECT * FROM `reservations` WHERE client_email =?";

    //    cette methode permet de creer une reservation
    static public Reservations cratereservation(Reservations r) throws SQLException, ClassNotFoundException {
        long idinserted = DatabaseService.executeInsertWithGeneratedKey(sql_insert, r.getUser_id(), r.getClient_name(), r.getClient_email(), r.getClient_phone(), r.getRoom_id(), r.getCheck_in_date(), r.getCheck_out_date(),r.getStatus());
        r.setReservation_id((int) idinserted);
        return r;
    }

    //    cette methode permet de convertir un ResultSet en Users 
    public static Reservations convertResultsettoreservatiovs(ResultSet rs) throws SQLException {
        return new Reservations(rs.getInt("reservation_id"), rs.getInt("user_id"), rs.getString("client_name"), rs.getString("client_email"), rs.getString("client_phone"), rs.getInt("room_id"), rs.getDate("check_in_date"), rs.getDate("check_out_date"), rs.getString("status"));
    }

    //    Cette methode permet de Retourner tous les Reservations
    public static List<Reservations> getreservations() throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_select);
        List<Reservations> reservations = new ArrayList<>();
        while (rs.next()) {
            reservations.add(convertResultsettoreservatiovs(rs));
        }
        return reservations;

    }
//Cette methode permet d'afficher un reservation

    public static Reservations getreservationsbyid() throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_select);
        List<Reservations> reservations = new ArrayList<>();
        if (rs.next()) {
            return convertResultsettoreservatiovs(rs);
        }
        return null;

    }

    //Cette methode permet de modifier un reservation
    public static int updatereservations(Reservations r) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_update, r.getUser_id(), r.getClient_name(), r.getClient_email(), r.getClient_phone(), r.getRoom_id(), r.getCheck_in_date(), r.getCheck_out_date(), r.getStatus(), r.getReservation_id());
    }
    //    cette methode permet de supprimer une reservation

    public static int deletereservation(Reservations r) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_delete, r.getReservation_id());
    }

    public static Reservations rechercherchereservationbyemailclient(String name) throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_recherchebyemail,name);
        if (rs.next()) {
            return convertResultsettoreservatiovs(rs);
        }
        return null;
    }
}

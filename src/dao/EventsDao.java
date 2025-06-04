/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Events;

/**
 *
 * @author I2S
 */
public class EventsDao {

    static final String sql_select = "SELECT * FROM `events`";
    static final String sql_insert = "INSERT INTO `events` ( `hall_id`, `event_name`, `event_date`, `start_time`, `end_time`, `client_name`, `client_email`, `client_phone`, `status`, `created_at`) VALUES (?,?, ?, ?,?, ?, ?,?, ?, current_timestamp());";
    static final String sql_update = "UPDATE `events` SET `hall_id` = ?, `event_name` = ?, `event_date` = ?, `start_time` = ?, `end_time` =?, `client_name` = ?, `client_email` =?, `client_phone` =?, `status` = ? WHERE `events`.`event_id` = ?";
    static final String sql_searchbyname_client = "SELECT * FROM `events` WHERE client_name LIKE \"%?%\";";
//    Cette methode permet de creer un evenement

    static public Events creEvents(Events e) throws SQLException, ClassNotFoundException {

        long idinserted = DatabaseService.executeInsertWithGeneratedKey(sql_insert, e.getHall_id(), e.getEvent_name(), e.getEvent_date(), e.getStart_time(), e.getEnd_time(), e.getClient_name(), e.getClient_phone(), e.getClient_email(), e.getStatus());
        e.setEvent_id((int) idinserted);
        return e;
    }
//    Cette methode permet de convetir un ResulSet en events

    static public Events converResultSettoEvents(ResultSet rs) throws SQLException {
        return new Events(rs.getInt("event_id"), rs.getInt("hall_id"), rs.getString("event_name"), rs.getDate("event_date"), rs.getDate("start_time"), rs.getDate("end_time"), rs.getString("client_name"), rs.getString("client_email"), rs.getString("client_phone"), rs.getString("status"), rs.getDate("created_at"));

    }
//    Cette methode permet de lister les evenements

    static public List<Events> selEventses() throws SQLException, ClassNotFoundException {
        List<Events> eventses = new ArrayList<>();
        ResultSet rs = DatabaseService.executeQuery(sql_select);
        while (rs.next()) {
            eventses.add(converResultSettoEvents(rs));

        }
        return eventses;
    }
    //    Cette methode permet de modifier un evenement

    //    Cette methode permet de
    static public int updateevent(Events e) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_update, e.getHall_id(), e.getEvent_name(), e.getEvent_date(), e.getStart_time(), e.getEnd_time(), e.getEvent_name(), e.getClient_email(), e.getClient_phone(), e.getStatus());
    }

    //    Cette methode permet de faire une recherche par nom client pour un evenement
    static public Events selectevent(String name) throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_searchbyname_client, name);
        if (rs.next()) {
            return converResultSettoEvents(rs);
        }
        return null;
    }

}

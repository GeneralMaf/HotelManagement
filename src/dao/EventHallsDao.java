/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.EventHalls;

/**
 *
 * @author I2S
 */
public class EventHallsDao {
    static final String sql_select="SELECT * FROM `event_halls`";
    static final String sql_insert="INSERT INTO `event_halls` (`hall_name`, `capacity`, `equipment`, `status`) VALUES (?,?,?,?);";
    static final String sql_update="UPDATE `event_halls` SET `hall_name` = ?, `equipment` = ?, `status` = ?,`capacity`=? WHERE `event_halls`.`hall_id` = ?;";
    static final String sql_delete="FROM event_halls WHERE `event_halls`.`hall_id` = 3";
//    Cette methode permet de creer une salle pour les evenements
    static public EventHalls createeventhall(EventHalls e) throws SQLException, ClassNotFoundException{
        long idinserted=DatabaseService.executeInsertWithGeneratedKey(sql_insert,e.getHall_name(),e.getCapacity(),e.getEquipment(),e.getStatus());
        e.setHall_id((int)idinserted);
        return e;
    }
    //    Cette methode permet de convertir un ResultSet a EventHall
    static public EventHalls convertResultSettoEventHall(ResultSet rs) throws SQLException{
    return new EventHalls(rs.getInt("hall_id"),rs.getString("hall_name"),rs.getInt("capacity"), rs.getString("equipment"),rs.getString("status"));
    }
    
    //    Cette methode permet de lister les salles pour les evenements
    static public List<EventHalls> selEventHallses() throws SQLException, ClassNotFoundException{
        ResultSet rs=DatabaseService.executeQuery(sql_select);
        List<EventHalls>eventHallses=new ArrayList<>();
        while (rs.next()) {
            eventHallses.add(convertResultSettoEventHall(rs));
            
        }
        return eventHallses;
      
        
    }
      //    Cette methode permet de modifier une salle d'evenment
    static public int updateEventHallses(EventHalls e) throws SQLException, ClassNotFoundException{
    return DatabaseService.executeUpdate(sql_update,e.getHall_name(),e.getEquipment(),e.getStatus(),e.getCapacity(),e.getHall_id());
    }
     //    Cette methode permet de supprimer une salle d'evenement
     static public int deleteEventHallses(EventHalls e) throws SQLException, ClassNotFoundException{
    return DatabaseService.executeUpdate(sql_update,e.getHall_id());
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Rooms;

/**
 *
 * @author I2S
 */
public class RoomsDao {

    static final String sql_select = "SELECT * FROM `rooms`";
    static final String sql_selectwhithidroom = "SELECT * FROM `rooms` WHERE room_id=?";
    static final String sql_selectwhithroomnumber = "SELECT * FROM `rooms` WHERE room_number=?";
    static final String sql_insert = "INSERT INTO `rooms` ( `room_number`, `room_type`, `status`, `price`, `description`) VALUES ( ?,?,?,?,?)";
    static final String sql_update = "UPDATE `rooms` SET `room_number` = ?, `room_type` = ?, `status` = ?, `price` =?, `description` =? WHERE `rooms`.`room_id` = ?";
    static final String sql_delete = "  DELETE FROM rooms WHERE `rooms`.`room_id` = ?  ";
    static final String sql_selectbystatus= "SELECT * FROM `rooms` WHERE status=?";
    //    Cette methode permet de creer un Rooms

    static public Rooms createrooms(Rooms r) throws SQLException, ClassNotFoundException {
        long idinserted = DatabaseService.executeInsertWithGeneratedKey(sql_insert, r.getRoom_number(), r.getRoom_type(), r.getStatus(), r.getPrice(), r.getDescription());
        r.setRoom_id((int) idinserted);
        return r;
    }
//    Cette methode permet de convertir un resultset en Rooms

    static final Rooms convertResultSettoRooms(ResultSet rs) throws SQLException {
        return new Rooms(rs.getInt("room_id"), rs.getString("room_number"), rs.getString("room_type"), rs.getString("status"), rs.getFloat("price"), rs.getString("description"));
    }
//    Cette methode permet de lister tous les chambres dans l'hotel
    static public List<Rooms> selectrooms() throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_select);
        List<Rooms> Rooms = new ArrayList<>();
        while (rs.next()) {
            Rooms.add(convertResultSettoRooms(rs));

        }
        return Rooms;

    }
    static public List<Rooms> selectroomsbystatus(String status) throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_selectbystatus,status);
        List<Rooms> Rooms = new ArrayList<>();
        while (rs.next()) {
            Rooms.add(convertResultSettoRooms(rs));

        }
        return Rooms;

    }
    
    static public Rooms sql_selectwhitroomnumber(Rooms r) throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_selectwhithroomnumber,r.getRoom_number());
       
        while (rs.next()) {
            return convertResultSettoRooms(rs);

        }
        return null;

    }
    static public Rooms sql_selectwhitroomid(int id) throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_selectwhithidroom,id);
       
        while (rs.next()) {
            return convertResultSettoRooms(rs);

        }
        return null;

    }
    //    Cette methode permet de modifier une chambre
    static final int updateRomm(Rooms r) throws SQLException, ClassNotFoundException{
    return DatabaseService.executeUpdate(sql_update,r.getRoom_number(),r.getRoom_type(),r.getStatus(),r.getPrice(),r.getDescription());
    
    }
     //    Cette methode permet de supprimer une chambre
    static final int deleteRooms(Rooms r)throws SQLException, ClassNotFoundException{
    return DatabaseService.executeUpdate(sql_delete,r.getRoom_id());
    }

}

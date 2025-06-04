/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Rooms;

public class RoomsDao {

    static final String sql_insert = "INSERT INTO rooms (room_number, room_type, statut, price, description) VALUES (?, ?, ?, ?, ?)";
    static final String sql_select = "SELECT * FROM rooms";
    static final String sql_selectbyid = "SELECT * FROM rooms WHERE room_id = ?";
    static final String sql_update = "UPDATE rooms SET room_number = ?, room_type = ?, statut = ?, price = ?, description = ? WHERE room_id = ?";
    static final String sql_delete = "DELETE FROM rooms WHERE room_id = ?";

    public static Rooms ajouterRoom(Rooms r) throws SQLException, ClassNotFoundException {
        long id = DatabaseService.executeInsertWithGeneratedKey(sql_insert, r.getRoom_number(), r.getRoom_type(), r.getStatus(), r.getPrice(), r.getDescription());
        r.setRoom_id((int) id);
        return r;
    }

    public static Rooms convertirResultSet(ResultSet rs) throws SQLException {
        return new Rooms(
            rs.getInt("room_id"),
            rs.getString("room_number"),
            rs.getString("room_type"),
            rs.getString("statut"), (float) rs.getDouble("price"),
            rs.getString("description")
        );
    }

    public static List<Rooms> listerRooms() throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_select);
        List<Rooms> list = new ArrayList<>();
        while (rs.next()) {
            list.add(convertirResultSet(rs));
        }
        return list;
    }

    public static Rooms getRoomById(int id) throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_selectbyid, id);
        if (rs.next()) {
            return convertirResultSet(rs);
        }
        return null;
    }

    public static int modifierRoom(Rooms r) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_update, r.getRoom_number(), r.getRoom_type(), r.getStatus(), r.getPrice(), r.getDescription(), r.getRoom_id());
    }

    public static int supprimerRoom(int id) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_delete, id);
    }
}

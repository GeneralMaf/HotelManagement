/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.MenuDao.convertResultSettoMenu;
import static dao.MenuDao.sql_delete;
import static dao.MenuDao.sql_insert;
import static dao.MenuDao.sql_select;
import static dao.MenuDao.sql_update;
import java.sql.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.CateringOrders;
import models.Menu;

/**
 *
 * @author I2S
 */
public class CateingOrdersDao {

    public static final String sql_select = "SELECT * FROM `catering_orders` WHERE 1";
    public static final String sql_insert = "INSERT INTO `catering_orders` (`reservation_id`, `menu_item_id`, `quantity`,`order_date`, `status`) VALUES (?,?,?,?,?)";
    public static final String sql_update = "UPDATE `catering_orders` SET `reservation_id` = ?, `menu_item_id` = ?, `quantity` = ?, `status` = ? WHERE `catering_orders`.`order_id` =?";
    public static final String sql_updatestatus = "UPDATE `catering_orders` SET `status` = 'delivered' WHERE `catering_orders`.`order_id` = ?";
    public static final String sql_delete = "DELETE FROM catering_orders WHERE `catering_orders`.`order_id` = ?";
    //    Cette methode permet de creer un service

    public static CateringOrders createMenu(CateringOrders co) throws SQLException, ClassNotFoundException {
        java.sql.Date sqlDate = java.sql.Date.valueOf(co.getOrder_date());
        
        int idinserted = (int) DatabaseService.executeInsertWithGeneratedKey(sql_insert, co.getReservation_id(), co.getMenu_item_id(), co.getQuantity(), sqlDate, co.getStatus());
        co.setOrder_id(idinserted);
        return co;
    }
    //    Cette methode permet de convertir un resultset a un service

    public static CateringOrders convertResultSettoMenu(ResultSet rs) throws SQLException, ClassNotFoundException {
        java.sql.Date d = rs.getDate("order_date");
        LocalDate localDate = d.toLocalDate();

        return new CateringOrders(rs.getInt("order_id"), rs.getInt("reservation_id"), rs.getInt("menu_item_id"), rs.getInt("quantity"), localDate, rs.getString("status"));
    }
    //    Cette methode permet d'afficher la liste des services

    public static List<CateringOrders> selectMenu() throws SQLException, ClassNotFoundException {

        ResultSet rs = DatabaseService.executeQuery(sql_select);
        List<CateringOrders> myList = new ArrayList<>();
        while (rs.next()) {
            myList.add(convertResultSettoMenu(rs));
        }
        return myList;
    }
    //    Cette methode permet de modifier une service

    public static int updateMenu(CateringOrders co) throws SQLException, ClassNotFoundException {

        return DatabaseService.executeUpdate(sql_update, co.getReservation_id(), co.getMenu_item_id(), co.getQuantity(), co.getStatus(), co.getOrder_id());

    }
    public static int updateMenuStatus(CateringOrders co) throws SQLException, ClassNotFoundException {

        return DatabaseService.executeUpdate(sql_updatestatus, co.getOrder_id());

    }
    //    Cette methode permet de supprimer une service

    public static int deleteMenu(CateringOrders co) throws SQLException, ClassNotFoundException {

        return DatabaseService.executeUpdate(sql_delete, co.getOrder_id());

    }

}

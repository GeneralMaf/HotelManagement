/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Menu;

/**
 *
 * @author I2S
 */
public class MenuDao {

    public static final String sql_select = "SELECT * FROM `menu`";
    public static final String sql_insert = "INSERT INTO `menu` (`item_name`, `category`, `price`, `stock_quantity`, `description`) VALUES (?,?, ?,?, ?);";
    public static final String sql_update = "UPDATE `menu` SET `item_name` = ?, `category` = ?, `price` = ?, `stock_quantity` = ?, `description` = ? WHERE `menu`.`menu_item_id` = ?;";
    public static final String sql_delete = " DELETE FROM menu WHERE `menu`.`menu_item_id` = ?";
//    Cette methode permet de creer un menu

    public static Menu createMenu(Menu m) throws SQLException, ClassNotFoundException {
        int idinserted = (int) DatabaseService.executeInsertWithGeneratedKey(sql_insert, m.getItem_name(), m.getCategory(), m.getPrice(), m.getStock_quantity(), m.getDescription());
        m.setMenu_item_id(idinserted);
        return m;
    }
//    Cette methode permet de convertir un resultset a un menu

    public static Menu convertResultSettoMenu(ResultSet rs) throws SQLException, ClassNotFoundException {

        return new Menu(rs.getInt("menu_item_id"), rs.getString("item_name"), rs.getString("category"), rs.getFloat("price"), rs.getInt("stock_quantity"), rs.getString("description"));
    }
    //    Cette methode permet d'afficher la liste des menus

    public static List<Menu> selectMenu() throws SQLException, ClassNotFoundException {

        ResultSet rs = DatabaseService.executeQuery(sql_select);
        List<Menu> myList = new ArrayList<>();
        while (rs.next()) {
            myList.add(convertResultSettoMenu(rs));
        }
        return myList;
    }
    //    Cette methode permet de modifier un menu

    public static int updateMenu(Menu m) throws SQLException, ClassNotFoundException {

        return DatabaseService.executeUpdate(sql_update,m.getItem_name(),m.getCategory(),m.getPrice(),m.getStock_quantity(),m.getDescription());
                
    }
     //    Cette methode permet de supprimer un menu
    public static int deleteMenu(Menu m) throws SQLException, ClassNotFoundException {

        return DatabaseService.executeUpdate(sql_delete,m.getMenu_item_id());
                
    }
}

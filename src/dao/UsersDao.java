/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.ReservationsDao.convertResultsettoreservatiovs;
import static dao.ReservationsDao.sql_recherchebyname;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Reservations;
import models.Users;

/**
 *
 * @author I2S
 */
public class UsersDao {
    static final String sql_insert="INSERT INTO `users` ( `username`, `password`, `role`, `full_name`, `email`, `phone`) VALUES ( ?, ?,?,?,?,?);";
    static final String sql_select="SELECT * FROM `users` WHERE 1";
    static final String sql_selectbyusername="SELECT * FROM `users` WHERE username = ?";
    static final String sql_update="UPDATE `users` SET `username` = ?, `password` = ?, `full_name` = ?, `email` = ?, `phone` = ? WHERE `users`.`user_id` = ?;";
    static final String sql_recherchebyname = "SELECT * FROM `users` WHERE full_name LIKE '%?%'";
    //    Cette methode permet de creer d'utilisateur
    public static Users createuser(Users u) throws SQLException, ClassNotFoundException{
        long idinserted=  DatabaseService.executeInsertWithGeneratedKey(sql_insert,u.getUsername(),u.getPassword(),u.getRole(),u.getFull_name(),u.getMail(),u.getPhone());
        u.setUser_id(idinserted);
        return u;
    }
//    cette methode permet de convertir un ResultSet en Users 
    public static Users convertuserstoResultset(ResultSet rs) throws SQLException {
        return new Users(rs.getInt("user_id"),rs.getString("username"),rs.getString("password"),rs.getString("role"),rs.getString("full_name"),rs.getString("email"),rs.getString("phone"),rs.getDate("created_at"));
    }
    //    Cette methode permet de Retourner tous les utilisateurs
    public static List<Users> selectusers() throws SQLException, ClassNotFoundException{
        ResultSet rs=DatabaseService.executeQuery(sql_select);
        List<Users> users=new ArrayList<>();
        while(rs.next()){
            users.add(convertuserstoResultset(rs));
        }
        return users;
    }
//    cette methode permet de selectionner un utilisateur par son username
    public static Users selectusersbyusername(String u) throws SQLException, ClassNotFoundException{
        ResultSet rs=DatabaseService.executeQuery(sql_selectbyusername,u);
       
        if(rs.next()){
          return convertuserstoResultset(rs);
        }
        return null;
    }
//    Cette methode permet de recher un user par son full_name
     public static Reservations rechercherchereservationbynameclient(String name) throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_recherchebyname, name);
        if (rs.next()) {
            return convertResultsettoreservatiovs(rs);
        }
        return null;
    }
    //    Cette methode permet de modifier un utilisateur
    public static int updateusers(Users u) throws SQLException, ClassNotFoundException{
        return DatabaseService.executeUpdate(sql_update,u.getUsername(),u.getPassword(),u.getRole(),u.getFull_name(),u.getMail(),u.getPhone());
    }
}

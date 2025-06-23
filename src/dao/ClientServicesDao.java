/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.ClientServices;
import models.Reservations;

/**
 *
 * @author I2S
 */
public class ClientServicesDao {

    static final String sql_select = "SELECT * FROM `client_services`";
    static final String sql_insert = "INSERT INTO `client_services` ( `reservation_id`, `service_type`, `status`, `request_date`, `completion_date`, `description`) VALUES (?,?,?,?,?,?)";
    static final String sql_update = "UPDATE `client_services` SET `reservation_id` =?, `service_type` = ?, `completion_date` = ?, `description` = ? WHERE `client_services`.`service_id` = ?";
    static final String sql_delete = " DELETE FROM client_services WHERE `client_services`.`service_id` = ?";
    static final String sql_searchbyreservation_id = "SELECT * FROM `client_services`JOIN reservations WHERE client_services.service_id=? AND reservations.client_name LIKE \"%?%\";";
//Cette methode permet de creer une service pour un client

    static public ClientServices createClientServices(ClientServices cs) throws SQLException, ClassNotFoundException {
         java.sql.Date sqlDate = java.sql.Date.valueOf(cs.getRequest_date());
         java.sql.Date sqlDate1 = java.sql.Date.valueOf(cs.getCompletion_date());
        long idinserted = DatabaseService.executeInsertWithGeneratedKey(sql_insert, cs.getReservation_id(), cs.getService_type(), cs.getStatus(),sqlDate, sqlDate1, cs.getDescription());
        cs.setService_id((int) idinserted);
        return cs;
    }
//Cette methode permet de convertir un ResultSet a un ClientServices

    static public ClientServices convertResultSettoClientServices(ResultSet rs) throws SQLException {
        java.sql.Date d = rs.getDate("request_date");
        LocalDate localDate = d.toLocalDate();
        java.sql.Date d1 = rs.getDate("completion_date");
        LocalDate localDate1 = d1.toLocalDate();
        return new ClientServices(rs.getInt("service_id "), rs.getInt("reservation_id"), rs.getString("ervice_type"), rs.getString("status"),localDate, localDate1, rs.getString("description"));
    }
    //Cette methode permet de  lister la liste des reservations

    static public List<ClientServices> selectClientServices() throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_select);
        List<ClientServices> ClientServices = new ArrayList<>();
        while (rs.next()) {
            ClientServices.add(convertResultSettoClientServices(rs));
        }
        return ClientServices;

    }
    //Cette methode permet de  modifier une service d'un client

    static public int updateClientServices(ClientServices cs) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_insert, cs.getReservation_id(), cs.getService_type(), cs.getCompletion_date(), cs.getDescription(), cs.getService_id());
    }

    //Cette methode permet de  supprimer une service d'un client
    static public int deleteClientServices(ClientServices cs) throws SQLException, ClassNotFoundException {
        return DatabaseService.executeUpdate(sql_insert, cs.getService_id());
    }

    //Cette methode permet de  Faire une recherche par nom de client pour afficher ces  services 
    static public List<ClientServices> earchbyreservation_idClientServices(Reservations r, String s) throws SQLException, ClassNotFoundException {
        ResultSet rs = DatabaseService.executeQuery(sql_searchbyreservation_id, r.getReservation_id(), s);
        List<ClientServices> ClientServices = new ArrayList<>();
        while (rs.next()) {
           ClientServices.add(convertResultSettoClientServices(rs));
        }
        return ClientServices;
    }
}

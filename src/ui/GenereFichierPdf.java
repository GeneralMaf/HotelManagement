/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author I2S
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.RoomsDao;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Reservations;
import models.Rooms;


public class GenereFichierPdf {
    static int x=1;
    public static void generatePDF(List<Reservations>reservations) throws DocumentException, java.io.IOException {
        Document document = new Document();
        ++x;
        PdfWriter.getInstance(document, new FileOutputStream("Reservations"+x+".pdf"));
        document.open();

        document.add(new Paragraph("Liste des Réservations"));
        document.add(new Paragraph("Date: 22 Juin 2025"));
        document.add(new Paragraph("\n"));

        PdfPTable table = new PdfPTable(7);
        table.addCell("Nom du Client");
        table.addCell("Email du Client");
        table.addCell("Numéro de téléphone du Client");
        table.addCell("Numéro de Chambre");
        table.addCell("Status de la reservation");
        table.addCell("Date d'Arrivée");
        table.addCell("Date de Départ");
        Rooms r;
        for (Reservations reservation : reservations) {
            try {
                r=RoomsDao.sql_selectwhitroomid(reservation.getRoom_id());
                table.addCell(reservation.getClient_name());
                table.addCell(reservation.getClient_email());
                table.addCell(reservation.getClient_phone());
                table.addCell(r.getRoom_number());
                table.addCell(reservation.getStatus());
                table.addCell(reservation.getCheck_in_date().toString());
                table.addCell(reservation.getCheck_out_date().toString());
            } catch (SQLException ex) {
                Logger.getLogger(GenereFichierPdf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GenereFichierPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        document.add(table);
        document.close();
    }

}

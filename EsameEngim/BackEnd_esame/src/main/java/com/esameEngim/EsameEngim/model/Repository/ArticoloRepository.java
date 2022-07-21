package com.esameEngim.EsameEngim.model.Repository;

import com.esameEngim.EsameEngim.constant.DBconnection;
import com.esameEngim.EsameEngim.model.Articolo;

import java.sql.*;
import java.util.ArrayList;

public class ArticoloRepository {
    public static ArrayList<Articolo> getArticoli() {
        // creo una lista da restituire
        ArrayList<Articolo> articoli = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DBconnection.DB, DBconnection.USER, DBconnection.PSW);
            PreparedStatement stmt = conn.prepareStatement("select * from articoli");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Articolo articolo = new Articolo(
                        rs.getInt("id"),
                        rs.getString("codice"),
                        rs.getString("descrizione"),
                        rs.getDouble("peso")
                );
                articoli.add(articolo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return articoli;
    }


    public static ArrayList<Articolo> getArticoliPerOrdine(int id) {

        ArrayList<Integer> idArticoliOrdine = new ArrayList<>();
        ArrayList<Articolo> articoliOrdinati = new ArrayList<>();

        //prendo id di articoli del singolo ordine
        try {
            Connection conn = DriverManager.getConnection(DBconnection.DB, DBconnection.USER, DBconnection.PSW);
            PreparedStatement stmt = conn.prepareStatement("select * from voci where id_ordine = ? ");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            //mi ricavo tutti gli id degli articoli
            while (rs.next()) {
                id = rs.getInt("articolo");
                idArticoliOrdine.add(id);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        //per ogni id aggiungo articolo
        for (int id_article: idArticoliOrdine) {
            try {
                Connection conn = DriverManager.getConnection(DBconnection.DB, DBconnection.USER, DBconnection.PSW);
                PreparedStatement stmt = conn.prepareStatement("select * from articoli where id = ? ");
                stmt.setInt(1, id_article);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Articolo articolo = new Articolo(
                            rs.getInt("id"),
                            rs.getString("codice"),
                            rs.getString("descrizione"),
                            rs.getDouble("peso"));

                    articoliOrdinati.add(articolo);
                }

            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return articoliOrdinati;

    }
}

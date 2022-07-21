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
}

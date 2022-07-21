package com.esameEngim.EsameEngim.model.Repository;

import com.esameEngim.EsameEngim.constant.DBconnection;
import com.esameEngim.EsameEngim.model.Ordine;

import java.sql.*;
import java.util.ArrayList;

public class OrdineRepository {

    public static ArrayList<Ordine> getOrdini() {
        // creo una lista da restitutive
        ArrayList<Ordine> ordini = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DBconnection.DB, DBconnection.USER, DBconnection.PSW);
            PreparedStatement stmt = conn.prepareStatement("select * from ordini");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                // creo una lista degli ordini presi dal DB
                Ordine ordine = new Ordine(
                        rs.getInt("id"),
                        rs.getInt("numero"),
                        rs.getString("data"));

                // aggiungo alla lista
                ordini.add(ordine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return ordini;
    }
}


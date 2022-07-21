package com.esameEngim.EsameEngim.model.Repository;

import com.esameEngim.EsameEngim.constant.DBconnection;
import com.esameEngim.EsameEngim.model.TariffaCorriere;

import java.sql.*;
import java.util.ArrayList;

public class TariffaCorriereRepository {
    public static ArrayList<TariffaCorriere> getTariffe(){
        // creo una lista da restituire
        ArrayList<TariffaCorriere> tariffe = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection(DBconnection.DB, DBconnection.USER, DBconnection.PSW);
            PreparedStatement stmt = conn.prepareStatement("select * from tariffa_corrieri");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                TariffaCorriere tariffa = new TariffaCorriere(
                        rs.getInt("id"),
                        rs.getString("nome_corriere"),
                        rs.getString("nome_tariffa"),
                        rs.getDouble("peso_massimo"),
                        rs.getDouble("costo")
                );
                tariffe.add(tariffa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return tariffe;
    }
}

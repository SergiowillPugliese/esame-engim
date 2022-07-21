package com.esameEngim.EsameEngim.model.Repository;

import com.esameEngim.EsameEngim.constant.DBconnection;
import com.esameEngim.EsameEngim.model.Voce;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoceRepository {

    public static List<Voce> getVoce() {
        List<Voce> listaVoce = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DBconnection.DB, DBconnection.USER, DBconnection.PSW);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM voci");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Voce voce = new Voce(
                        resultSet.getInt("id_ordine"),
                        resultSet.getInt("articolo"),
                        resultSet.getInt("quantità")
                );
                listaVoce.add(voce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVoce;
    }
}

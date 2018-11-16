package com.tgt.testapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresDAO {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";

        try (Connection con = DriverManager.getConnection(url);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * from user_cred_table")) {

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


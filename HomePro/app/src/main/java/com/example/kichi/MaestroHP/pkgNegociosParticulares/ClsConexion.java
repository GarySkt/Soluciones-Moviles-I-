package com.example.kichi.MaestroHP.pkgNegociosParticulares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kichi on 29/08/2017.
 */

public class ClsConexion {
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String con = "jdbc:jtds:sqlserver://192.168.43.47;port=1433;databaseName=homepro;user=sa;password=123;";
            connection = DriverManager.getConnection(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

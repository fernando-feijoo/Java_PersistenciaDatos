package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje_app", "root", "");
            if (conexion != null) {
                System.out.println("Conexion exitosa.");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e);
        }
        return conexion;
    }
}

package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajesDAO {
    public static void crearMensajeBD(MensajesModelo mensaje){
        Conexion bd_conecxion = new Conexion();
        try (Connection conexion = bd_conecxion.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.execute();
                System.out.println("Mensaje creado correctamente.");
            } catch (SQLException e) {
                System.out.println("Error crear mensaje: " + e);
            }
            
        } catch (SQLException e) {
            System.out.println("DAO Error: " + e);
        }
    }
    
    public static void leerMensajeBD(){
        
    }
    
    public static void borrarMensajeBD(int idMensaje){
        
    }
    
    public static void actualizarMensajeBD(MensajesModelo mensaje){
        
    }
}

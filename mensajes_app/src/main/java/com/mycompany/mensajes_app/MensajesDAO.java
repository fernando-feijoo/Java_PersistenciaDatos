package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeBD(MensajesModelo mensaje) {
        Conexion bd_conecxion = new Conexion();
        try ( Connection conexion = bd_conecxion.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.execute();
                System.out.println("Mensaje creado correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al crear mensaje: " + e);
            }

        } catch (SQLException e) {
            System.out.println("DAO Error: " + e);
        }
    }

    public static void leerMensajeBD() {
        Conexion bd_conecxion = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try ( Connection conexion = bd_conecxion.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar los mensajes.");
            System.out.println("Error al leer mensaje: " + e);
        }
    }

    public static void borrarMensajeBD(int idMensaje) {
        Conexion bd_conecxion = new Conexion();
        PreparedStatement ps = null;
        try ( Connection conexion = bd_conecxion.get_connection()) {
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.execute();
                System.out.println("El mensaje ha sido borrado.");
            } catch (SQLException e) {
                System.out.println("Error al eliminar mensaje: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error crear mensaje: " + e);
        }
    }

    public static void actualizarMensajeBD(MensajesModelo mensaje) {
        Conexion bd_conecxion = new Conexion();
        PreparedStatement ps = null;
        try ( Connection conexion = bd_conecxion.get_connection()) {
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.execute();
                System.out.println("Mensaje acualizado correctamente.");
            } catch (SQLException e) {
                System.out.println("Mensaje no se pudo actualizar. " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar mensaje: " + e);
        }
    }
}

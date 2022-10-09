package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("=============================");
            System.out.println("||  Aplicación de Mensajes ||");
            System.out.println("||-------------------------||");
            System.out.println("||   1.- Crear mensaje     ||");
            System.out.println("||   2.- Listar mensaje    ||");
            System.out.println("||   3.- Editar mensaje    ||");
            System.out.println("||   4.- Eliminar mensaje  ||");
            System.out.println("||   5.- Salir             ||");
            System.out.println("=============================");
            opcion = tc.nextInt();
            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensajes();
                    break;
                case 4:
                    MensajesService.borrarMensajes();
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
        Conexion conexion = new Conexion();
        try ( Connection cnx = conexion.get_connection()) {
        } catch (SQLException e) {
            System.out.println("Error conexion Main: " + e);
        }
    }
}

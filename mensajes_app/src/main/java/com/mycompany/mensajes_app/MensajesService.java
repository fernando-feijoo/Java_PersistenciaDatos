package com.mycompany.mensajes_app;

import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje() {
        Scanner tc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje:");
        String mensaje = tc.nextLine();
        System.out.println("Escribe tu nombre:");
        String nombre = tc.nextLine();

        MensajesModelo registro = new MensajesModelo();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        MensajesDAO.crearMensajeBD(registro);
    }

    public static void listarMensajes() {
        MensajesDAO.leerMensajeBD();
    }

    public static void borrarMensajes() {
        Scanner tc = new Scanner(System.in);
        System.out.println("Indique el ID del mensaje a eliminar: ");
        int id_mensaje = tc.nextInt();
        MensajesDAO.borrarMensajeBD(id_mensaje);
    }

    public static void editarMensajes() {
        Scanner tc = new Scanner(System.in);
        System.out.println("Escriba su nuevo mensaje:");
        String mensaje = tc.nextLine();

        System.out.println("Indique el ID del mensaje a editar:");
        int id_mensaje = tc.nextInt();

        MensajesModelo actualizacion = new MensajesModelo();
        actualizacion.setIdMensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);

        MensajesDAO.actualizarMensajeBD(actualizacion);
    }
}

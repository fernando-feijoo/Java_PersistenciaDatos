package com.mycompany.mensajes_app;

import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
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
    
    public static void listarMensajes(){
        
    }
    
    public static void borrarMensajes(){
        
    }
    
    public static void editarMensajes(){
        
    }
}

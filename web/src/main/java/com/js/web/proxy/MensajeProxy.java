package com.js.web.proxy;

public class MensajeProxy implements Mensaje{

    private Mensaje mensaje;

    public MensajeProxy(Mensaje mensaje){
        this.mensaje = mensaje;
    }

    @Override
    public void hola() {
        System.out.println("MensajeProxy: Antes de llamar a hola");
        mensaje.hola();
        System.out.println("MensajeProxy: Después de llamar a hola");
    }

}

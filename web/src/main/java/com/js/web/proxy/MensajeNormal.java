package com.js.web.proxy;

public class MensajeNormal implements Mensaje{
    @Override
    public void hola() {
        System.out.println("Soy el mensaje de hola :)");
    }
}

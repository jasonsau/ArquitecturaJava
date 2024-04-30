package com.js.web.proxy;

public class MensajeFactory {

    public static Mensaje getInstance(){
        return new MensajeProxy(new MensajeNormal());
    }
}

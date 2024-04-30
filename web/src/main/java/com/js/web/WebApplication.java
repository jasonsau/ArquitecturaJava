package com.js.web;

import com.js.web.proxy.Mensaje;
import com.js.web.proxy.MensajeFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		Mensaje m = MensajeFactory.getInstance();
		m.hola();
		SpringApplication.run(WebApplication.class, args);
	}

}

package com.alura.literatura;

import com.alura.literatura.config.ConfigConst;
import com.alura.literatura.service.ConsumoApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.alura.literatura.config.ConfigConst.URL_API;

@SpringBootApplication
public class LiteraturaApplication {

	public static void main(String[] args) {

		SpringApplication.run(LiteraturaApplication.class, args);

		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese el autor o libro :");
		var busqueda = teclado.nextLine();

		String url = URL_API + busqueda;

		var consumoApi = new ConsumoApi();
		var json = consumoApi.ObtenerDatos(url);

		System.out.println(json);
	}

}

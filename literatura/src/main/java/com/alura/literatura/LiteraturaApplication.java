package com.alura.literatura;

import com.alura.literatura.config.ConfigConst;
import com.alura.literatura.model.Datos;
import com.alura.literatura.model.DatosLibro;
import com.alura.literatura.service.ConsumoApi;
import com.alura.literatura.service.ConvierteDatos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.alura.literatura.config.ConfigConst.URL_API;

@SpringBootApplication
public class LiteraturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
		var consumoApi = new ConsumoApi();
		// class Consumo Api -> metodo ObtenerDatos -> recibe url y devuelve json
		ConvierteDatos conversor = new ConvierteDatos();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese titulo del libro que busca: ");
		var busqueda = teclado.nextLine();

		String url = URL_API + busqueda.replace(" ", "%20");

		String json = consumoApi.ObtenerDatos(url);

		var datos = conversor.obtenerDatos(json, Datos.class);

		datos.listaLibros().forEach(libro -> {
			System.out.println(libro.titulo() + " - " + libro.descargas() + " descargas");

			libro.listaAutores().stream()
					.map(autor -> "Autor: " + autor.nombreAutor() + "(" + autor.anoDesde() + "-" + autor.anoHasta() + ")")
					.forEach(System.out::println);
		});

	}
}

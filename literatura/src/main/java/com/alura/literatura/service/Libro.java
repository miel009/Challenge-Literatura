package com.alura.literatura.service;

import com.alura.literatura.model.Datos;

import static com.alura.literatura.config.ConfigConst.URL_API;

public class Libro {
    ConvierteDatos conversor = new ConvierteDatos();
    private final ConsumoApi consumoApi = new ConsumoApi();

    public void buscarLibro(String nombreLibro) {
        String url = URL_API + nombreLibro.replace(" ", "%20");
        String json = consumoApi.ObtenerDatos(url);
        var datos = conversor.obtenerDatos(json, Datos.class);

        datos.listaLibros().stream()
                .limit(2)
                .forEach(l -> {
                    System.out.println("--- LIBRO ENCONTRADO ---" +
                            "\nTítulo: " + l.titulo() +
                            "\nDescargas: " + l.descargas() +
                            "\n(Idioma: " + l.ListaIdioma() + ")");

                    l.listaAutores().stream()
                            .map(autor -> "Autor: " + autor.nombreAutor() +
                                    "(" + autor.anoDesde() + "-" + autor.anoHasta() + ")")
                            .forEach(System.out::println);
                });
    }
}


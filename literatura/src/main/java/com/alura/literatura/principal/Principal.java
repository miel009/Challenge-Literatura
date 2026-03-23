package com.alura.literatura.principal;

import com.alura.literatura.service.Libro;

import java.util.Scanner;

public class Principal {
    Scanner teclado = new Scanner(System.in);
    private final Libro libro = new Libro();

    public void muestraMenu() {

        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    ------------------------------------------
                    1 - Buscar libro por título
                    0 - Salir
                    ------------------------------------------
                    """;
            System.out.println(menu);
            System.out.print("Elija una opción: ");

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el titulo del libro:");
                        var nombre = teclado.nextLine();
                        libro.buscarLibro(nombre);
                        break;
                    case 2:
                        break;
                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor, intente otra vez");
                teclado.nextLine();
            }
        }
    }

}


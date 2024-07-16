package com.alurachallenge.modulos;

import com.alurachallenge.conexiones.ConversionDivisas;
import com.alurachallenge.conexiones.DivisasEquivalentes;
import com.alurachallenge.conexiones.ListaDivisas;
import com.alurachallenge.records.DatosMoneda;
import com.alurachallenge.records.DivisasDisponibles;

import java.util.Scanner;

public class Menu {
    public void mostrarMenu(){
        System.out.println("************ M E N U ************");
        System.out.println("1.- Divisas y equivalencias.");
        System.out.println("2.- Convertir divisa.");
        System.out.println("3.- Mostrar lista de divisas.");
        System.out.println("4.- SALIR");

        Scanner lectura = new Scanner(System.in);
        Menu menu = new Menu();

        DivisasEquivalentes nuevaDivisasEquivalentes = new DivisasEquivalentes();
        ListaDivisas nuevaLista = new ListaDivisas();
        ConversionDivisas conversion = new ConversionDivisas();

        var opcionDelMenu = -1;


        while (opcionDelMenu != 4) {

            menu.mostrarMenu();
            System.out.println("\nEscriba la opción del menú:");
            opcionDelMenu = lectura.nextInt();

            DatosMoneda datosMoneda = null;
            if (opcionDelMenu == 1) {
//                    Divisa y sus equivalencias en otras divisas.

                System.out.println("Que divisa quiere consultar? ");
                var tipoCambio = lectura.next();
                datosMoneda = nuevaDivisasEquivalentes.moneda(tipoCambio);
                System.out.println(datosMoneda);

            } else if (opcionDelMenu == 2) {
//                  Conversion de entre dos divisas.
                System.out.println("****** SE RECOMIENDA VER LA OPCION 3, DONDE APARECEN LAS DIVISAS DISPONIBLES ******.\n");

                System.out.println("Escriba la divisa a convertir (Ejemplo: usd):");
                String monedaOrigen = lectura.next().toUpperCase();

                System.out.println("Escriba la divisa a la que quiere convertir (Ejemplo: mxn):");
                String monedaDestino = lectura.next().toUpperCase();

                System.out.println("Digite cual es el monto a convertir: ");
                double monto = lectura.nextDouble();
                if (monto == 0 || monto < 0) monto = 1.0;

                conversion.convertorDivisas(monedaOrigen, monedaDestino);

//                double transaccion = conversion.cambioDivisa(monedaOrigen, monedaDestino, monto);
//                System.out.println(transaccion);



            } else if (opcionDelMenu == 3) {
//                    Lista de divisas disponibles
                System.out.println("Estas son las divisas disponibles en la API");
                DivisasDisponibles listaDivisas = nuevaLista.listaDivisas();
                System.out.println(listaDivisas);
            } else {
                System.out.println("Gracias por utilizar el sistema de divisas.");
                break;
            }

        }

    }
}

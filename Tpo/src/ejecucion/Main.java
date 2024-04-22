package ejecucion;

import java.util.Scanner;

import colas.Implementacion_2_colas;
import conjunto.Implementacion_colas;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Implementacion_2_colas colaPrioridad = new Implementacion_2_colas();
        colaPrioridad.InicializarCola();

        Implementacion_colas conjuntoEmpresa = new Implementacion_colas();
        Implementacion_colas conjuntoParticularCliente = new Implementacion_colas();
        Implementacion_colas conjuntoParticularNoCliente = new Implementacion_colas();

        conjuntoEmpresa.InicializarConjunto();
        conjuntoParticularCliente.InicializarConjunto();
        conjuntoParticularNoCliente.InicializarConjunto();

        System.out.println("Ingrese al menos 15 elementos en la siguiente forma: ID_CLIENTE TIPO_CLIENTE");
        System.out.println("Donde TIPO_CLIENTE puede ser: 1 (Empresa), 2 (Particular cliente), 3 (Particular no cliente)");

        int i = 0;
        while (i < 15) {
            System.out.print("Elemento " + (i + 1) + ": ");
            String entrada = scanner.nextLine();
            String[] partes = entrada.split(" ");
            boolean entradaValida = true;

            if (partes.length != 2) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                entradaValida = false;
            } else {
                try {
                    int idCliente = Integer.parseInt(partes[0]);
                    int tipoCliente = Integer.parseInt(partes[1]);

                    if (tipoCliente < 1 || tipoCliente > 3) {
                        System.out.println("Tipo de cliente inválido. Intente nuevamente.");
                        entradaValida = false;
                    }

                    if (entradaValida) {
                        colaPrioridad.AcolarPrioridad(idCliente, tipoCliente);
                        i++; // Solo incrementamos i si todos los datos son válidos
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato de número inválido. Intente nuevamente.");
                    entradaValida = false;
                }
            }
            // Si entradaValida sigue siendo falso, se continuará con el siguiente ciclo del while sin incrementar i
        }

        scanner.close();

        // Desencolar clientes y agregarlos a los Conjuntos correspondientes
        while (!colaPrioridad.ColaVacia()) {
            int idCliente = colaPrioridad.Primero();
            int tipoCliente = colaPrioridad.Prioridad();
            colaPrioridad.Desacolar();

            switch (tipoCliente) {
                case 1:
                    conjuntoEmpresa.Agregar(idCliente);
                    break;
                case 2:
                    conjuntoParticularCliente.Agregar(idCliente);
                    break;
                case 3:
                    conjuntoParticularNoCliente.Agregar(idCliente);
                    break;
            }
        }

        // Imprimir los Conjuntos
        System.out.println("Conjunto Empresa:");
        imprimirConjunto(conjuntoEmpresa);

        System.out.println("\nConjunto Particular Cliente:");
        imprimirConjunto(conjuntoParticularCliente);

        System.out.println("\nConjunto Particular No Cliente:");
        imprimirConjunto(conjuntoParticularNoCliente);
    }

    private static void imprimirConjunto(Implementacion_colas conjunto) {
        if (conjunto.ConjuntoVacio()) {
            System.out.println("El conjunto está vacío.");
        } else {
            boolean primerElemento = true;
            while (!conjunto.ConjuntoVacio()) {
                int elemento = conjunto.Elegir();
                conjunto.Sacar(elemento);
                if (primerElemento) {
                    System.out.print(elemento);
                    primerElemento = false;
                } else {
                    System.out.print(" " + elemento);
                }
            }
        }
        System.out.println();
    }
    
}
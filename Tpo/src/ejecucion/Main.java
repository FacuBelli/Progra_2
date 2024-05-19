package ejecucion;

import java.util.Scanner;

import colas.Implementacion_2_colas;
import conjunto.Implementacion_colas;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear e inicializar la cola con prioridad
        Implementacion_2_colas colaPrioridad = new Implementacion_2_colas();
        colaPrioridad.InicializarCola();

        // Crear e inicializar los conjuntos para cada tipo de cliente
        Implementacion_colas conjuntoEmpresa = new Implementacion_colas();
        Implementacion_colas conjuntoParticularCliente = new Implementacion_colas();
        Implementacion_colas conjuntoParticularNoCliente = new Implementacion_colas();

        conjuntoEmpresa.InicializarConjunto();
        conjuntoParticularCliente.InicializarConjunto();
        conjuntoParticularNoCliente.InicializarConjunto();

        // Solicitar al usuario ingresar al menos 15 elementos
        System.out.println("Ingrese al menos 15 elementos en la siguiente forma: ID_CLIENTE TIPO_CLIENTE");
        System.out.println("Donde TIPO_CLIENTE puede ser: 1 (Empresa), 2 (Particular cliente), 3 (Particular no cliente)");

        int i = 0;
        while (i < 15) {
            System.out.print("Elemento " + (i + 1) + ": ");
            String entrada = scanner.nextLine();
            String[] partes = entrada.split(" ");
            boolean entradaValida = true;

            // Verificar que la entrada tenga exactamente dos partes
            if (partes.length != 2) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                entradaValida = false;
            } else {
                try {
                    // Acomodar la entrada a los tipos adecuados
                    int idCliente = Integer.parseInt(partes[0]);
                    int tipoCliente = Integer.parseInt(partes[1]);

                    // Verificar que el tipo de cliente sea válido
                    if (tipoCliente < 1 || tipoCliente > 3) {
                        System.out.println("Tipo de cliente inválido. Intente nuevamente.");
                        entradaValida = false;
                    }

                    // Si la entrada es válida, agregar el cliente a la cola con prioridad
                    if (entradaValida) {
                        colaPrioridad.AcolarPrioridad(idCliente, tipoCliente);
                        i++; // Incrementar el contador solo si la entrada es válida
                    }
                } catch (NumberFormatException e) {
                    // Capturar errores de formato en la entrada
                    System.out.println("Formato de número inválido. Intente nuevamente.");
                    entradaValida = false;
                }
            }
            // Si entradaValida sigue siendo falso, se continuará con el siguiente ciclo del while sin incrementar i
        }

        scanner.close();

        // Desencolar clientes y agregarlos a los conjuntos correspondientes
        while (!colaPrioridad.ColaVacia()) {
            int idCliente = colaPrioridad.Primero();
            int tipoCliente = colaPrioridad.Prioridad();
            colaPrioridad.Desacolar();

            // Asignar el cliente al conjunto correspondiente según su tipo
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

        // Se imprimen los conjuntos
        System.out.println("Conjunto Empresa:");
        imprimirConjunto(conjuntoEmpresa);

        System.out.println("\nConjunto Particular Cliente:");
        imprimirConjunto(conjuntoParticularCliente);

        System.out.println("\nConjunto Particular No Cliente:");
        imprimirConjunto(conjuntoParticularNoCliente);
    }

    // Método para imprimir los elementos de un conjunto
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

package Pilas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Pila miPila = new Pila();
        int opcion = 0;
        String dato;

        do {
            System.out.println("\n====== MENÚ PILA (LIFO) ======");
            System.out.println("1. Apilar (Push)");
            System.out.println("2. Desapilar (Pop)");
            System.out.println("3. Ver Cima (Peek/Top)");
            System.out.println("4. Mostrar toda la Pila");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer
            } else {
                System.out.println("Error: Ingrese un número válido.");
                entrada.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato a apilar en la cima: ");
                    dato = entrada.nextLine();
                    miPila.Apilar(dato);
                    System.out.println("-> Dato apilado correctamente.");
                    break;
                case 2:
                    if (miPila.Vacia()) {
                        System.out.println("-> No se puede desapilar: La pila está vacía.");
                    } else {
                        miPila.Desapilar();
                        System.out.println("-> Elemento en la cima extraído correctamente.");
                    }
                    break;
                case 3:
                    if (miPila.Vacia()) {
                        System.out.println("-> La pila está vacía, no hay cima.");
                    } else {
                        System.out.println("-> El elemento en la cima es: [" + miPila.Peek() + "]");
                    }
                    break;
                case 4:
                    System.out.println("\n--- Contenido de la Pila ---");
                    if (miPila.Vacia()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.print(miPila.Mostrar());
                    }
                    System.out.println("----------------------------");
                    break;
                case 5:
                    System.out.println("Saliendo del módulo de Pilas...");
                    break;
                default:
                    System.out.println("-> Opción no válida.");
            }
        } while (opcion != 5);

        entrada.close();
    }
}

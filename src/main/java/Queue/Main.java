package Queue; 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Cola miCola = new Cola();
        int opcion = 0;
        String dato;

        do {
            System.out.println("\n====== MENÚ COLA (FIFO) ======");
            System.out.println("1. Encolar (Enqueue)");
            System.out.println("2. Desencolar (Dequeue)");
            System.out.println("3. Ver Frente (Front)");
            System.out.println("4. Eliminar un dato específico");
            System.out.println("5. Mostrar toda la Cola");
            System.out.println("6. Salir");
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
                    System.out.print("Ingrese el dato a formar al final de la cola: ");
                    dato = entrada.nextLine();
                    miCola.Encolar(dato);
                    System.out.println("-> Dato encolado correctamente.");
                    break;
                case 2:
                    if (miCola.Vacia()) {
                        System.out.println("-> No se puede desencolar: La cola está vacía.");
                    } else {
                        miCola.Desencolar();
                        System.out.println("-> Primer elemento extraído correctamente.");
                    }
                    break;
                case 3:
                    if (miCola.Vacia()) {
                        System.out.println("-> La cola está vacía, no hay elementos en el frente.");
                    } else {
                        System.out.println("-> El elemento al frente de la cola es: [" + miCola.Front() + "]");
                    }
                    break;
                case 4:
                    if (miCola.Vacia()) {
                        System.out.println("-> La cola está vacía.");
                    } else {
                        System.out.print("Ingrese el dato exacto que desea eliminar: ");
                        dato = entrada.nextLine();
                        miCola.Eliminar(dato);
                        System.out.println("-> Proceso de eliminación finalizado.");
                    }
                    break;
                case 5:
                    System.out.println("\n--- Contenido de la Cola ---");
                    if (miCola.Vacia()) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println(miCola.Mostrar());
                    }
                    System.out.println("----------------------------");
                    break;
                case 6:
                    System.out.println("Saliendo del módulo de Colas...");
                    break;
                default:
                    System.out.println("-> Opción no válida.");
            }
        } while (opcion != 6);

        entrada.close();
    }
}
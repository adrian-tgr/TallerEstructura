package ListasCirculares;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Lista miLista = new Lista();
        int opcion = 0;
        String dato;

        do {
            System.out.println("\n====== MENÚ LISTAS CIRCULARES ======");
            System.out.println("1. Insertar al Inicio");
            System.out.println("2. Insertar al Final");
            System.out.println("3. Mostrar Lista");
            System.out.println("4. Eliminar al Inicio");
            System.out.println("5. Eliminar al Final");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer del scanner
            } else {
                System.out.println("Error: Ingrese un número válido.");
                entrada.nextLine(); // Limpiar la entrada incorrecta
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato (texto) a insertar al INICIO: ");
                    dato = entrada.nextLine();
                    miLista.InsertarInicio(dato);
                    System.out.println("-> Dato insertado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el dato (texto) a insertar al FINAL: ");
                    dato = entrada.nextLine();
                    miLista.InsertarFinal(dato);
                    System.out.println("-> Dato insertado correctamente.");
                    break;

                case 3:
                    System.out.println("\n--- Contenido de la Lista Circular ---");
                    if (miLista.Vacia()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        System.out.print(miLista.Mostrar());
                    }
                    System.out.println("--------------------------------------");
                    break;

                case 4:
                    if (miLista.Vacia()) {
                        System.out.println("-> No se puede eliminar: la lista ya está vacía.");
                    } else {
                        miLista.EliminarInicio();
                        System.out.println("-> Nodo inicial eliminado correctamente.");
                    }
                    break;

                case 5:
                    if (miLista.Vacia()) {
                        System.out.println("-> No se puede eliminar: la lista ya está vacía.");
                    } else {
                        miLista.EliminarFinal();
                        System.out.println("-> Nodo final eliminado correctamente.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del módulo de Listas Circulares...");
                    break;

                default:
                    System.out.println("-> Opción no válida. Por favor, intente de nuevo.");
            }

        } while (opcion != 6);

        entrada.close();
    }
}

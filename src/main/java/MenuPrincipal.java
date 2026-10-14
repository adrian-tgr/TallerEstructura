import ListaSimples.ListasSimples;
import ListaSimples.NodoSimple;
import ListasDobles.ListaDoble;
import ListasDobles.NodoDoble;
import Multilistas.Multilista;
import Pilas.Pila;
import Queue.Cola;
import java.util.Scanner;

public class MenuPrincipal {

    static final Scanner in = new Scanner(System.in);

    static String s(String p) { System.out.print(p + ": "); return in.nextLine().trim(); }

    static int n(String p) {
        while (true) {
            try { return Integer.parseInt(s(p)); }
            catch (NumberFormatException e) { System.out.println("Ingrese un numero valido."); }
        }
    }

    static void res(int pos) { System.out.println(pos == -1 ? "No encontrado" : "Encontrado en la posicion " + pos); }

    public static void main(String[] args) {
        int op;
        do {
            System.out.println("\n========== TALLER ESTRUCTURAS DE DATOS ==========");
            System.out.println("1. Lista Enlazada Simple\n2. Lista Enlazada Doble\n3. Lista Circular");
            System.out.println("4. Pila (LIFO)\n5. Cola (FIFO)\n6. Multilista\n0. Salir");
            op = n("Opcion");
            switch (op) {
                case 1: menuSimple(); break;
                case 2: menuDoble(); break;
                case 3: menuCircular(); break;
                case 4: menuPila(); break;
                case 5: menuCola(); break;
                case 6: menuMulti(); break;
                case 0: System.out.println("Adios"); break;
                default: System.out.println("Opcion invalida");
            }
        } while (op != 0);
    }

    static final String LISTA = "--- INSERCION ---\n1. Inicio  2. Final  3. Antes de ref  4. Despues de ref  5. En posicion\n"
            + "--- ELIMINACION ---\n6. Inicio  7. Final  8. Nodo ref  9. Antes de ref  10. Despues de ref  11. Posicion  12. Por dato\n"
            + "--- BUSQUEDA ---\n";
    static final String LISTA2 = "--- ORDENAMIENTO ---\n16. Seleccion  17. Burbuja  18. Insercion\n--- OTROS ---\n"
            + "19. Invertir lista\n0. Volver";

    static void menuSimple() {
        ListasSimples l = new ListasSimples();
        int op;
        do {
            System.out.println("\n===== LISTA SIMPLE =====\n" + LISTA + "13. Secuencial  14. Binaria (lista ordenada)\n"
                    + "--- RECORRIDO ---\n15. Recorrer\n" + LISTA2);
            op = n("Opcion");
            switch (op) {
                case 1: l.InsertarInicio(new NodoSimple(s("Dato"))); break;
                case 2: l.InsertarFinal(new NodoSimple(s("Dato"))); break;
                case 3: l.InsertarAntes(new NodoSimple(s("Dato nuevo")), s("Referencia")); break;
                case 4: l.InsertarDespues(new NodoSimple(s("Dato nuevo")), s("Referencia")); break;
                case 5: l.InsertarPosicion(new NodoSimple(s("Dato")), n("Posicion (desde 1)")); break;
                case 6: l.EliminarInicio(); break;
                case 7: l.EliminarFinal(); break;
                case 8: l.EliminarNodo(s("Dato del nodo")); break;
                case 9: l.EliminarAntes(s("Referencia")); break;
                case 10: l.EliminarDespues(s("Referencia")); break;
                case 11: l.EliminarPosicion(n("Posicion (desde 1)")); break;
                case 12: l.EliminarPorDato(s("Dato")); break;
                case 13: res(l.BusquedaSecuencial(s("Dato"))); break;
                case 14: res(l.BusquedaBinaria(s("Dato"))); break;
                case 15: l.Recorrer(); break;
                case 16: l.OrdenarSeleccion(); l.Recorrer(); break;
                case 17: l.OrdenarBurbuja(); l.Recorrer(); break;
                case 18: l.OrdenarInsercion(); l.Recorrer(); break;
                case 19: l.Invertir(); l.Recorrer(); break;
                case 0: break;
                default: System.out.println("Opcion invalida");
            }
        } while (op != 0);
    }

    static void menuDoble() {
        ListaDoble l = new ListaDoble();
        int op;
        do {
            System.out.println("\n===== LISTA DOBLE =====\n" + LISTA
                    + "13. Secuencial adelante  14. Secuencial atras  20. Bidireccional  15. Binaria (lista ordenada)\n"
                    + "--- RECORRIDO ---\n21. Directo  22. Inverso\n" + LISTA2);
            op = n("Opcion");
            switch (op) {
                case 1: l.InsertarInicio(new NodoDoble(s("Dato"))); break;
                case 2: l.InsertarFinal(new NodoDoble(s("Dato"))); break;
                case 3: l.InsertarAntes(new NodoDoble(s("Dato nuevo")), s("Referencia")); break;
                case 4: l.InsertarDespues(new NodoDoble(s("Dato nuevo")), s("Referencia")); break;
                case 5: l.InsertarPosicion(new NodoDoble(s("Dato")), n("Posicion (desde 1)")); break;
                case 6: l.EliminarInicio(); break;
                case 7: l.EliminarFinal(); break;
                case 8: l.EliminarNodo(s("Dato del nodo")); break;
                case 9: l.EliminarAntes(s("Referencia")); break;
                case 10: l.EliminarDespues(s("Referencia")); break;
                case 11: l.EliminarPosicion(n("Posicion (desde 1)")); break;
                case 12: l.EliminarPorDato(s("Dato")); break;
                case 13: res(l.BusquedaAdelante(s("Dato"))); break;
                case 14: res(l.BusquedaAtras(s("Dato"))); break;
                case 20: res(l.BusquedaBidireccional(s("Dato"))); break;
                case 15: res(l.BusquedaBinaria(s("Dato"))); break;
                case 21: l.RecorrerAdelante(); break;
                case 22: l.RecorrerAtras(); break;
                case 16: l.OrdenarSeleccion(); l.RecorrerAdelante(); break;
                case 17: l.OrdenarBurbuja(); l.RecorrerAdelante(); break;
                case 18: l.OrdenarInsercion(); l.RecorrerAdelante(); break;
                case 19: l.Invertir(); l.RecorrerAdelante(); break;
                case 0: break;
                default: System.out.println("Opcion invalida");
            }
        } while (op != 0);
    }

    static void menuCircular() {
        ListasCirculares.Lista l = new ListasCirculares.Lista();
        int op;
        do {
            System.out.println("\n===== LISTA CIRCULAR =====\n1. Insertar inicio  2. Insertar final  3. Insertar despues de ref\n"
                    + "4. Eliminar inicio  5. Eliminar final  6. Eliminar por dato  7. Mostrar  0. Volver");
            op = n("Opcion");
            switch (op) {
                case 1: l.InsertarInicio(s("Dato")); break;
                case 2: l.InsertarFinal(s("Dato")); break;
                case 3: String r = s("Referencia");
                    if (!l.InsertarDespues(r, s("Dato nuevo"))) System.out.println("Referencia no encontrada"); break;
                case 4: l.EliminarInicio(); break;
                case 5: l.EliminarFinal(); break;
                case 6: if (!l.EliminarDato(s("Dato"))) System.out.println("No encontrado"); break;
                case 7: System.out.println(l.Vacia() ? "Lista vacia" : l.Mostrar()); break;
                case 0: break;
                default: System.out.println("Opcion invalida");
            }
        } while (op != 0);
    }

    static void menuPila() {
        Pila p = new Pila();
        int op;
        do {
            System.out.println("\n===== PILA (LIFO) =====\n1. Push  2. Pop  3. Peek/Top  4. Mostrar  0. Volver");
            op = n("Opcion");
            switch (op) {
                case 1: p.Apilar(s("Dato")); break;
                case 2: if (p.Vacia()) System.out.println("Pila vacia"); else { System.out.println("Pop: " + p.Peek()); p.Desapilar(); } break;
                case 3: System.out.println(p.Vacia() ? "Pila vacia" : "Cima: " + p.Peek()); break;
                case 4: System.out.print(p.Vacia() ? "Pila vacia\n" : p.Mostrar()); break;
                case 0: break;
                default: System.out.println("Opcion invalida");
            }
        } while (op != 0);
    }

    static void menuCola() {
        Cola c = new Cola();
        int op;
        do {
            System.out.println("\n===== COLA (FIFO) =====\n1. Enqueue  2. Dequeue  3. Front  4. Mostrar  0. Volver");
            op = n("Opcion");
            switch (op) {
                case 1: c.Encolar(s("Dato")); break;
                case 2: if (c.Vacia()) System.out.println("Cola vacia"); else { System.out.println("Dequeue: " + c.Front()); c.Desencolar(); } break;
                case 3: System.out.println("Front: " + c.Front()); break;
                case 4: System.out.println(c.Vacia() ? "Cola vacia" : c.Mostrar()); break;
                case 0: break;
                default: System.out.println("Opcion invalida");
            }
        } while (op != 0);
    }

    static void menuMulti() {
        Multilista m = new Multilista();
        int op;
        do {
            System.out.println("\n===== MULTILISTA =====\n1. Insertar categoria  2. Insertar elemento en categoria\n"
                    + "3. Eliminar elemento  4. Eliminar categoria  5. Mostrar  0. Volver");
            op = n("Opcion");
            boolean ok = true;
            switch (op) {
                case 1: ok = m.InsertarCategoria(s("Categoria")); break;
                case 2: ok = m.InsertarElemento(s("Categoria"), s("Elemento")); break;
                case 3: ok = m.EliminarElemento(s("Categoria"), s("Elemento")); break;
                case 4: ok = m.EliminarCategoria(s("Categoria")); break;
                case 5: System.out.print(m.Mostrar()); break;
                case 0: break;
                default: System.out.println("Opcion invalida");
            }
            if (!ok) System.out.println("Operacion no realizada(Inexistente o duplicado");
        } while (op != 0);
    }
}

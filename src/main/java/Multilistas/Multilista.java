package Multilistas;

/**
 * Multilista: lista principal de categorías; cada categoría tiene su propia
 * sublista enlazada de elementos (dos niveles de enlaces).
 */
public class Multilista {

    private static class Sub {
        String dato; Sub sig;
        Sub(String d) { dato = d; }
    }

    private static class Categoria {
        String nombre; Categoria sig; Sub primero;
        Categoria(String n) { nombre = n; }
    }

    private Categoria cabeza;

    private Categoria buscar(String nombre) {
        Categoria c = cabeza;
        while (c != null && !c.nombre.equals(nombre)) c = c.sig;
        return c;
    }

    public boolean InsertarCategoria(String nombre) {
        if (buscar(nombre) != null) return false;
        Categoria nueva = new Categoria(nombre);
        if (cabeza == null) cabeza = nueva;
        else {
            Categoria c = cabeza;
            while (c.sig != null) c = c.sig;
            c.sig = nueva;
        }
        return true;
    }

    // Inserta al final de la sublista de la categoría
    public boolean InsertarElemento(String categoria, String dato) {
        Categoria c = buscar(categoria);
        if (c == null) return false;
        Sub nuevo = new Sub(dato);
        if (c.primero == null) c.primero = nuevo;
        else {
            Sub s = c.primero;
            while (s.sig != null) s = s.sig;
            s.sig = nuevo;
        }
        return true;
    }

    // Elimina un elemento de la sublista reconectando sus punteros
    public boolean EliminarElemento(String categoria, String dato) {
        Categoria c = buscar(categoria);
        if (c == null || c.primero == null) return false;
        if (c.primero.dato.equals(dato)) {
            c.primero = c.primero.sig;
            return true;
        }
        Sub s = c.primero;
        while (s.sig != null && !s.sig.dato.equals(dato)) s = s.sig;
        if (s.sig == null) return false;
        s.sig = s.sig.sig;
        return true;
    }

    // Elimina la categoría completa junto con toda su sublista
    public boolean EliminarCategoria(String nombre) {
        if (cabeza == null) return false;
        if (cabeza.nombre.equals(nombre)) {
            cabeza.primero = null;
            cabeza = cabeza.sig;
            return true;
        }
        Categoria c = cabeza;
        while (c.sig != null && !c.sig.nombre.equals(nombre)) c = c.sig;
        if (c.sig == null) return false;
        c.sig.primero = null;
        c.sig = c.sig.sig;
        return true;
    }

    public String Mostrar() {
        if (cabeza == null) return "Multilista vacia\n";
        StringBuilder sb = new StringBuilder();
        for (Categoria c = cabeza; c != null; c = c.sig) {
            sb.append("[").append(c.nombre).append("]");
            for (Sub s = c.primero; s != null; s = s.sig) sb.append(" -> ").append(s.dato);
            sb.append("\n");
        }
        return sb.toString();
    }
}

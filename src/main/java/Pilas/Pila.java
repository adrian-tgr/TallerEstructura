package Pilas;

public class Pila {

    private Nodo cima;
    private int tam;

    public Pila() {
        this.cima = null;
        this.tam = 0;
    }

    public boolean Vacia() {
        return cima == null;
    }

    public void Apilar(String dato) { //Push
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo; //Last In
        tam++;
    }

    public void Desapilar() { //Pop
        if (!Vacia()) {
            cima = cima.getSiguiente(); //Tener en cuenta que en una pila los nodos referencian hacia abajo (First Out)
            tam--;
        }
    }

    public String Mostrar() { //Todo por la cima (Peek/Top)
        String Salida = "";
        Nodo aux = cima;
        while (cima != null) {
            Salida += "[" + cima.getDato() + "]\n";
            cima = cima.getSiguiente();
        }
        cima = aux; //El auxiliar guarda la direccion de memoria de la cima completa
        return Salida;

    }

    public Nodo getCima() {
        return cima;
    }

    public void setCima(Nodo primero) {
        this.cima = primero;
    }

}

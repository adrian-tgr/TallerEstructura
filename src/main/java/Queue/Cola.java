package Queue;

public class Cola {

    private Nodo Inicio;
    private Nodo Fin;
    private int cantidad;

    public Cola() {
        this.Inicio = null;
        this.Fin = null;
        this.cantidad = 0;
    }

    public boolean Vacia() {
        return Inicio == null && Fin == null;
    }

    public void Encolar(String dato) {
        if (Vacia()) {
            Inicio = Fin = new Nodo(dato, null);
        } else {
            Nodo nuevo = new Nodo(dato, null);
            Fin.setSiguiente(nuevo);
            Fin = nuevo;
        }
        cantidad++;
    }

    public void Desencolar() {
        if (!Vacia()) {
            if (Inicio == Fin) {
                Inicio = Fin = null;
            } else {
                Inicio = Inicio.getSiguiente();
            }
            cantidad--;
        }
    }

    public void Eliminar(String dato) {
        if (!Vacia()) {
            Cola aux = new Cola();
            while (!Vacia()) {
                if (!Inicio.getDato().equals(dato)) {
                    aux.Encolar(Inicio.getDato());
                }
                Desencolar();
            }
            Inicio = aux.getInicio();
            Fin = aux.getFin();
            cantidad = aux.getCantidad();
        }
    }

    public String Front() {
        if (!Vacia()) {
            return Inicio.getDato();
        }
        return "La cola está vacía";
    }

    public String Mostrar() {
        String Salida = "";
        if (!Vacia()) {
            Nodo aux = Inicio; //Utiliza un axuliar y lo ubica desde el primer nodo
            while (aux != null) {
                Salida += "[" + aux.getDato() + "]";
                aux = aux.getSiguiente();
            }
        }
        return Salida;
    }

    public Nodo getInicio() {
        return Inicio;
    }

    public void setInicio(Nodo Inicio) {
        this.Inicio = Inicio;
    }

    public Nodo getFin() {
        return Fin;
    }

    public void setFin(Nodo Fin) {
        this.Fin = Fin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}

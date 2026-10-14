package ListasCirculares;

public class Lista {

    private Nodo Inicio;
    private Nodo Fin;
    private int cantidad;

    public Lista() {
        this.Inicio = null;
        this.Fin = null;
        this.cantidad = 0;
    }

    public boolean Vacia() { //verificar si la lista está vacia
        return Inicio == null && Fin == null;
    }

    public void InsertarInicio(String dato) {
        if (Vacia()) { //Si la lista está vacia...
            Inicio = Fin = new Nodo(dato, Inicio); //Le asignamos un nuevo Nodo
        } else { //Si la lista ya esta ocupada
            Inicio = new Nodo(dato, Inicio); //Crea un nuevo nodo, le asigna el dato y lo referencia al primer nodo, luego ese nodo nuevo lo coloca como primero
        }
        Fin.setSiguiente(Inicio);//El ultimo nodo siempre apunta al inicio
        cantidad++;
    }

    public void InsertarFinal(String dato) {
        if (Vacia()) {
            Inicio = Fin = new Nodo(dato, Inicio);
            Fin.setSiguiente(Inicio);
        } else {
            Nodo nuevo = new Nodo(dato, Inicio);
            Fin.setSiguiente(nuevo); //Conectar al ultimo nodo con el nuevo
            Fin = nuevo; //Colocar al nuevo nodo como ultimo de la lista
        }
        cantidad++;
    }

    public String Mostrar() {
        String Salida = "";
        if (!Vacia()) {
            Nodo aux = Inicio; //Utiliza un axuliar y lo ubica desde el primer nodo
            do {
                Salida += "[" + aux.getDato() + "]->"; //Va mostrando los datos y dando un salto de linea
                aux = aux.getSiguiente(); //El auxiliar salta al siguiente nodo
            } while (aux != Inicio);

            Salida += "(Vuelve a Inicio: [" + Inicio.getDato() + "])\n";// El ultimo nodo vuelva a mostrar el primero
        }
        return Salida;
    }

    public void EliminarInicio() {
        if (!Vacia()) {
            if (Inicio == Fin) {
                Inicio = Fin = null;
            } else {
                Inicio = Inicio.getSiguiente();
                Fin.setSiguiente(Inicio);
            }
            cantidad--;
        }
    }

    public void EliminarFinal() {
        if (!Vacia()) {
            if (Inicio == Fin) {
                Inicio = Fin = null;
            } else {
                Nodo aux = Inicio; //ubica el auxiliar al inicio
                while (aux.getSiguiente() != Fin) { //Mientras el siguiente nodo no sea el ultimo
                    aux = aux.getSiguiente(); //El auxiliar saltará al siguiente
                }
                Fin = aux; //Cuando el Nodo del auxiliar tenga como siguiente al ultimo, colocara el nodo del auxiliar como nuevo ultimo
                Fin.setSiguiente(Inicio); //y al nuevo ultimo lo enlaza con el primer nodo
            }
            cantidad--;
        }
    }


    public int getCantidad() {
        return cantidad;
    }

    public boolean InsertarDespues(String ref, String dato) {
        if (Vacia()) return false;
        Nodo aux = Inicio;
        do {
            if (aux.getDato().equals(ref)) {
                Nodo nuevo = new Nodo(dato, aux.getSiguiente());
                aux.setSiguiente(nuevo);
                if (aux == Fin) Fin = nuevo; // sigue apuntando a Inicio
                cantidad++;
                return true;
            }
            aux = aux.getSiguiente();
        } while (aux != Inicio);
        return false;
    }

    // Elimina la primera aparición del dato manteniendo Fin -> Inicio
    public boolean EliminarDato(String dato) {
        if (Vacia()) return false;
        Nodo ant = Fin, act = Inicio;
        do {
            if (act.getDato().equals(dato)) {
                if (Inicio == Fin) {
                    Inicio = Fin = null;
                } else {
                    ant.setSiguiente(act.getSiguiente());
                    if (act == Inicio) Inicio = act.getSiguiente();
                    if (act == Fin) Fin = ant;
                }
                cantidad--;
                return true;
            }
            ant = act;
            act = act.getSiguiente();
        } while (act != Inicio);
        return false;
    }
}

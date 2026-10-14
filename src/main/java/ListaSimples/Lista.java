package ListaSimples;

public class Lista {

    private Nodo primero;

    public Lista(Nodo primero) {
        this.primero = null;
    }

    public void InsertarInicio(Nodo nuevo /*Nodo a insertar*/) {
        /*if (this.primero == null) { //Si la variable primero esta vacia
            this.primero = nuevo; //Le asignamos un nuevo Nodo
        } else { //Si la lista ya esta ocupada
            nuevo.setSiguiente(primero); //Conectamos el nuevo Nodo con el que actualmente es el primero
            this.primero = nuevo; //y a la variable primero le referenciamos el nuevo Nodo
        }*/

        if (this.primero != null) {
            nuevo.setSiguiente(primero); //Conectamos el nuevo Nodo con el que actualmente es el primero
        }
        this.primero = nuevo; //y a la variable primero le referenciamos el nuevo Nodo
    }

    public void InsertarFinal(Nodo nuevo) {
        if (this.primero == null) { //Valida si la lista esta vacia
            this.primero = nuevo;
        } else {
            Nodo sapo = this.primero; //Utiliza un axuliar y lo ubica desde la variable primero

            while (sapo.getSiguiente() != null) { //Si el siguiente Nodo del auxiliar no esta vacio...
                sapo = sapo.getSiguiente(); //Le envio el siguiente Nodo al auxiliar
            }
            sapo.setSiguiente(nuevo); //Cuando encuetre un Nodo vacio, le referencia el nuevo Nodo
        }
    }

    public void Recorrer() {
        if (this.primero == null) { //Verifica si la lista está vacia
            System.out.println("Lista Vacia");
        } else {
            Nodo sapo = this.primero; //Utiliza un axuliar y lo ubica desde la variable primero
            while (sapo != null) { //Si el Nodo en el que esta ubicado el auxiliar no está vacio
                System.out.print("[" + sapo.getDato() + "] -> ");
                sapo = sapo.getSiguiente(); // el auxiliar recive el siguiete Nodo
            }
        }
    }

    public void InsertarDespues(Nodo nuevo, String ref) {
        if (this.primero == null) {
            System.out.println("Lista Vacia");
        } else {
            Nodo sapo = this.primero;
            while (sapo != null) { //Mientras el Nodo en que esta el auxiliar no está vacio
                if (sapo.getDato().equals(ref)) { //Busca el Nodo comparando el Nodo en el que se encuentra el auxiliar con la referencia
                    break; // //Si lo encuentra, pausa el programa
                }
                sapo = sapo.getSiguiente(); //Va pasando al siguiente Nodo mientras el while se cumpla
            }

            if (sapo == null) { //Si el auxiliar está vacio
                System.out.println("Nodo no encontrado"); //Señala que no lo encontró
            } else {
                nuevo.setSiguiente(sapo.getSiguiente()); //Al nuevo Nodo le referencia el Nodo despues del auxiliar (conecta)
                sapo.setSiguiente(nuevo); //y al auxiliar le referencia nuevo como siguiente Nodo
            }
        }
    }

    public void EliminarInicio() {
        if (this.primero == null) {
            System.out.println("Lista Vacia");
        } else {
            if (this.primero.getSiguiente() == null) {  //Si el primer Nodo no tiene referencia...
                this.primero = null; //Le quita la referencia a la variable primero y elimina la conexion con el Nodo que estaba al inicio
            } else { //Si no tiene un solo elemento
                Nodo sapo = this.primero; //guarda la referencia en el primero
                this.primero = this.primero.getSiguiente(); //A la varible primero la referencia con el que le sigue
                sapo.setSiguiente(null); //y elimina el Nodo despues del auxiliar
                sapo = null; //elimina el auxiliar
            }
        }
    }

    public void EliiminarDespues(String ref) {
        if (this.primero == null) {
            System.out.println("Lista Vacia");
        } else {
            Nodo sapo = this.primero;
            while (sapo != null) { //Mientras el Nodo en que esta el auxiliar no está vacio
                if (sapo.getDato().equals(ref)) { //Busca el Nodo comparando el Nodo en el que se encuentra el auxiliar con la referencia
                    break; // //Si lo encuentra, pausa el programa
                }
                sapo = sapo.getSiguiente(); //Va pasando al siguiente Nodo mientras el while se cumpla
            }

            if (sapo == null) { //Si el auxiliar está vacio
                System.out.println("Nodo no encontrado"); //Señala que no lo encontró
            } else {
                Nodo sapa = sapo.getSiguiente();
                sapo.setSiguiente(sapa.getSiguiente());
                sapa.setSiguiente(null);
                sapa.setDato(null);
            }
        }
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

}

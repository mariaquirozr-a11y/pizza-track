/**
 * Clase NodoPizza
 * ---------------
 * Nodo de una lista ligada simple. Cada nodo guarda:
 *  - un dato de tipo Pizza
 *  - una referencia (puntero) al siguiente nodo de la pila
 *
 * En una pila implementada con lista ligada, el "tope" de la pila
 * siempre es la cabeza (head) de la lista: por eso insertar y
 * retirar en la cabeza es una operación O(1), ideal para push/pop.
 */
public class NodoPizza {

    private Pizza dato;
    private NodoPizza siguiente; // puntero al siguiente nodo (hacia el fondo de la pila)

    public NodoPizza(Pizza dato) {
        this.dato = dato;
        this.siguiente = null; // al crearse, todavía no apunta a nada
    }

    public Pizza getDato() {
        return dato;
    }

    public NodoPizza getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPizza siguiente) {
        this.siguiente = siguiente;
    }
}

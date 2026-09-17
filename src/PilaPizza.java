/**
 * Clase PilaPizza
 * ---------------
 * Implementación MANUAL de una pila (estructura LIFO: Last In, First Out)
 * usando una lista ligada de nodos NodoPizza.
 *
 * Restricción de la actividad: no se usa java.util.Stack; la lógica de
 * apilar/desapilar se construye moviendo el puntero "tope" a mano.
 */
public class PilaPizza {

    private NodoPizza tope; // puntero a la cabeza de la lista = tope de la pila
    private int tamano;

    public PilaPizza() {
        this.tope = null;
        this.tamano = 0;
    }

    /**
     * push(): inserta una pizza en el TOPE de la pila.
     * Paso a paso con punteros:
     *   1. Se crea un nuevo nodo con la pizza.
     *   2. El "siguiente" del nuevo nodo apunta a lo que hoy es el tope.
     *   3. El tope de la pila pasa a ser el nuevo nodo.
     */
    public void push(Pizza pizza) {
        NodoPizza nuevo = new NodoPizza(pizza);
        nuevo.setSiguiente(tope); // el nuevo nodo "queda encima" del viejo tope
        tope = nuevo;             // el puntero tope ahora es el nuevo nodo
        tamano++;
    }

    /**
     * pop(): retira el nodo del tope y devuelve la pizza que contenía.
     * Paso a paso con punteros:
     *   1. Se guarda el nodo actual del tope en una variable temporal.
     *   2. El tope de la pila avanza al "siguiente" de ese nodo.
     *   3. Se devuelve el dato (Pizza) que traía el nodo retirado.
     * Si la pila está vacía, no hay nada que retirar y se devuelve null.
     */
    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }
        NodoPizza nodoRetirado = tope;
        tope = tope.getSiguiente(); // el segundo nodo pasa a ser el nuevo tope
        nodoRetirado.setSiguiente(null); // se desconecta el nodo retirado (buena práctica)
        tamano--;
        return nodoRetirado.getDato();
    }

    /**
     * peek(): permite ver la pizza que está en el tope SIN retirarla,
     * es decir, sin mover el puntero "tope".
     */
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.getDato();
    }

    /**
     * isEmpty(): la pila está vacía cuando el puntero tope no apunta
     * a ningún nodo (es null).
     */
    public boolean isEmpty() {
        return tope == null;
    }

    public int getTamano() {
        return tamano;
    }
}

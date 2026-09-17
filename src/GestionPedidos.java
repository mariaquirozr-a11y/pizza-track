/**
 * Clase GestionPedidos
 * --------------------
 * Coordina las DOS pilas manuales que dan vida al sistema Undo/Redo:
 *
 *   - pilaPrincipal (Undo): guarda los pedidos activos. El pedido más
 *     reciente siempre queda en el tope.
 *   - pilaSecundaria (Redo): guarda temporalmente los pedidos que se
 *     "deshicieron", listos para recuperarse.
 *
 * La regla de oro del patrón Undo/Redo con dos pilas es:
 *   - Registrar  -> push en principal, y se limpia la de redo
 *                   (ya no tiene sentido "rehacer" algo viejo
 *                    después de un nuevo registro).
 *   - Deshacer   -> pop de principal, push en secundaria.
 *   - Rehacer    -> pop de secundaria, push en principal.
 */
public class GestionPedidos {

    private PilaPizza pilaPrincipal;   // Undo
    private PilaPizza pilaSecundaria;  // Redo

    public GestionPedidos() {
        this.pilaPrincipal = new PilaPizza();
        this.pilaSecundaria = new PilaPizza();
    }

    /**
     * Registrar un nuevo pedido: se apila en la pila principal.
     * Al registrar un pedido nuevo, la pila de "rehacer" se limpia,
     * porque el historial de deshechos deja de ser válido.
     */
    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);
        limpiarPilaSecundaria();
    }

    /**
     * Deshacer: saca el último pedido de la pila principal y lo
     * mueve a la pila secundaria, para poder recuperarlo con Redo.
     */
    public Pizza deshacer() {
        if (pilaPrincipal.isEmpty()) {
            return null;
        }
        Pizza pizzaDeshecha = pilaPrincipal.pop();
        pilaSecundaria.push(pizzaDeshecha);
        return pizzaDeshecha;
    }

    /**
     * Rehacer: saca el último pedido deshecho de la pila secundaria
     * y lo devuelve a la pila principal de pedidos activos.
     */
    public Pizza rehacer() {
        if (pilaSecundaria.isEmpty()) {
            return null;
        }
        Pizza pizzaRecuperada = pilaSecundaria.pop();
        pilaPrincipal.push(pizzaRecuperada);
        return pizzaRecuperada;
    }

    /**
     * Muestra (sin retirar) el pedido que está listo para producción,
     * es decir, el tope de la pila principal.
     */
    public Pizza mostrarPedidoActual() {
        return pilaPrincipal.peek();
    }

    public boolean hayPedidosActivos() {
        return !pilaPrincipal.isEmpty();
    }

    public boolean hayPedidosParaRehacer() {
        return !pilaSecundaria.isEmpty();
    }

    /**
     * Vacía la pila de "rehacer" nodo por nodo (pop hasta que quede vacía),
     * usando únicamente los métodos manuales de la pila.
     */
    private void limpiarPilaSecundaria() {
        while (!pilaSecundaria.isEmpty()) {
            pilaSecundaria.pop();
        }
    }
}

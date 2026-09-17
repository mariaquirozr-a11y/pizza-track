/**
 * Clase Pizza
 * -----------
 * Representa el objeto de dominio que se moverá dentro de las pilas
 * (principal y secundaria) del sistema Pizza-Track.
 *
 * Requisito de la actividad: los ingredientes se almacenan en un
 * arreglo de tamaño FIJO de 3 posiciones (no una lista dinámica).
 */
public class Pizza {

    private String nombre;
    private String[] ingredientes; // Arreglo fijo de 3 ingredientes

    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;

        // Se copia el arreglo a un tamaño fijo de 3, sin importar
        // cuántos elementos venían originalmente, para cumplir la
        // restricción del enunciado.
        this.ingredientes = new String[3];
        for (int i = 0; i < 3 && i < ingredientes.length; i++) {
            this.ingredientes[i] = ingredientes[i];
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza: ").append(nombre).append(" | Ingredientes: [");
        for (int i = 0; i < ingredientes.length; i++) {
            sb.append(ingredientes[i]);
            if (i < ingredientes.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

# Pizza-Track — Simulador de Gestión de Pedidos (Undo/Redo)

## Objetivo

Aplicación de consola en Java que simula el sistema de gestión de pedidos de una
pizzería, implementando el concepto de **pila (stack)** de forma manual —usando
listas ligadas propias— para soportar las operaciones de **Registrar**,
**Deshacer (Undo)** y **Rehacer (Redo)**.

## Arquitectura

* **`Pizza.java`**: modelo de datos. Guarda el nombre y un arreglo fijo de 3 ingredientes.
* **`NodoPizza.java`**: nodo de la lista ligada (dato + puntero al siguiente).
* **`PilaPizza.java`**: pila manual construida sobre `NodoPizza`, con `push()`,
`pop()`, `peek()` e `isEmpty()`. **No usa `java.util.Stack`.**
* **`GestionPedidos.java`**: coordina dos instancias de `PilaPizza`:

  * **Pila Principal (Undo)**: pedidos activos.
  * **Pila Secundaria (Redo)**: pedidos deshechos, listos para recuperar.
* **`Main.java`**: menú interactivo en consola.

## Cómo funciona el Undo/Redo

|Acción|Pila Principal|Pila Secundaria|
|-|-|-|
|Registrar|`push(pizza)`|se limpia (ya no aplica)|
|Deshacer|`pop()` → sale la pizza|`push(pizza)` → entra|
|Rehacer|`push(pizza)` → entra|`pop()` → sale la pizza|

## Instrucciones de ejecución

Requiere JDK instalado (probado con Java 21 / Eclipse Temurin).

```bash
cd src
javac \*.java -d ../bin
cd ../bin
java Main
```

Menú disponible:

```
1. Registrar Pizza
2. Deshacer (Undo)
3. Rehacer (Redo)
4. Mostrar Pedido Actual
0. Salir
```

## Capturas de pantalla

https://github.com/mariaquirozr-a11y/pizza-track/tree/main/Nueva%20carpeta

## Video de sustentación

https://youtu.be/cyE1mkvRaxc

## Autor

*Maria Isabel Quiroz*


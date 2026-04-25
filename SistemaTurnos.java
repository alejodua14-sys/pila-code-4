public class SistemaTurnos {

    private static class Nodo {
        String cliente;
        Nodo siguiente;
        Nodo(String c) { this.cliente = c; }
    }

    private Nodo frente;
    private Nodo fin;
    private int tamanio;

    // enqueue
    public void enqueue(String cliente) {
        Nodo nuevo = new Nodo(cliente);

        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }

        tamanio++;
        System.out.println(cliente + " tomó turno. Posición: " + tamanio);
    }

    // dequeue
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("No hay clientes en espera.");
            return null;
        }

        String cliente = frente.cliente;
        frente = frente.siguiente;

        if (frente == null) fin = null;

        tamanio--;
        System.out.println("Atendiendo a: " + cliente);
        return cliente;
    }

    public String peek() { return isEmpty() ? null : frente.cliente; }
    public boolean isEmpty() { return frente == null; }
    public int tamanio() { return tamanio; }

    public void mostrarFila() {
        Nodo actual = frente;
        System.out.print("Fila -> ");

        while (actual != null) {
            System.out.print("[" + actual.cliente + "] ");
            actual = actual.siguiente;
        }

        System.out.println();
    }

    // 🔹 E4.1 posición
    public int posicion(String cliente) {
        Nodo actual = frente;
        int pos = 1;

        while (actual != null) {
            if (actual.cliente.equals(cliente))
                return pos;
            actual = actual.siguiente;
            pos++;
        }

        return -1;
    }

    // 🔹 E4.2 saltar turno
    public void saltarTurno() {
        if (tamanio <= 1) return;

        String primero = dequeue();
        enqueue(primero);
        System.out.println("⚠️ " + primero + " fue enviado al final");
    }
}
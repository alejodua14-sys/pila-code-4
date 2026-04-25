public class Main {
    public static void main(String[] args) {

        SistemaTurnos cola = new SistemaTurnos();

        // 🔹 Llegan 8 clientes
        cola.enqueue("Juan");
        cola.enqueue("Ana");
        cola.enqueue("Luis");
        cola.enqueue("Sofía");
        cola.enqueue("Carlos");
        cola.enqueue("Laura");
        cola.enqueue("Pedro");
        cola.enqueue("Marta");

        System.out.println("\nEstado inicial:");
        cola.mostrarFila();

        // 🔹 Atender de 2 en 2
        System.out.println("\n--- RONDA 1 ---");
        cola.dequeue();
        cola.dequeue();
        cola.mostrarFila();

        System.out.println("\n--- RONDA 2 ---");
        cola.dequeue();
        cola.dequeue();
        cola.mostrarFila();

        System.out.println("\n--- RONDA 3 ---");
        cola.dequeue();
        cola.dequeue();
        cola.mostrarFila();

        // 🔹 Posición
        System.out.println("\nPosición de Marta: " + cola.posicion("Marta"));

        // 🔹 Saltar turno
        System.out.println("\nAplicando castigo...");
        cola.saltarTurno();
        cola.mostrarFila();
    }
}
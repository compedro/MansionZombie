package mansionzombie;

import java.awt.BorderLayout;
import java.util.Scanner;

public class InicioJuego {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Juego juego = new Juego(1);
        int dificultad = -1;
        juego.setDificultad(dificultad);

        do {
            System.out.println(" Elije si quieres jugar en modo facil o dificil");
            System.out.println("1.- Fácil\n"
                    + "2.- Dificil");
            dificultad = scanner.nextInt();

            switch (dificultad) {
                case 1 -> {
                    System.out.println("Has elegido el modo facil...\n");
                    juego.setDificultad(1);
                }

                case 2 -> {
                    System.out.println("Has elegido el modo dificil...\n");
                    juego.setDificultad(2);
                }

                default ->
                    System.out.println("Opción no valida elige otra");
            }

        } while (dificultad != 1 && dificultad != 2);

        int opcion = -1;
        do {
            System.out.println("\n == Trata de huir de la Mansión Zombie y salvando tu vida ... ==\n"
                    + "... estas en la habitación: "+ juego.getHabitacionActual().getIdHabitacion()+ " y un zombie se te acerca...\n"
                    + "Estas son tus opciones:");
            System.out.println("1. Combatir\n"
                    + "2. Buscar\n"
                    + "3. Curar\n"
                    + "4. Avanzar\n"
                    + "0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Has elegido combatir...");
                    juego.combatir();
                }
                case 2 -> {
                    System.out.println("Comienzas a buscar por la habitación...");
                    juego.buscar();
                }
                case 3 -> {
                    System.out.println("Aprovechas la tranquilidad para curar tus heridas...");
                    juego.usarBotiquin();
                }
                case 4 -> {
                    System.out.println("Avanzas a la siguiente habitación...suerte");
                    juego.avanzar();
                }
                case 0 ->
                    System.out.println("El juego termina por hoy. Hata la próxima!");

                default ->
                    System.out.println("Opción no valida elige otra");

            }
        } while ((opcion != 0) && (juego.getSupervivienteActual().getPuntosVida() > 0) && (juego.getHabitacionActual().getIdHabitacion() <= juego.getHabitacionesMax()));
    }
}

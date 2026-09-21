package mansionzombie;

public class Juego {

    private int dificultad;
    private int habitacionesMax;
    private Superviviente supervivienteActual = new Superviviente();
    private Habitacion habitacionActual = new Habitacion();

    public Juego(int dificultad) {
        this.dificultad = dificultad;
        if (dificultad == 1) {
         this.habitacionesMax = 5   ;
        } else {this.habitacionesMax = 10;
        }
    }
    
}

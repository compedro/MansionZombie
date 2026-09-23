package mansionzombie;

public class Juego {

    private int dificultad;
    private int habitacionesMax;
    private Superviviente supervivienteActual = new Superviviente();
//    private Habitacion habitacion = habitacion.getIdHabitacion();

    public Juego(int dificultad) {
        this.dificultad = dificultad;
        if (dificultad == 1) {
         this.habitacionesMax = 5   ;
        } else {this.habitacionesMax = 10;
        }
    }

    public void combatir(){
       


    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getHabitacionesMax() {
        return habitacionesMax;
    }

    public void setHabitacionesMax(int habitacionesMax) {
        this.habitacionesMax = habitacionesMax;
    }

    public Superviviente getSupervivienteActual() {
        return supervivienteActual;
    }

    public void setSupervivienteActual(Superviviente supervivienteActual) {
        this.supervivienteActual = supervivienteActual;
    }

//    public Habitacion getHabitacionActual() {
//        return habitacionActual;
//    }
//
//    public void setHabitacionActual(Habitacion habitacionActual) {
//        this.habitacionActual = habitacionActual;
//    }
}

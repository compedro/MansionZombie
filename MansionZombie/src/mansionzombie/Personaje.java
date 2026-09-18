package mansionzombie;

public abstract class Personaje {

    private int habitacionActual;
    private int puntosVida;
    private int puntosAtaque;

    public Personaje(int habitacionActual, int puntosVida, int puntosAtaque) {
        this.habitacionActual = habitacionActual;
        this.puntosVida = puntosVida;
        this.puntosAtaque = puntosAtaque;
    }

    public int getHabitacionActual() {
        return habitacionActual;
    }

    public void setHabitacionActual(int habitacionActual) {
        this.habitacionActual = habitacionActual;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public abstract void  combatir();
    

}

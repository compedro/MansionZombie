package mansionzombie;

import mansionzombie.Personaje;

public class Zombie extends Personaje {

//    public Zombie(int habitacionActual, int puntosVida, int puntosAtaque) {
  // No hace falta pasarle puntosVida ni puntosAtaque porque lo va a generar el algoritmo.
//    super(habitacionActual,puntosVida, puntosAtaque);
 // En el constructor se meten directamente el algoritmo en los parametros correspondientes
        public Zombie(int habitacionActual) { 
        super(habitacionActual,(int)(Math.random()*2)+2+(habitacionActual - 1),(int)(Math.random()*2)+2+(habitacionActual - 1));   
    } 
    
    @Override
    public void combatir() {

    }
}

package mansionzombie;

public class Juego {

    private int dificultad;
    private int habitacionesMax;
    private Superviviente supervivienteActual = new Superviviente();

    private Habitacion habitacionActual = new Habitacion(1);

    public Juego(int dificultad) {
        this.dificultad = dificultad;
        if (dificultad == 1) {
            this.habitacionesMax = 5;
        } else {
            this.habitacionesMax = 10;
        }
    }

    public void combatir() {

        Zombie zombie = new Zombie(habitacionActual.getIdHabitacion());

        do {
            System.out.println("Datos del superviviente antes del combate");
            System.out.println("--------------------------");
            System.out.println("puntosVida: " + supervivienteActual.getPuntosVida());
            System.out.println("puntosAtaque: " + supervivienteActual.getPuntosAtaque());
            System.out.println("botiquin: " + supervivienteActual.getBotiquin());
            System.out.println("armas: " + supervivienteActual.getArmas());
            System.out.println("protecciones: " + supervivienteActual.getProtecciones());
            System.out.println("-----------------------");
            System.out.println("Combatiendo ...");
            //comienza el combate
            //aparece zombie
            System.out.println("... Zombie con: " + zombie.getPuntosVida() + " puntos de vida.");
            //ataca el superviviente
            int tiradaSuperviviente = supervivienteActual.combatir();
            System.out.println("... ataca Superviviente con : " + tiradaSuperviviente + " puntos");
            //calculo del asalto
            int ResultadoAtaqueSuperviviente = zombie.getPuntosVida() - tiradaSuperviviente;
            if (ResultadoAtaqueSuperviviente <= 0) {
                zombie.setPuntosVida(0);
                System.out.println("Zombie derrotado");
                habitacionActual.setZombiesActivos(habitacionActual.getZombiesActivos() - 1);
            } else {
                zombie.setPuntosVida(zombie.getPuntosVida() - tiradaSuperviviente);
                System.out.println("El Zombie no ha sido derrotado...");
                System.out.println("... Zombie con: " + zombie.getPuntosVida() + " puntos de vida.");

                //ahora ataca el zombie
                int tiradaZombie = zombie.combatir();
                System.out.println("... ataca Zombie con: " + tiradaZombie + " puntos");
                // defensa superviviente
                // uso de protecciones
                int ataqueZombieResultante = tiradaZombie - supervivienteActual.getProtecciones();
                if (ataqueZombieResultante <= 0) {
                    System.out.println("Tus protecciones han parado el ataque totalmente");
                } else {
                    System.out.println("Tus protecciones no han podido parar el ataque totalmente");
                    System.out.println("Has muerto y eres fagocitado por los zombies...\n"
                            + "GAME OVER");
                    //resultado del ataque en el superviviente
                    supervivienteActual.setPuntosVida(supervivienteActual.getPuntosVida() - ataqueZombieResultante);
                }
            }

        } while ((zombie.getPuntosVida() > 0) && (supervivienteActual.getPuntosVida() > 0));

    }

    public void buscar() {

        int zombiesActivos = habitacionActual.getZombiesActivos();
        int intentosBusqueda = habitacionActual.getIntentosBusqueda();
        if (zombiesActivos == 0 && intentosBusqueda > 0) {
            System.out.println("Iniciando una busqueda");
            habitacionActual.setIntentosBusqueda(habitacionActual.getIntentosBusqueda() - 1);
            System.out.println("Tirando el dado ...");
            int tiradaBusqueda = (int) (Math.random() * 100 + 1);
            System.out.println("... ha salido: " + tiradaBusqueda);
            if (tiradaBusqueda <= 75) {
                System.out.println("Has hecho ruido !!");
                System.out.println("Inciando una segunda tirada para ver las consecuencias...");
                int tiradaRuido = (int) (Math.random() * 100 + 1);
                System.out.println("... ha salido: " + tiradaRuido);
                if (tiradaRuido <= 40) {
                    System.out.println("No aparecieron zombies");
                } else {
                    if (tiradaRuido <= 80) {
                        System.out.println("Apareció un zombie !");
                        habitacionActual.setZombiesActivos(habitacionActual.getZombiesActivos() + 1);
                    } else {
                        System.out.println("Aparecieron dos zombies !!");
                        habitacionActual.setZombiesActivos(habitacionActual.getZombiesActivos() + 2);
                    }
                }
            } else {
                if (tiradaBusqueda <= 90) {
                    System.out.println("Has encontrado un botiquin");
                    if (supervivienteActual.getBotiquin() == 0) {
                        supervivienteActual.setBotiquin(supervivienteActual.getBotiquin() + 1);
                    } else {
                        System.out.println("... pero ya tenias un botiquín y no puedes llevar mas de uno\n"
                                + "así que lo tienes que abadonar.");
                    }

                } else {
                    if (tiradaBusqueda <= 95) {
                        System.out.println("Has encontrado una protección!");
                        supervivienteActual.setProtecciones(supervivienteActual.getProtecciones() + 1);
                    } else {
                        System.out.println("Has encontrado un arma!");
                        supervivienteActual.setArmas(supervivienteActual.getArmas() + 1);
                    }
                }
            }
        } else {
            System.out.println(" No puedes iniciar busquedas\n "
                    + "todavía hay zombies activos o no te quedan intentos");
        }

    }

    public void usarBotiquin() {
        if (habitacionActual.getZombiesActivos() == 0 && supervivienteActual.getBotiquin() > 0) {
            System.out.println(" con el botiquin recuperas cuatro puntos de vida con un máximo de 20 puntos");
            supervivienteActual.setPuntosVida(supervivienteActual.getPuntosVida() + 4);
            supervivienteActual.setBotiquin(0);
            if (supervivienteActual.getPuntosVida() > 20) {
                supervivienteActual.setPuntosVida(20); // se limita al máximo los puntos de vida a 20 puntos
            }
        } else {
            if (habitacionActual.getZombiesActivos() > 0) {
                System.out.println("No puedes utilizar el botiquín hasta que no termines con los zombies de la habitación");
            } else {
                System.out.println("No te quedan botiquines para poder utilizar");
            }
        }
    }

    public void avanzar() {
        if (habitacionActual.getZombiesActivos() == 0) {
            int idHabitacionSuperada = habitacionActual.getIdHabitacion();
            System.out.println("Has superadola habitacion: "+ idHabitacionSuperada +"\n");
            Habitacion habitacionSiguiente = new Habitacion(idHabitacionSuperada + 1);
            this.habitacionActual = habitacionSiguiente;

            if (habitacionActual.getIdHabitacion() > habitacionesMax) {
                System.out.println("Has conseguido salir vivo de la Mansion Zombie!\n"
                        + " Enhorabuena !");
            } else {
                System.out.println("Has avanzado a la habitacion: " + habitacionActual.getIdHabitacion());
            }
        } else {System.out.println(" Aun no puedes avanzar porque quedan Zombies vivos en la habitación");}
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

    public Habitacion getHabitacionActual() {
        return habitacionActual;
    }

    public void setHabitacionActual(Habitacion habitacionActual) {
        this.habitacionActual = habitacionActual;
    }
}

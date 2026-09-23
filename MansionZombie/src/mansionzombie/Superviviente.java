package mansionzombie;

public class Superviviente extends Personaje {
    private int botiquin;
    private int armas;
    private int protecciones;

    public Superviviente() {
        super(20, 4);
        this.botiquin = 0;
        this.armas = 0;
        this.protecciones = 0;
    }

    @Override
    public int combatir() {
        int puntosAtaque = (int)((Math.random()*getPuntosAtaque())+1+armas);
       return puntosAtaque;
    }

    public int getBotiquin() {
        return botiquin;
    }

    public void setBotiquin(int botiquin) {
        this.botiquin = botiquin;
    }

    public int getArmas() {
        return armas;
    }

    public void setArmas(int armas) {
        this.armas = armas;
    }

    public int getProtecciones() {
        return protecciones;
    }

    public void setProtecciones(int protecciones) {
        this.protecciones = protecciones;
    }
    
    
}

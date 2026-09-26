package mansionzombie;

public class Habitacion {

private int idHabitacion;    
private int intentosBusqueda;
private int zombiesActivos;


    public Habitacion() {
        this.idHabitacion = idHabitacion;
        this.intentosBusqueda = 3;
        this.zombiesActivos = 1;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    
    public int getIntentosBusqueda() {
        return intentosBusqueda;
    }

    public void setIntentosBusqueda(int intentosBusqueda) {
        this.intentosBusqueda = intentosBusqueda;
    }

    public int getZombiesActivos() {
        return zombiesActivos;
    }

    public void setZombiesActivos(int zombiesActivos) {
        this.zombiesActivos = zombiesActivos;
    }
    


}

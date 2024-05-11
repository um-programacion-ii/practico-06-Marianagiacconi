package clinicas;

public class Paciente {
    private String nombre;
    private ObraSocial obraSocial;
    private boolean tieneObraSocial;

    public Paciente(String nombre, ObraSocial obraSocial, boolean tieneObraSocial) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
        this.tieneObraSocial = tieneObraSocial;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public boolean isTieneObraSocial() {
        return tieneObraSocial;
    }

    public void setTieneObraSocial(boolean tieneObraSocial) {
        this.tieneObraSocial = tieneObraSocial;
    }

    public void recibirReceta(Receta receta) {
        // Lógica para que el paciente reciba la receta
        System.out.println("El paciente " + nombre + " ha recibido la receta: " + receta);
    }
}

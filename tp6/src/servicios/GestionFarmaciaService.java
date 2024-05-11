package servicios;

import clinicas.Farmacia;
import clinicas.Paciente;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instance;
    private Farmacia farmacia;

    private GestionFarmaciaService() {
        farmacia = new Farmacia();
    }

    public static synchronized GestionFarmaciaService getInstance() {
        if (instance == null) {
            instance = new GestionFarmaciaService();
        }
        return instance;
    }

    public void agregarMedicamento(String nombre, int cantidad) {
        farmacia.agregarStock(nombre, cantidad);
        System.out.println("Medicamento agregado a la farmacia: " + nombre);
    }

    public void venderMedicamento(Paciente paciente, String nombreMedicamento, int cantidad) {
        if (farmacia.hayStock(nombreMedicamento, cantidad)) {
            farmacia.vender(nombreMedicamento, cantidad);
            System.out.println("Venta realizada a " + paciente.getNombre() + ": " + cantidad + " unidades de " + nombreMedicamento);
        } else {
            System.out.println("No hay suficiente stock de " + nombreMedicamento + " en la farmacia");
        }
    }
}

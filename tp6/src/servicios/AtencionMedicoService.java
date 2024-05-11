// AtencionMedicoService.java
package servicios;

import clinicas.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AtencionMedicoService {
    private static AtencionMedicoService instance;
    private List<Medico> listarMedicos; // Lista de médicos disponibles

    private AtencionMedicoService() {
        listarMedicos = new ArrayList<>();
    }

    public static synchronized AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }

    public void agregarMedico(Medico medico) {
        listarMedicos.add(medico);
    }

    public List<Medico> getListarMedicos() {
        return listarMedicos;
    }

    public void emitirReceta(Paciente paciente, Medico medico) {
        // Supongamos que la emisión de la receta puede ser aleatoria
        boolean emitirReceta = new Random().nextBoolean();
        if (emitirReceta) {
            Receta receta = new Receta();
            // Agregar medicamentos a la receta
            receta.agregarMedicamento("Medicamento 1");
            receta.agregarMedicamento("Medicamento 2");

            paciente.recibirReceta(receta); // Método ficticio para que el paciente reciba la receta
            System.out.println("Receta emitida para el paciente " + paciente.getNombre() + " por el médico " + medico.getNombre());
        } else {
            System.out.println("El médico " + medico.getNombre() + " decidió no emitir una receta para el paciente " + paciente.getNombre());
        }
    }

    public List<Medico> listarMedicos() {
        return listarMedicos;
    }
}

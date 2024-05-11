// GestionTurnoService.java
package servicios;

import clinicas.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionTurnoService {
    private static GestionTurnoService instance;
    private List<Turno> turnos;

    private GestionTurnoService() {
        turnos = new ArrayList<>();
    }

    public static synchronized GestionTurnoService getInstance() {
        if (instance == null) {
            instance = new GestionTurnoService();
        }
        return instance;
    }

    public void solicitarTurno(Paciente paciente, Medico medico) {
        Turno turno = new Turno(paciente, medico);
        turnos.add(turno);
        System.out.println("Turno solicitado para el paciente " + paciente.getNombre() + " con el médico " + medico.getNombre());
    }

    public List<Medico> listarMedicosPorEspecialidadYObraSocial(Especialidad especialidad, ObraSocial obraSocial) {
        List<Medico> medicosDisponibles = AtencionMedicoService.getInstance().getListarMedicos();

        return medicosDisponibles.stream()
                .filter(medico -> medico.getEspecialidad().equals(especialidad) && medico.getObraSocial().equals(obraSocial))
                .collect(Collectors.toList());
    }
}

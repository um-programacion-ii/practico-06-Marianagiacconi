// Main.java
import clinicas.*;
import servicios.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una obra social para OSDE
        ObraSocial obraSocialOSDE = new ObraSocial("OSDE");

        // Crear una obra social para Swiss Medical
        ObraSocial obraSocialSwissMedical = new ObraSocial("Swiss Medical");

        // Crear una lista de especialidades
        Especialidad traumatologia = new Especialidad("Traumatología");
        Especialidad pediatria = new Especialidad("Pediatría");

        // Crear una lista de médicos
        Medico medicoTraumatologoOSDE = new Medico("Dr. Pérez", traumatologia, obraSocialOSDE,true);
        Medico medicoPediatriaSwissMedical = new Medico("Dra. Gómez", pediatria, obraSocialSwissMedical,true);

        // Agregar médicos a la lista en AtencionMedicoService
        AtencionMedicoService.getInstance().agregarMedico(medicoTraumatologoOSDE);
        AtencionMedicoService.getInstance().agregarMedico(medicoPediatriaSwissMedical);

        // Crear un paciente con OSDE
        Paciente pacienteOSDE = new Paciente("Juan", obraSocialOSDE, true);

        // Crear un paciente con Swiss Medical
        Paciente pacienteSwissMedical = new Paciente("Ana", obraSocialSwissMedical, true);

        // Solicitar un turno para el paciente con el médico
        GestionTurnoService.getInstance().solicitarTurno(pacienteOSDE, medicoTraumatologoOSDE);
        GestionTurnoService.getInstance().solicitarTurno(pacienteSwissMedical, medicoPediatriaSwissMedical);

        // Listar médicos por especialidad y obra social
        System.out.println("Médicos disponibles para la especialidad de Traumatología y la obra social OSDE:");
        List<Medico> medicosDisponiblesOSDE = GestionTurnoService.getInstance().listarMedicosPorEspecialidadYObraSocial(traumatologia, obraSocialOSDE);
        for (Medico m : medicosDisponiblesOSDE) {
            System.out.println(m.getNombre());
        }

        System.out.println("Médicos disponibles para la especialidad de Pediatría y la obra social Swiss Medical:");
        List<Medico> medicosDisponiblesSwissMedical = GestionTurnoService.getInstance().listarMedicosPorEspecialidadYObraSocial(pediatria, obraSocialSwissMedical);
        for (Medico m : medicosDisponiblesSwissMedical) {
            System.out.println(m.getNombre());
        }

        // Emitir una receta para el paciente por el médico
        // AtencionMedicoService.getInstance().emitirReceta(pacienteOSDE, medicoTraumatologoOSDE);
        // AtencionMedicoService.getInstance().emitirReceta(pacienteSwissMedical, medicoPediatriaSwissMedical);

        // Agregar medicamentos al stock de la farmacia
        GestionFarmaciaService.getInstance().agregarMedicamento("Paracetamol", 100);
        GestionFarmaciaService.getInstance().agregarMedicamento("Ibuprofeno", 150);

        // Vender medicamentos al paciente desde la farmacia
        GestionFarmaciaService.getInstance().venderMedicamento(pacienteOSDE, "Paracetamol", 2);
        GestionFarmaciaService.getInstance().venderMedicamento(pacienteSwissMedical, "Ibuprofeno", 3);
    }
}

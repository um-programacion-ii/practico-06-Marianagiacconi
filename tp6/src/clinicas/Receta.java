package clinicas;

import java.util.ArrayList;
import java.util.List;

public class Receta {
    private List<String> medicamentos;

    public Receta() {
        this.medicamentos = new ArrayList<>();
    }

    // Getter y setter para medicamentos
    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    // Método para agregar un medicamento a la receta
    public void agregarMedicamento(String medicamento) {
        medicamentos.add(medicamento);
    }
}

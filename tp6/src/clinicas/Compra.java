package clinicas;

import java.util.List;

public class Compra {
    private List<String> medicamentos;

    public Compra(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    // Getter y setter
    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }
}

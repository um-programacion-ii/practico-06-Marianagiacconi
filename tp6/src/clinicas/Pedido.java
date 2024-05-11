package clinicas;

import java.util.List;

public class Pedido {
    private List<String> medicamentos;

    public Pedido(List<String> medicamentos) {
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

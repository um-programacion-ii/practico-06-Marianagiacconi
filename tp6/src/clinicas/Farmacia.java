package clinicas;

import java.util.HashMap;
import java.util.Map;

public class Farmacia {
    private Map<String, Integer> stock;

    public Farmacia() {
        this.stock = new HashMap<>();
    }

    // Métodos para gestionar el stock
    public void agregarStock(String medicamento, int cantidad) {
        int stockActual = stock.getOrDefault(medicamento, 0);
        stock.put(medicamento, stockActual + cantidad);
    }

    public boolean hayStock(String medicamento, int cantidad) {
        return stock.getOrDefault(medicamento, 0) >= cantidad;
    }

    public void vender(String medicamento, int cantidad) {
        int stockActual = stock.getOrDefault(medicamento, 0);
        if (stockActual >= cantidad) {
            stock.put(medicamento, stockActual - cantidad);
            System.out.println("Venta realizada: " + cantidad + " unidades de " + medicamento);
        } else {
            System.out.println("No hay suficiente stock de " + medicamento);
        }
    }
}

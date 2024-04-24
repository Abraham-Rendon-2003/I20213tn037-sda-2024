package mx.edu.utez.sda.extra.service;

import mx.edu.utez.sda.extra.dto.ItemCarritoDTO;
import mx.edu.utez.sda.extra.model.Producto;
import mx.edu.utez.sda.extra.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarritoService {
    @Autowired
    private ProductoRepository productoRepository;

    private Map<String, Integer> carrito = new HashMap<>();

    public void agregarProductoAlCarrito(ItemCarritoDTO itemCarritoDTO) {
        String codigoProducto = itemCarritoDTO.getCodigoProducto();
        int cantidad = itemCarritoDTO.getCantidad();

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        Producto producto = productoRepository.findByCodigo(codigoProducto);
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado con código: " + codigoProducto);
        }

        carrito.put(codigoProducto, carrito.getOrDefault(codigoProducto, 0) + cantidad);
    }

    public double calcularTotalCompra() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : carrito.entrySet()) {
            Producto producto = productoRepository.findByCodigo(entry.getKey());
            if (producto != null) {
                total += producto.getPrecio() * entry.getValue();
            }
        }
        return total;
    }
}
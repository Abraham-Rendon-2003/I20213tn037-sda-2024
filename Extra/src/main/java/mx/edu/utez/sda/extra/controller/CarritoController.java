package mx.edu.utez.sda.extra.controller;

import mx.edu.utez.sda.extra.dto.ItemCarritoDTO;
import mx.edu.utez.sda.extra.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping
    public void agregarProductoAlCarrito(@RequestBody ItemCarritoDTO itemCarritoDTO) {
        carritoService.agregarProductoAlCarrito(itemCarritoDTO);
    }

    @GetMapping("/total")
    public double calcularTotalCompra() {
        return carritoService.calcularTotalCompra();
    }
}

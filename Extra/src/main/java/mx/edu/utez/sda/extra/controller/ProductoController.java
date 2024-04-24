package mx.edu.utez.sda.extra.controller;

import mx.edu.utez.sda.extra.dto.ProductoDTO;
import mx.edu.utez.sda.extra.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ProductoDTO agregarProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.agregarProducto(productoDTO);
    }

    @GetMapping
    public List<ProductoDTO> obtenerProductos() {
        return productoService.obtenerProductos();
    }
}
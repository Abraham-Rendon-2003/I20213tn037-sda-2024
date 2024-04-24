package mx.edu.utez.sda.extra.controller;

import mx.edu.utez.sda.extra.dto.productoDto;
import mx.edu.utez.sda.extra.service.productosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")

public class productosController {
    private final productosService productosservice;

    @Autowired
    public productosController(productosService productosservice) {
        this.productosservice = productosservice;
    }

    @GetMapping("todas")
    public ResponseEntity<List<productoDto>> getAllproductos() {
        List<productoDto> productos = productosservice.getAllproductos();
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/crear")
    public ResponseEntity<productoDto> createProducto(@RequestBody productoDto productoDto) {
        productoDto createProducto = productosservice.createProducto(productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productosservice.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}

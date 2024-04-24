package mx.edu.utez.sda.extra.service;

import mx.edu.utez.sda.extra.dto.ProductoDTO;
import mx.edu.utez.sda.extra.model.Producto;
import mx.edu.utez.sda.extra.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoDTO agregarProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCodigo(productoDTO.getCodigo());
        producto.setDescripcion(productoDTO.getDescripcion());
        productoRepository.save(producto);

        return productoDTO;
    }

    public List<ProductoDTO> obtenerProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(this::convertirAProductoDTO)
                .collect(Collectors.toList());
    }

    private ProductoDTO convertirAProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setCodigo(producto.getCodigo());
        productoDTO.setDescripcion(producto.getDescripcion());
        return productoDTO;
    }
}

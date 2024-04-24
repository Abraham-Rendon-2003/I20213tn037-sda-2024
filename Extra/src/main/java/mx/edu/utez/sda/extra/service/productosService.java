package mx.edu.utez.sda.extra.service;


import mx.edu.utez.sda.extra.dto.productoDto;

import java.util.List;

public interface productosService {
    List<productoDto> getAllproductos();
    productoDto createProducto(productoDto productoDto);
    void eliminarProducto(Long id);
}

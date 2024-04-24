package mx.edu.utez.sda.extra.service;

import mx.edu.utez.sda.extra.dto.productoDto;
import mx.edu.utez.sda.extra.model.productos;
import mx.edu.utez.sda.extra.repository.productosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class productoServiceImpl implements productosService {
    private final productosRepository productosrepository;

    @Autowired
    public productoServiceImpl (productosRepository productosrepository){
        this.productosrepository = productosrepository;
    }
    @Override
    public List<productoDto> getAllproductos() {
        return productosrepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public productoDto createProducto(productoDto productoDto) {
        productos productos = convertToEntity(productoDto);
        return convertToDTO(productosrepository.save(productos));
    }
    @Override
    public void eliminarProducto(Long id) {
        productosrepository.deleteById(id);
    }
    private productoDto convertToDTO(productos productos) {
        productoDto dto = new productoDto();
        BeanUtils.copyProperties(productos, dto);
        return dto;
    }

    private productos convertToEntity(productoDto dto) {
        productos productos = new productos();
        BeanUtils.copyProperties(dto, productos);
        return productos;
    }
}

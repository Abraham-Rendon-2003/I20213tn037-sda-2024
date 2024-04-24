package mx.edu.utez.sda.extra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class productoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String codigo;
    private Double precio;



}

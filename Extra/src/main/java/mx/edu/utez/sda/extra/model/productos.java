package mx.edu.utez.sda.extra.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "productos")
@NoArgsConstructor

public class productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    Long id;
    @Column(name = "nombre_producto", length = 30, nullable = false)
    String nombre;
    @Column(name = "precio_producto", length = 2, nullable = false)
    Double precio;
    @Column(name = "codigo", length = 4, nullable = false)
    String codigo;
    @Column(name = "descripcion_producto", length = 300, nullable = false)
    String descripcion;

    public productos(Long id, String nombre, Double precio, String codigo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}

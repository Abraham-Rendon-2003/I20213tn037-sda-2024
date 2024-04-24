package mx.edu.utez.sda.extra.repository;

import mx.edu.utez.sda.extra.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByCodigo(String codigo);
}

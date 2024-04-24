package mx.edu.utez.sda.extra.repository;

import mx.edu.utez.sda.extra.model.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productosRepository extends JpaRepository<productos, Long> {
    productos getproductosByCodigo(String producto);
}

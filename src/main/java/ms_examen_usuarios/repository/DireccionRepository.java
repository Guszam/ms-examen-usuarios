package ms_examen_usuarios.repository;

import ms_examen_usuarios.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}

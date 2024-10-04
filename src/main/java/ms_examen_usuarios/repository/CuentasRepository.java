package ms_examen_usuarios.repository;

import ms_examen_usuarios.model.Cuentas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentasRepository extends JpaRepository<Cuentas, Long> {
}

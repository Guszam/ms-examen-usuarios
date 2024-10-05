package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.model.Usuarios;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;

public interface CuentasService {

    Cuentas guardarCuenta(@NotNull Usuarios usuarios);
    ResponseEntity<?> buscarCuentas();
    ResponseEntity<?> buscarCuentasPorId(Long idCuenta);
    ResponseEntity<?> guardarCuenta(Cuentas cuentas);
    ResponseEntity<?> modificarCuenta(Cuentas cuentas);
    ResponseEntity<?> eliminarCuenta(Long idCuenta);
    Cuentas actualizaDireccionUsuario(Cuentas cuentas);
}

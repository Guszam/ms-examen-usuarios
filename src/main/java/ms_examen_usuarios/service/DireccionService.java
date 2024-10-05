package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.model.Direccion;
import ms_examen_usuarios.model.Usuarios;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;

public interface DireccionService {

    Direccion guardardireccion(@NotNull Usuarios usuarios);
    Direccion actualizaDireccionUsuario(Direccion direccion);
    ResponseEntity<?> buscarDirecciones();
    ResponseEntity<?> buscarDireccionPorId(Long idDireccion);
    ResponseEntity<?> guardarDireccions(Direccion direccion);
    ResponseEntity<?> eliminarDireccion(Long idDireccion);
    ResponseEntity<?> modificarDireccion(Direccion direccion);
}

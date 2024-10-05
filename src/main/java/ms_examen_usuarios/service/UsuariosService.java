package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Usuarios;
import org.springframework.http.ResponseEntity;

public interface UsuariosService {

    ResponseEntity<?> buscarUsuarios();
    ResponseEntity<?> buscarUsuarioById(Long idUsuario);
    ResponseEntity<?> guardarUsuario(Usuarios usuarios);
    ResponseEntity<?> actualizarDatosUsuario(Usuarios usuarios);
    ResponseEntity<?> eliminarusuario(Long idUsuario);
}

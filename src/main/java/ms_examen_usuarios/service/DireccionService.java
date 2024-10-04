package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Direccion;
import ms_examen_usuarios.model.Usuarios;
import org.jetbrains.annotations.NotNull;

public interface DireccionService {

    Direccion guardardireccion(@NotNull Usuarios usuarios);
    Direccion actualizaDireccionUsuario(Direccion direccion);
}

package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.model.Usuarios;
import org.jetbrains.annotations.NotNull;

public interface CuentasService {

    Cuentas guardarCuenta(@NotNull Usuarios usuarios);
}

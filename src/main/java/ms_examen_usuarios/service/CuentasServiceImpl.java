package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.model.Usuarios;
import ms_examen_usuarios.repository.CuentasRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentasServiceImpl implements CuentasService{

    @Autowired
    private CuentasRepository cuentasRepository;

    public Cuentas guardarCuenta(@NotNull Usuarios usuarios){
        Cuentas cuentas = new Cuentas();
        cuentas.setNumeroCuenta(usuarios.getCuentas().getNumeroCuenta());
        cuentas.setIngresos(usuarios.getCuentas().getIngresos());

        cuentas = cuentasRepository.save(cuentas);

        return cuentas;
    }
}

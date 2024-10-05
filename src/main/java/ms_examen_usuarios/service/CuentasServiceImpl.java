package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.model.Direccion;
import ms_examen_usuarios.model.Usuarios;
import ms_examen_usuarios.repository.CuentasRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity<?> buscarCuentas() {
        List<Cuentas> cuentas = cuentasRepository.findAll();

        if(!cuentas.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(cuentas);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron cuentas");
    }

    @Override
    public ResponseEntity<?> buscarCuentasPorId(Long idCuenta) {
        Optional<Cuentas> cuenta = cuentasRepository.findById(idCuenta);
        if(!cuenta.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(cuenta);
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró cuenta con id " + idCuenta);
        }
    }

    @Override
    public ResponseEntity<?> guardarCuenta(Cuentas cuentas) {
        Cuentas cuentas1 = new Cuentas();
       try{
           cuentas1.setNumeroCuenta(cuentas.getNumeroCuenta());
           cuentas1.setIngresos(cuentas.getIngresos());

           cuentas1 = cuentasRepository.save(cuentas1);
           return ResponseEntity.status(HttpStatus.CREATED).body("Se ha guardado con exito la cuenta");
       }catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Revisar campos");
       }
    }

    @Override
    public ResponseEntity<?> modificarCuenta(Cuentas cuentas) {
        Optional<Cuentas> cuentas1 = cuentasRepository.findById(cuentas.getId());
        if(!cuentas1.isEmpty()){
            try{
                cuentas1.get().setNumeroCuenta(cuentas.getNumeroCuenta());
                cuentas1.get().setIngresos(cuentas.getIngresos());
                cuentas1 = Optional.of(cuentasRepository.save(cuentas));
                return ResponseEntity.status(HttpStatus.OK).body(cuentas1);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Revisar campos");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró cuenta con ese id");
    }

    @Override
    public ResponseEntity<?> eliminarCuenta(Long idCuenta) {
        Optional<Cuentas> cuentas = cuentasRepository.findById(idCuenta);
        if(!cuentas.isEmpty()){
            cuentasRepository.delete(cuentas.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cuenta eliminada exitosamente");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró cuenta");
    }

    @Override
    public Cuentas actualizaDireccionUsuario(Cuentas cuenta) {
        Optional<Cuentas> cuentas = cuentasRepository.findById(cuenta.getId());
        if(!cuentas.isEmpty()){
            cuentas.get().setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentas.get().setIngresos(cuenta.getIngresos());
            cuentasRepository.save(cuentas.get());
            return cuentas.get();
        }else {
            return null;
        }
    }
}

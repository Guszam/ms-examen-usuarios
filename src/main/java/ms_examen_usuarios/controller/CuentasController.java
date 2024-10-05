package ms_examen_usuarios.controller;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.service.CuentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.ReadPendingException;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {

    @Autowired
    private CuentasService cuentasService;

    @GetMapping
    public ResponseEntity<?> buscarCuentas(){
        return cuentasService.buscarCuentas();
    }

    @GetMapping("/{idCuenta}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idCuenta ){
        return cuentasService.buscarCuentasPorId(idCuenta);
    }

    @PostMapping
    public ResponseEntity<?> guardarCuenta(@RequestBody Cuentas cuentas){
        return cuentasService.guardarCuenta(cuentas);
    }

    @PutMapping
    public ResponseEntity<?> actualizarCuenta(@RequestBody Cuentas cuentas){
        return  cuentasService.modificarCuenta(cuentas);
    }

    @DeleteMapping("/{idCuenta}")
    public ResponseEntity<?> eliminarCuenta(@PathVariable Long idCuenta){
        return cuentasService.eliminarCuenta(idCuenta);
    }
}

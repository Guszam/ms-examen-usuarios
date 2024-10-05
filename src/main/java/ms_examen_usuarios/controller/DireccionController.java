package ms_examen_usuarios.controller;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.model.Direccion;
import ms_examen_usuarios.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<?> buscarDirecciones(){
        return direccionService.buscarDirecciones();
    }

    @GetMapping("/{idDireccion}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idDireccion ){
        return direccionService.buscarDireccionPorId(idDireccion);
    }

    @PostMapping
    public ResponseEntity<?> guardarDireccion(@RequestBody Direccion direccion){
        return direccionService.guardarDireccions(direccion);
    }

    @PutMapping
    public ResponseEntity<?> actualizarCuenta(@RequestBody Direccion direccion){
        return  direccionService.modificarDireccion(direccion);
    }

    @DeleteMapping("/{idDireccion}")
    public ResponseEntity<?> eliminarCuenta(@PathVariable Long idDireccion){
        return direccionService.eliminarDireccion(idDireccion);
    }
}

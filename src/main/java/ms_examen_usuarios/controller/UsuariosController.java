package ms_examen_usuarios.controller;

import ms_examen_usuarios.model.Usuarios;
import ms_examen_usuarios.service.UsuariosService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
   private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<?> buscarUsuarios(){
        return usuariosService.buscarUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> buscarUsuarioById(@PathVariable Long idUsuario){
        return usuariosService.buscarUsuarioById(idUsuario);
    }

    @PostMapping
    public ResponseEntity<?> guardarusuario(@RequestBody @NotNull Usuarios usuarios){
        return usuariosService.guardarUsuario(usuarios);
    }

    @PutMapping
    public ResponseEntity<?> actualizarDatosUsuario(@RequestBody Usuarios usuarios){
        return usuariosService.actualizarDatosUsuario(usuarios);
    }
}

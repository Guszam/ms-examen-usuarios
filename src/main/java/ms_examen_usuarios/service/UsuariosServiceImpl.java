package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.model.Direccion;
import ms_examen_usuarios.model.Usuarios;
import ms_examen_usuarios.repository.UsuariosRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private DireccionService direccionService;
    @Autowired
    private CuentasService cuentasService;


    @Override
    public ResponseEntity<?> buscarUsuarios() {
        List<Usuarios> listaUsuarios = usuariosRepository.findAll();
        if (!listaUsuarios.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(listaUsuarios);
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    @Override
    public ResponseEntity<?> buscarUsuarioById(Long idUsuario) {
        Optional<Usuarios> usuario = usuariosRepository.findById(idUsuario);
        if(!usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró usuario con id " + idUsuario);
        }
    }

    @Override
    public ResponseEntity<?> guardarUsuario(@NotNull Usuarios usuarios) {

        Direccion direccion = direccionService.guardardireccion(usuarios);
        Cuentas cuentas = cuentasService.guardarCuenta(usuarios);
        Usuarios usuarios1 = new Usuarios();
        usuarios1.setNombre(usuarios.getNombre());
        usuarios1.setApellidoPaterno(usuarios.getApellidoPaterno());
        usuarios1.setApellidoMaterno(usuarios.getApellidoMaterno());
        usuarios1.setFechaNacimiento(usuarios.getFechaNacimiento());
        usuarios1.setCuentas(cuentas);
        usuarios1.setDireccion(direccion);

        Usuarios save = usuariosRepository.save(usuarios1);

        return ResponseEntity.status(HttpStatus.CREATED).body("Exito");
    }

    @Override
    public ResponseEntity<?> actualizarDatosUsuario(@NotNull Usuarios usuarios) {
       Usuarios usuario = usuariosRepository.getById(usuarios.getId());
       if(usuario.getId() != null){
           Direccion direccion = direccionService.actualizaDireccionUsuario(usuarios.getDireccion());
           if(direccion != null){
               usuario.setDireccion(direccion);
           }
           usuario.setNombre(usuarios.getNombre());
           usuario.setApellidoPaterno(usuarios.getApellidoPaterno());
           usuario.setApellidoMaterno(usuarios.getApellidoMaterno());
           usuario.setFechaNacimiento(usuarios.getFechaNacimiento());

           usuariosRepository.save(usuario);

           return  ResponseEntity.status(HttpStatus.OK).body(usuario);
       }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron resultados");
    }

}

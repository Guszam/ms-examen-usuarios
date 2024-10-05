package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Cuentas;
import ms_examen_usuarios.model.Direccion;
import ms_examen_usuarios.model.Usuarios;
import ms_examen_usuarios.repository.DireccionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    private DireccionRepository direccionRepository;

    public Direccion guardardireccion(@NotNull Usuarios usuarios){
        Direccion direccion = new Direccion();

        direccion.setCodigoPostal(usuarios.getDireccion().getCodigoPostal());
        direccion.setEstado(usuarios.getDireccion().getEstado());

        direccion = direccionRepository.save(direccion);
        return direccion;
    }

    @Override
    public Direccion actualizaDireccionUsuario(@NotNull Direccion direccion) {
        Optional<Direccion> dir = direccionRepository.findById(direccion.getId());
        if(!dir.isEmpty()){
            dir.get().setEstado(direccion.getEstado());
            dir.get().setCodigoPostal(direccion.getCodigoPostal());
            direccionRepository.save(dir.get());
            return dir.get();
        }else {
         return null;
        }
    }

    @Override
    public ResponseEntity<?> buscarDirecciones() {
        List<Direccion> direccion = direccionRepository.findAll();

        if(!direccion.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(direccion);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron direcciones");
    }

    @Override
    public ResponseEntity<?> buscarDireccionPorId(Long idDireccion) {
        Optional<Direccion> direccion = direccionRepository.findById(idDireccion);
        if(!direccion.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(direccion);
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró direccion con id " + idDireccion);
        }
    }

    @Override
    public ResponseEntity<?> guardarDireccions(Direccion direccion) {
        Direccion direccion1 = new Direccion();
        try{
            direccion1.setCodigoPostal(direccion.getCodigoPostal());
            direccion1.setEstado(direccion.getEstado());

            direccion1 = direccionRepository.save(direccion1);
            return ResponseEntity.status(HttpStatus.CREATED).body("Se ha guardado con exito la direccion");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Revisar campos");
        }
    }

    @Override
    public ResponseEntity<?> eliminarDireccion(Long idDireccion) {
        Optional<Direccion> direccion = direccionRepository.findById(idDireccion);
        if(!direccion.isEmpty()){
            direccionRepository.delete(direccion.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Direccion eliminada exitosamente");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró direccion");
    }

    @Override
    public ResponseEntity<?> modificarDireccion(Direccion direccion) {
        Optional<Direccion> direccion1 = direccionRepository.findById(direccion.getId());
        if(!direccion1.isEmpty()){
            try{
                direccion1.get().setCodigoPostal(direccion.getCodigoPostal());
                direccion1.get().setEstado(direccion.getEstado());
                direccion1 = Optional.of(direccionRepository.save(direccion));
                return ResponseEntity.status(HttpStatus.OK).body(direccion1);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Revisar campos");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró direccion con ese id");
    }
}

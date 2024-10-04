package ms_examen_usuarios.service;

import ms_examen_usuarios.model.Direccion;
import ms_examen_usuarios.model.Usuarios;
import ms_examen_usuarios.repository.DireccionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

            return dir.get();
        }else {
         return null;
        }
    }
}

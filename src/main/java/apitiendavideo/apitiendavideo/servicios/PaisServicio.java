package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.entidades.Pais;
import apitiendavideo.apitiendavideo.interfaces.IPaisServicio;
import apitiendavideo.apitiendavideo.repositorios.IPaisRepositorio;

@Service
public class PaisServicio implements IPaisServicio {

    private IPaisRepositorio repositorio;

    public PaisServicio(IPaisRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Pais> listar() {
        return this.repositorio.findAll();
    }

    @Override
    public Pais obtener(Long id) {
        var pais = repositorio.findById(id);
        return pais.isEmpty() ? null : pais.get();
    }

    @Override
    public List<Pais> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Pais guardar(Pais pais) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public boolean eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
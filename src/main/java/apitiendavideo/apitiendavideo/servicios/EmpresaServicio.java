package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.entidades.Empresa;
import apitiendavideo.apitiendavideo.interfaces.IEmpresaServicio;
import apitiendavideo.apitiendavideo.repositorios.IEmpresaRepositorio;

@Service
public class EmpresaServicio implements IEmpresaServicio {

    private IEmpresaRepositorio repositorio;

    public EmpresaServicio(IEmpresaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Empresa> listar() {
        return this.repositorio.findAll();
    }

    @Override
    public Empresa obtener(Long id) {
        var empresa = repositorio.findById(id);
        return empresa.isEmpty() ? null : empresa.get();
    }

    @Override
    public List<Empresa> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return repositorio.save(empresa);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            if (obtener(id) != null) {
                repositorio.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

}

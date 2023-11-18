package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.entidades.Empresa;

public interface IEmpresaServicio {

    public List<Empresa> listar();

    public Empresa obtener(Long id);

    public List<Empresa> buscar(String nombre);

    public Empresa guardar(Empresa empresa);

    public boolean eliminar(Long id);

}

package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Empresa;
import apitiendavideo.apitiendavideo.interfaces.IEmpresaServicio;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {
    
    private IEmpresaServicio servicio;

    public EmpresaControlador(IEmpresaServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empresa> listar() {
        return this.servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Empresa obtener(@PathVariable long id) {
        return this.servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{texto}", method = RequestMethod.GET)
    public List<Empresa> obtener(@PathVariable String texto) {
        return this.servicio.buscar(texto);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Empresa agregar(@RequestBody Empresa empresa) {
        empresa.setId(0);
        return this.servicio.guardar(empresa);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Empresa modificar(@RequestBody Empresa empresa) {
        if (this.servicio.obtener(empresa.getId()) != null) {
            return this.servicio.guardar(empresa);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return this.servicio.eliminar(id);
    }

}

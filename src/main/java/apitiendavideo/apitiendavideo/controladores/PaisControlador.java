package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Pais;
import apitiendavideo.apitiendavideo.interfaces.IPaisServicio;

@RestController
@RequestMapping("/paises")
public class PaisControlador {

    private IPaisServicio servicio;

    public PaisControlador(IPaisServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Pais> listar() {
        return this.servicio.listar();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Pais obtener(@PathVariable long id) {
        return this.servicio.obtener(id);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/buscar/{texto}", method = RequestMethod.GET)
    public List<Pais> obtener(@PathVariable String texto) {
        return this.servicio.buscar(texto);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Pais agregar(@RequestBody Pais pais) {
        pais.setId(0);
        return this.servicio.guardar(pais);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Pais modificar(@RequestBody Pais pais) {
        if (this.servicio.obtener(pais.getId()) != null) {
            return this.servicio.guardar(pais);
        } else {
            return null;
        }
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return this.servicio.eliminar(id);
    }

}

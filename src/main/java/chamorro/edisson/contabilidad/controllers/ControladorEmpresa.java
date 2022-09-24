package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.entities.Empresa;
import chamorro.edisson.contabilidad.entities.MovimientoDinero;
import chamorro.edisson.contabilidad.services.EmpresaServicio;
import chamorro.edisson.contabilidad.services.MovimientoDineroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/enterprises")
public class ControladorEmpresa {

    @Autowired
    EmpresaServicio servicioEmpresa;
    @Autowired
    MovimientoDineroServicio servicioDinero;


    @GetMapping("")
    public List<Empresa> getEmpresas() {
        return this.servicioEmpresa.getEmpresas();
    }

    @GetMapping("/{id}")
    public Empresa getEmpresa(@PathVariable("id") int id) {
        return this.servicioEmpresa.getEmpresa(id);
    }

    @PostMapping("")
    public Empresa crearEmpresa(@RequestBody Empresa empresaNueva) {
        return this.servicioEmpresa.postEmpresa(empresaNueva);
    }

    @PatchMapping("/{id}")
    public void patchEmpresa(@PathVariable("id") long id, @RequestBody Empresa datos) {
        this.servicioEmpresa.patchEmpresa(id, datos);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable("id") long id) {
        this.servicioEmpresa.deleteEmpresa(id);
    }

    //--------------Servicios para movimiento de dinero---------------------------

    @GetMapping("/{id}/movements")
    public List<MovimientoDinero> getMovimientos(@PathVariable("id") long id) {
        return this.servicioDinero.getMovimientos(id);
    }

    @PostMapping("/movements")
    public MovimientoDinero postMovimiento(@RequestBody MovimientoDinero movimientoNuevo) {
        return this.servicioDinero.postMovimiento(movimientoNuevo);
    }

    @PatchMapping("/{id}/movements")
    public void patchMovimientos(@PathVariable("id") long id, @RequestBody MovimientoDinero datos) {
        this.servicioDinero.patchMovimientoDinero(id, datos);
    }

    @DeleteMapping("/{id}/movements")
    public void deleteMovimiento(@PathVariable("id") long id) {
        this.servicioDinero.deleteMovimiento(id);
    }

}

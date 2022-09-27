package chamorro.edisson.contabilidad.controllers;


import chamorro.edisson.contabilidad.models.Empresa;
import chamorro.edisson.contabilidad.models.MovimientoDinero;
import chamorro.edisson.contabilidad.services.EmpresaService;
import chamorro.edisson.contabilidad.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController()
@RequestMapping("/enterprises")
public class ControladorEmpresa {

    @Autowired
    EmpresaService servicioEmpresa;
    @Autowired
    MovimientoService servicioDinero;


    @GetMapping("")
    public List<Empresa> getEmpresas() {

        return this.servicioEmpresa.getEmpresas();

    }

    @GetMapping("/{id}")
    public Empresa getEmpresa(@PathVariable("id") int id) {
        return this.servicioEmpresa.getEmpresa(id);
    }

    @PostMapping("")
    public RedirectView crearEmpresa(@ModelAttribute Empresa empresaNueva, Model model) {
        model.addAttribute(empresaNueva);
        this.servicioEmpresa.postEmpresa(empresaNueva);
        return new RedirectView("/lista-empresas");
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

    @GetMapping("/movements")
    public List<MovimientoDinero> getMovimientos(@PathVariable("id") long id) {
        return this.servicioDinero.getMovimientos();
    }

    @PostMapping("/movements")
    public RedirectView postMovimiento(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") MovimientoDinero movimientoNuevo, Model model) {
        model.addAttribute(movimientoNuevo);
        this.servicioDinero.postMovimiento(movimientoNuevo);
        return new RedirectView("/lista-movimientos");
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

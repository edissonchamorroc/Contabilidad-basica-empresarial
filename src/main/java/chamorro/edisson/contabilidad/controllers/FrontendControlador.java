package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.models.Empleado;

import chamorro.edisson.contabilidad.models.Empresa;
import chamorro.edisson.contabilidad.models.MovimientoDinero;
import chamorro.edisson.contabilidad.services.EmpleadoService;
import chamorro.edisson.contabilidad.services.EmpresaService;
import chamorro.edisson.contabilidad.services.MovimientoService;
import chamorro.edisson.contabilidad.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class FrontendControlador {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    EmpresaService empresaService;
    @Autowired
    MovimientoService movimientoService;
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @GetMapping(value={"/","/home"})
    public String home(Model model){
        model.addAttribute("empleadologin",myUserDetailsService.getEmpleado());
        return "home";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("empleado",new Empleado());
        return "login";
    }

    @PostMapping("/login")
    public void postLogin(@ModelAttribute("empleado") Empleado empleado){

    }
    @PostMapping("/logout")
    public void postLogout(){

    }

    //-------- mapping para empleados en front
    @GetMapping("/adm-empleados")
    public String admEmpleados(Model model){

        return "adm_empleados";
    }

    @GetMapping("/lista-empleados")
    public String getEmpleados(Model model){
        List<Empleado> listaEmpleados=this.empleadoService.getEmpleados();
        model.addAttribute("empleados",listaEmpleados);
        return "lista_empleados";
    }

    @GetMapping("/registro-empleado")
    public String postEmpleado(Model model){
        List<Empresa> listaEmpresas=this.empresaService.getEmpresas();
        model.addAttribute("empleado",new Empleado());
        model.addAttribute("empresas",listaEmpresas);
        return "registro_empleado";
    }

    @GetMapping("/modificar-empleado/{id}")
    public String patchEmpleado(@PathVariable("id") long id,Model model){
        List<Empresa> listaEmpresas=this.empresaService.getEmpresas();
        Empleado empleado=empleadoService.getEmpleado(id);
        model.addAttribute("empleado",empleado);
        model.addAttribute("empresas",listaEmpresas);
        this.empleadoService.patchEmpleado(empleado.getId(),empleado);
        return "registro_empleado";
    }

    @GetMapping("/eliminar-empleado/{id}")
    public String deleteEmpleado(@PathVariable("id") long id, Model model){
        this.empleadoService.deleteEmpleado(id);
        List<Empleado> listaEmpleados=this.empleadoService.getEmpleados();
        model.addAttribute("empleados",listaEmpleados);
        return "lista_empleados";
    }

    //---------- mapping para empresas en front
    @GetMapping("/adm-empresas")
    public String admEmpresas(Model model){

        return "adm_empresas";
    }
    @GetMapping("/lista-empresas")
    public String getEmpresas(Model model){
        List<Empresa> listaEmpresas=this.empresaService.getEmpresas();
        model.addAttribute("empresas",listaEmpresas);
        return "lista_empresas";
    }

    @GetMapping("/registro-empresa")
    public String postEmpresa(Model model){
        model.addAttribute("empresa",new Empresa());
        return "registro_empresa";
    }

    @GetMapping("/modificar-empresa/{id}")
    public String patchEmpresa(@PathVariable("id") long id,Model model){
        Empresa empresa = this.empresaService.getEmpresa(id);
        model.addAttribute("empresa",empresa);
        this.empresaService.patchEmpresa(empresa.getId(),empresa);
        return "registro_empresa";
    }


    @GetMapping("/eliminar-empresa/{id}")
    public String deleteEmpresa(@PathVariable("id") long id, Model model){
        this.empresaService.deleteEmpresa(id);
        List<Empresa> listaEmpresas=this.empresaService.getEmpresas();
        model.addAttribute("empresas",listaEmpresas);
        return "lista_empresas";
    }


    //-------- mapping para movimientos en front
    @GetMapping("/adm-movimientos")
    public String admMovimientos(Model model){

        return "adm_movimientos";
    }

    @GetMapping("/registro-movimiento")
    public String postMovimientos(Model model){
        model.addAttribute("emp",myUserDetailsService.getEmpleado());
        model.addAttribute("movimiento",new MovimientoDinero());
        return "registro_movimiento";
    }

    @GetMapping("/lista-movimientos")
    public String getMovimientos(Model model){
        List<Empleado> emplist = empleadoService.getEmpleados();
        List<MovimientoDinero> listaMovimientos=this.movimientoService.getMovimientos();
        model.addAttribute("movimientos",listaMovimientos);
        model.addAttribute("empleados",emplist);
        return "lista_movimientos";
    }

    @GetMapping("/modificar-movimiento/{id}")
    public String patchMovimiento(@PathVariable("id") long id,Model model){
        MovimientoDinero movimiento = this.movimientoService.getMovimiento(id);
        model.addAttribute("movimiento",movimiento);
        model.addAttribute("emp",myUserDetailsService.getEmpleado());
        this.movimientoService.patchMovimientoDinero(movimiento.getId(),movimiento);
        return "registro_movimiento";
    }


    @GetMapping("/eliminar-movimiento/{id}")
    public String deleteMovimiento(@PathVariable("id") long id, Model model){
        this.movimientoService.deleteMovimiento(id);
        List<MovimientoDinero> listaMovimientos=this.movimientoService.getMovimientos();
        model.addAttribute("movimientos",listaMovimientos);
        return "lista_movimientos";
    }

}

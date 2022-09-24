package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.entities.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllador {

    @GetMapping(value={"/","/home"})
    public String home(){
        return "home";
    }



    @GetMapping("/RegistroUsuario")
    public String registroN(Model model){
        model.addAttribute("nuevo_empleado",new Empleado());
        return "registro_usuario";
    }

    @GetMapping("/RegistroExitoso")
    public String registroE(Model model){
        model.addAttribute("nuevo_empleado",new Empleado());
        return "registro_exitoso";
    }



}

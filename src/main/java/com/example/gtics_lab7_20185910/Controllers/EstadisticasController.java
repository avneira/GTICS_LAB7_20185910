package com.example.gtics_lab7_20185910.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estadisticas")
public class EstadisticasController {
    @GetMapping("/verEstadisticas")
    public String ind(){
        return "tecnicos/lista";
    }
}

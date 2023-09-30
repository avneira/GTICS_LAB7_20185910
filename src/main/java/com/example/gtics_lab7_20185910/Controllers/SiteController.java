package com.example.gtics_lab7_20185910.Controllers;

import com.example.gtics_lab7_20185910.Repository.SiteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/site")
public class SiteController {

    final SiteRepository siteRepository;

    public SiteController(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }


    @GetMapping("/stats")
    public String estadisticas(org.springframework.ui.Model model){

        model.addAttribute("listaTicketsPorSitio", siteRepository.obtenerTicketsPorSitio());
        return "estadisticas";
    }


}

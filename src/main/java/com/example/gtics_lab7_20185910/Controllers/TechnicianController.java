package com.example.gtics_lab7_20185910.Controllers;

import ch.qos.logback.core.model.Model;
import com.example.gtics_lab7_20185910.Repository.TechnicianRepository;
import com.example.gtics_lab7_20185910.entity.Technician;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tecnicos")

public class TechnicianController {
    final TechnicianRepository technicianRepository;


    public TechnicianController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }


    @GetMapping(value={"/verEquipos", "/", ""})
    public String listaEquipos(org.springframework.ui.Model model){
        List<Technician> listaTecnicos = technicianRepository.findAll();
        model.addAttribute("listaTecnicos", listaTecnicos);
        return "tecnicos/lista";
    }

    @GetMapping("/editar")
    public String editar(@ModelAttribute("product") Technician technician,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optionalTechnician = technicianRepository.findById(id);

        if (optionalTechnician.isPresent()) {
            technician = optionalTechnician.get();
            model.addAttribute("tecnico", technician);

            return "tecnicos/new";
        } else {
            return "redirect:/tecnicos/lista";
        }
    }



    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("tecnico") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {

            if (technician.getId() == 0) {
                attr.addFlashAttribute("msg", "Tenico" + technician.getFirstname() + " exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Tenico"+ technician.getFirstname() +" actualizado exitosamente");
            }
            technicianRepository.save(technician);
            return "redirect:/tecnicos/lista";


        } else {
            return "tecnicos/new";
        }
    }






}

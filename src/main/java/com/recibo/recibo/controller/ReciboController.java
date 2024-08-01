package com.recibo.recibo.controller;

import com.recibo.recibo.model.ReciboModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReciboController {

    @GetMapping("/formRecibo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("recibo", new ReciboModel());
        return "formRecibo";
    }

    @PostMapping("/generarRecibo")
    public String generarRecibo(@ModelAttribute ReciboModel recibo, Model model) {
        double montoTotal = recibo.montoTotal();
        recibo.setFecha(recibo.convertirFecha());
        model.addAttribute("montoTotal", montoTotal);
        model.addAttribute("recibo", recibo);
        return "recibo";
    }
}


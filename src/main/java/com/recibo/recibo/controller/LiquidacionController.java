package com.recibo.recibo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recibo.recibo.model.LiquidacionModel;

@Controller
public class LiquidacionController {
    @GetMapping("/formLiquidacion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("liquidacion", new LiquidacionModel());
        return "formLiquidacion";
    }

    @PostMapping("/generarLiquidacion")
    public String generarLiquidacion(@ModelAttribute LiquidacionModel liquidacion, 
                                @RequestParam Map<String, String> requestParams, 
                                Model model) {
        // Obtener el valor de porCobranza del Map
        String porCobranza = requestParams.get("porCobranza");
        double otrosConceptos = liquidacion.getOtrosConceptos();
        double gastosInquilino = liquidacion.getGastosInquilino();
        double aDeducir = liquidacion.deduccionHonorarios(liquidacion.getHonorarios());
        double totalPercibido = liquidacion.totalPercibido();
        double saldo = liquidacion.saldoAfavor();
        String comentarios = liquidacion.getComentariosDefault();
        // Agregar el valor de porCobranza al modelo
        model.addAttribute("porCobranza", porCobranza);
        model.addAttribute("otrosConceptos", otrosConceptos);
        model.addAttribute("gastosInquilino", gastosInquilino);
        model.addAttribute("totalPercibido", totalPercibido);
        model.addAttribute("aDeducir", aDeducir);
        model.addAttribute("saldo", saldo);
        model.addAttribute("comentarios", comentarios);

        // Agregar el objeto liquidacion al modelo de vista resultante
        model.addAttribute("liquidacion", liquidacion);
        
        return "liquidacion";
    }
}

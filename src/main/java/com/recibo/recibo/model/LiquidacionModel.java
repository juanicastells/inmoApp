package com.recibo.recibo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiquidacionModel {
    private String nombrePropietario;
    private String nombreInquilino;
    private double montoPercibido;
    private double otrosConceptos;
    private double honorarios;
    private double gastosInquilino;
    private String detalleOtrosConceptos;
    private String detalleGastosInquilino;
    private String comentariosDefault;

    public LiquidacionModel(){
        this.comentariosDefault = "SALTO,   DE  DE RECIBI de Sra/Sr.  la suma de pesos:  ($ ), en pago del importe liquido resultante de la liquidación que le antecede.";
        this.honorarios = 5;
    }

    public double totalPercibido (){
        return montoPercibido - gastosInquilino;
    }

    public double deduccionHonorarios (double porcentaje){
        return porcentaje/100 * montoPercibido + this.otrosConceptos;
    }

    public double saldoAfavor (){
        return this.totalPercibido() - this.deduccionHonorarios(honorarios);
    }
}

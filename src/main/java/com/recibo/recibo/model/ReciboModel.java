package com.recibo.recibo.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ReciboModel {
    
    private String nombre;
    private String direccion;
    private double monto;
    private double otrosConceptos;
    private String fecha;
    private String formaPago;
    private String comentarios;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    
    public double getOtrosConceptos() {return otrosConceptos;}
    public void setOtrosConceptos(double otrosConceptos){ this.otrosConceptos = otrosConceptos; } 

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    
    public String getFormaPago() { return formaPago; }
    public void setFormaPago(String formaPago) { this.formaPago = formaPago; }
    
    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public double montoTotal () {return monto + otrosConceptos;}

    public String convertirFecha() {
        try {
            // Definir el formato de entrada
            DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Parsear la fecha de entrada al objeto LocalDate
            LocalDate fecha = LocalDate.parse(this.fecha, formatoEntrada);

            // Definir el formato de salida
            DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Formatear la fecha al nuevo formato
            return fecha.format(formatoSalida);
        } catch (DateTimeParseException e) {
            // Manejar la excepción si el formato de la fecha de entrada es incorrecto
            e.printStackTrace();
            return null;
        }
    }
}

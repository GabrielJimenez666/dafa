package com.example.Objetos;

import lombok.Data;

@Data
public class Meta {

    private int id;
    private int usuario_id;
    private String nombre;
    private String fecha_limite;
    private double monto_objetivo;
    private double estado;
    private double saldo;

    public Meta(int id, int usuario_id, String nombre, String fecha_limite, double monto_objetivo, double estado,
            double saldo) {
        this.setId(id);
        this.setUsuario_id(usuario_id);
        this.setNombre(nombre);
        this.setFecha_limite(fecha_limite);
        this.setMonto_objetivo(monto_objetivo);
        this.setEstado(estado);
        this.setSaldo(saldo);
    }

}

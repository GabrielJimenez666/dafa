package com.example.Objetos;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Cashflow {

    private ArrayList<Usuario> Usuarios_registrados = new ArrayList<Usuario>();

    public void agregar_usuario(int id, String usuario, String contrasena, String email, String fecha_ingreso, double saldo) {
        this.getUsuarios_registrados().add(new Usuario(id, usuario, contrasena, email, fecha_ingreso, saldo));
    }

}

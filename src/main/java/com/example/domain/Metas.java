package com.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

//con Data se añaden automaticamente los setters y los getters de la clase persona
@Data
@Entity
@Table(name = "metas")
public class Metas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int usuario_id;
    private String nombre;
    private String fecha_limite;
    private double monto_objetivo;
    private double estado;
    private double saldo;

}
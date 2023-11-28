package com.example.Objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import lombok.Data;

//el @Data nos da todos los getters y los setters
@Data
public class Usuario {

    private int id;
    private String usuario;
    private String contrasena;
    private String email;
    private String fecha_ingreso;
    private double saldo;
    private ArrayList<Bolsillo> bolsillos = new ArrayList<Bolsillo>();
    private ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    private ArrayList<Notificacion> notificaciones = new ArrayList<Notificacion>();
    private ArrayList<Meta> metas = new ArrayList<Meta>();

    public Usuario(int id, String usuario, String contrasena, String email, String fecha_ingreso, double saldo) {
        setId(id);
        setUsuario(usuario);
        setContrasena(contrasena);
        setEmail(email);
        setFecha_ingreso(fecha_ingreso);
        setSaldo(saldo);
    }

    public void agregar_bolsillo(int id, int usuario_id, String nombre, double saldo) {
        this.getBolsillos().add(new Bolsillo(id, usuario_id, nombre, saldo));
    }

    public void eliminar_bolsillo(int id2) {
        for (Bolsillo bol : this.getBolsillos()) {
            if (bol.getId() == id2) {
                this.setSaldo(this.getSaldo() + bol.getSaldo());
                this.getBolsillos().remove(bol);
                break;
            }
        }
    }

    public void cambiar_contra(String intento, String nueva) {
        if (intento.equals(this.getContrasena())) {
            this.setContrasena(nueva);
        }
    }

    // en este metodo se pasa dinero del saldo principal del usuario a uno de sus
    // bolsillos
    public void agregar_dinero_bolsillo(int id2, double monto) {
        this.setSaldo(this.getSaldo() - monto);
        for (Bolsillo bol : this.getBolsillos()) {
            if (bol.getId() == id2) {
                bol.setSaldo(bol.getSaldo() + monto);
            }
        }
    }

    public void agregar_transaccion(int id, int usuario_id, String tipo, String fecha, double monto) {
        this.getTransacciones().add(new Transaccion(id, usuario_id, tipo, fecha, monto));
    }

    // este metodo es cuando se simula un gasto manualmente, y se hace el pago con
    // el saldo principal
    public void simular_gasto(int id, double monto) {
        this.agregar_transaccion(id, this.getId(), "gasto", LocalDate.now().toString(), monto);
        this.setSaldo(this.getSaldo() - monto);
    }

    // este metodo es cuando se simula un gasto manualmente, y se hace el pago con
    // un bolsillo
    public void simular_gasto(int id, double monto, int bolId) {
        this.agregar_transaccion(id, this.getId(), "gasto", LocalDate.now().toString(), monto);
        for (Bolsillo bol : this.getBolsillos()) {
            if (bol.getId() == bolId) {
                bol.setSaldo(bol.getSaldo() - monto);
            }
        }
    }

    public void simular_ingreso(int id, double monto) {
        this.agregar_transaccion(id, this.getId(), "ingreso", LocalDate.now().toString(), monto);
        this.setSaldo(this.getSaldo() + monto);
    }

    public void agregar_notificacion(int id, int usuario_id, String mensaje) {
        this.getNotificaciones().add(new Notificacion(id, usuario_id, mensaje));
    }

    public void eliminar_notificacion(int id2) {
        for (Notificacion noti : this.getNotificaciones()) {
            if (noti.getId() == id2) {
                this.getNotificaciones().remove(noti);
                break;
            }
        }
    }

    public void agregar_meta(int id, int usuario_id, String nombre, String fecha_limite, double monto_objetivo,
            double estado,
            double saldo) {
        this.getMetas().add(new Meta(id, usuario_id, nombre, fecha_limite, monto_objetivo, estado, saldo));
    }

    public void eliminar_meta(int id2) {
        for (Meta meta : this.getMetas()) {
            if (meta.getId() == id2) {
                this.setSaldo(this.getSaldo() + meta.getSaldo());
                this.getMetas().remove(meta);
                break;
            }
        }
    }

    public void agregar_dinero_meta(int id2, double monto, double progreso) {
        this.setSaldo(this.getSaldo() - monto);
        for (Meta meta : this.getMetas()) {
            if (meta.getId() == id2) {
                meta.setSaldo(meta.getSaldo() + monto);
                meta.setEstado(progreso);
            }
        }

    }

}

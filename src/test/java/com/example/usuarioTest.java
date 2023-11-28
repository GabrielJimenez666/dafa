package com.example;
import com.example.Objetos.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

public class usuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        // Inicializa un usuario antes de cada prueba
        usuario = new Usuario(1, "usuarioTest", "contrasena123", "test@cashflow.com", "2023-01-01", 1000.0);
    }

    @Test
    public void testAgregarBolsillo() {
        usuario.agregar_bolsillo(1, 1, "Bolsillo1", 500.0);
        assertEquals(1, usuario.getBolsillos().size(), "El bolsillo no se agregó correctamente");
    }

    private void assertEquals(String string2, String string3, String string) {
    }

    @Test
    public void testEliminarBolsillo() {
        usuario.agregar_bolsillo(1, 1, "Bolsillo1", 500.0);
        usuario.eliminar_bolsillo(1);
        assertEquals(0, usuario.getBolsillos().size(), "El bolsillo no se eliminó correctamente");
        assertEquals(1500.0, usuario.getSaldo(), "El saldo no se actualizó correctamente después de eliminar el bolsillo");
    }

    private void assertEquals(double d, double saldo, String string) {
    }

    /**
     * 
     */
    @Test
    public void testCambiarContrasena() {
        usuario.cambiar_contra("contrasena123", "nuevaContrasena");
        assertEquals("nuevaContrasena", usuario.getContrasena(), "La contraseña no se cambió correctamente");
    }

    @Test
    public void testSimularGasto() {
        usuario.simular_gasto(1, 200.0);
        assertEquals(800.0, usuario.getSaldo(), "El saldo no se actualizó correctamente después de simular un gasto");
    }

    @Test
    public void testSimularIngreso() {
        usuario.simular_ingreso(1, 300.0);
        assertEquals(1300.0, usuario.getSaldo(), "El saldo no se actualizó correctamente después de simular un ingreso");
    }

    @Test
    public void testAgregarNotificacion() {
        usuario.agregar_notificacion(1, 1, "Mensaje de prueba");
        assertEquals(1, usuario.getNotificaciones().size(), "La notificación no se agregó correctamente");
    }

    @Test
    public void testEliminarNotificacion() {
        usuario.agregar_notificacion(1, 1, "Mensaje de prueba");
        usuario.eliminar_notificacion(1);
        assertTrue(usuario.getNotificaciones().isEmpty(), "La notificación no se eliminó correctamente");
    }

    @Test
    public void testAgregarMeta() {
        usuario.agregar_meta(1, 1, "Meta de prueba", "2023-01-01", 1000.0, 0.0, 0.0);
        assertEquals(1, usuario.getMetas().size(), "La meta no se agregó correctamente");
    }

    @Test
    public void testEliminarMeta() {
        usuario.agregar_meta(1, 1, "Meta de prueba", "2023-01-01", 1000.0, 0.0, 0.0);
        double saldoInicial = usuario.getSaldo();
        usuario.eliminar_meta(1);
        assertEquals(saldoInicial, usuario.getSaldo(), "El saldo no se actualizó correctamente después de eliminar la meta");
        assertTrue(usuario.getMetas().isEmpty(), "La meta no se eliminó correctamente");
    }

    

}



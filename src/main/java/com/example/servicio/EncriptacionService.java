package com.example.servicio;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class EncriptacionService {

    private final BCryptPasswordEncoder bcryptEncoder;

    public EncriptacionService() {
        this.bcryptEncoder = new BCryptPasswordEncoder();
    }

    public String encriptar(String contrasena) {
        return bcryptEncoder.encode(contrasena);
    }

    public boolean verificarContrasena(String contrasenaOriginal, String contrasenaEncriptada) {
        return bcryptEncoder.matches(contrasenaOriginal, contrasenaEncriptada);
    }
}
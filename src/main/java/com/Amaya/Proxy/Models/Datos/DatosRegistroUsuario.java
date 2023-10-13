package com.Amaya.Proxy.Models.Datos;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(

        @NotBlank
        String nombre,

        @NotBlank
        String apellido) {
}

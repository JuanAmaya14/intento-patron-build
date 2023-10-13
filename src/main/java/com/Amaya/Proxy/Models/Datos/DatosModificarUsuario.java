package com.Amaya.Proxy.Models.Datos;

import jakarta.validation.constraints.NotNull;

public record DatosModificarUsuario(

        @NotNull
        long id,
        String nombre,
        String apellido


) {
}

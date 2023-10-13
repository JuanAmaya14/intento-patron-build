package com.Amaya.Proxy.Models;

import com.Amaya.Proxy.Models.Datos.DatosModificarUsuario;
import com.Amaya.Proxy.Models.Datos.DatosRegistroUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;


    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {

        this.nombre = datosRegistroUsuario.nombre();
        this.apellido = datosRegistroUsuario.apellido();

    }

    public void modificar(DatosModificarUsuario datosModificarUsuario) {

        if (datosModificarUsuario.nombre() != null) {

            this.nombre = datosModificarUsuario.nombre();

        }

        if (datosModificarUsuario.apellido() != null) {

            this.apellido = datosModificarUsuario.apellido();

        }


    }
}

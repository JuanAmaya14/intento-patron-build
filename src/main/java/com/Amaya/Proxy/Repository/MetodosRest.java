package com.Amaya.Proxy.Repository;

import com.Amaya.Proxy.Models.Datos.DatosModificarUsuario;
import com.Amaya.Proxy.Models.Datos.DatosRegistroUsuario;
import org.springframework.http.ResponseEntity;

public interface MetodosRest {

    ResponseEntity registrarUsuario(DatosRegistroUsuario datosRegistroUsuario);

    ResponseEntity listarUsuarios();

    ResponseEntity listarUsuario(long id);

    ResponseEntity modificarUsuario(DatosModificarUsuario datosModificarUsuario);

    ResponseEntity eliminarUsuario(long id);

}

package com.Amaya.Proxy.Controller;

import com.Amaya.Proxy.Models.Datos.DatosModificarUsuario;
import com.Amaya.Proxy.Models.Datos.DatosRegistroUsuario;
import com.Amaya.Proxy.ProxyApplication;
import com.Amaya.Proxy.Repository.MetodosRest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ProxyController implements MetodosRest {

    @Autowired
    private MetodosRest metodosRest;

    private static final Logger logger = LoggerFactory.getLogger(ProxyApplication.class);

    @PostMapping
    @Transactional
    @Override
    public ResponseEntity registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {

        logger.info("Entrando al proxy POST");

        if (metodosRest == null) {
            metodosRest = new UsuarioController();
            return metodosRest.registrarUsuario(datosRegistroUsuario);
        } else {
            return metodosRest.registrarUsuario(datosRegistroUsuario);
        }

    }

    @GetMapping
    @Override
    public ResponseEntity listarUsuarios() {

        logger.info("Entrando al proxy GET");

        if (metodosRest == null) {
            metodosRest = new UsuarioController();
            return metodosRest.listarUsuarios();
        } else {
            return metodosRest.listarUsuarios();
        }

    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity listarUsuario(@PathVariable long id) {

        logger.info("Entrando al proxy GET id");

        if (metodosRest == null) {
            metodosRest = new UsuarioController();
            return metodosRest.listarUsuario(id);
        } else {
            return metodosRest.listarUsuario(id);
        }
    }

    @PutMapping
    @Transactional
    @Override
    public ResponseEntity modificarUsuario(@RequestBody DatosModificarUsuario datosModificarUsuario) {

        logger.info("Entrando al proxy PUT");

        if (metodosRest == null) {
            metodosRest = new UsuarioController();
            return metodosRest.modificarUsuario(datosModificarUsuario);
        } else {
            return metodosRest.modificarUsuario(datosModificarUsuario);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Override
    public ResponseEntity eliminarUsuario(@PathVariable long id) {

        logger.info("Entrando al proxy DELETE");

        if (metodosRest == null) {
            metodosRest = new UsuarioController();
            return metodosRest.eliminarUsuario(id);
        } else {
            return metodosRest.eliminarUsuario(id);
        }
    }
}

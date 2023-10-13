package com.Amaya.Proxy.Controller;

import com.Amaya.Proxy.Models.Datos.DatosListadoUsuario;
import com.Amaya.Proxy.Models.Datos.DatosModificarUsuario;
import com.Amaya.Proxy.Models.Datos.DatosRegistroUsuario;
import com.Amaya.Proxy.Models.Datos.DatosRespuestaUsuario;
import com.Amaya.Proxy.Models.Usuario;
import com.Amaya.Proxy.ProxyApplication;
import com.Amaya.Proxy.Repository.MetodosRest;
import com.Amaya.Proxy.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
public class UsuarioController implements MetodosRest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProxyApplication.class);

    @Transactional
    @Override
    public ResponseEntity registrarUsuario(DatosRegistroUsuario datosRegistroUsuario) {

        logger.info("Entrando al original POST");

        Usuario usuario = usuarioRepository.save(new Usuario(datosRegistroUsuario));

        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(),
                usuario.getApellido());

        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
                .toUri();
        return ResponseEntity.created(uri).body(datosRespuestaUsuario);
    }

    @Override
    public ResponseEntity listarUsuarios() {

        logger.info("Entrando al original GET");

        return ResponseEntity.ok(usuarioRepository.findAll());

    }

    @Override
    public ResponseEntity listarUsuario(@PathVariable long id) {

        logger.info("Entrando al original GET id");

        Usuario usuario = usuarioRepository.getReferenceById(id);

        DatosListadoUsuario datosListadoUsuario = new DatosListadoUsuario(usuario.getNombre(), usuario.getApellido());

        return ResponseEntity.ok(datosListadoUsuario);

    }

    @Transactional
    @Override
    public ResponseEntity modificarUsuario(@RequestBody DatosModificarUsuario datosModificarUsuario) {

        logger.info("Entrando al original PUT");

        Usuario usuario = usuarioRepository.getReferenceById(datosModificarUsuario.id());

        usuario.modificar(datosModificarUsuario);

        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(),
                usuario.getApellido());

        return ResponseEntity.ok(datosRespuestaUsuario);

    }

    @Transactional
    @Override
    public ResponseEntity eliminarUsuario(@PathVariable long id) {

        logger.info("Entrando al original DELETE");

        Usuario usuario = usuarioRepository.getReferenceById(id);

        usuarioRepository.deleteById(id);

        return ResponseEntity.ok("El usuario: " + usuario.getNombre() + " fue eliminado");

    }

}

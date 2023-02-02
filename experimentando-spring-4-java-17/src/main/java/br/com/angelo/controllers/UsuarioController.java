package br.com.angelo.controllers;

import br.com.angelo.exceptions.ResourceNotFoundException;
import br.com.angelo.model.Usuario;
import br.com.angelo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/findAll")
    public List<Usuario> findAll() {
        List<Usuario> usuarios;
        usuarios = usuarioService.findAll();
        return usuarios;
    }

    @GetMapping("/findById/{id}")
    public Usuario findById(@PathVariable("id") Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
//        if(usuario == null){
//            throw new ExemploBadRequestException("Usuário nulo");
//        }
        //Requisições nulas são barradas automaticamente.
        if(usuario.getNome() == null || usuario.getNome().equals("")){
            throw new ResourceNotFoundException("Sem valor para nome usuário");
        }
        return usuarioService.cadastrar(usuario);
    }

    @PutMapping("/editar")
    public Usuario editar(@RequestBody Usuario usuario) {
        return usuarioService.editar(usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {

        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

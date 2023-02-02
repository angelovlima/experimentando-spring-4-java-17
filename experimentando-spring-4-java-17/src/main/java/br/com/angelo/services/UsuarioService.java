package br.com.angelo.services;

import br.com.angelo.model.Usuario;
import br.com.angelo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private final Logger logger = Logger.getLogger(UsuarioService.class.getName());

    public List<Usuario> findAll() {
        logger.info("Buscando usuarios");
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResolutionException("Nenhum usuário encontrado com esse id"));
    }

    public Usuario cadastrar(Usuario usuario) {
        logger.info("Cadastrando usuario");
        return usuarioRepository.save(usuario);
    }

    public Usuario editar(Usuario usuario) {
        logger.info("Editando usuario");
        Usuario novoUsuario = findById(usuario.getId());
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setSobrenome(usuario.getSobrenome());
        novoUsuario.setEmail(usuario.getEmail());

        return usuarioRepository.save(novoUsuario);
    }

    public void deletar(Long id) {
        logger.info("Deletando usuario");
        usuarioRepository.deleteById(id);
    }
}

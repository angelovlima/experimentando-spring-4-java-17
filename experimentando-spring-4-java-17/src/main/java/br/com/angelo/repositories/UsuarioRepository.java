package br.com.angelo.repositories;

import br.com.angelo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

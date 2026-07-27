package com.generation.ignisspark.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.ignisspark.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Busca um usuário pelo e-mail/usuário exato
    public Optional<Usuario> findByUsuario(String usuario);

    // Busca usuários pelo nome (contendo o texto digitado, ignorando maiúsculas e minúsculas)
    public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
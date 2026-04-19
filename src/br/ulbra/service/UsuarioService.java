package br.ulbra.service;

import br.ulbra.dao.UsuarioDAO;
import br.ulbra.model.Usuario;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService(UsuarioDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Usuario usuario) {

        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        } else if (usuario.getNome().length() > 150) {
            throw new IllegalArgumentException("Máximo de caracteres alcaçado.");

        }

        if (usuario.getCargo() == null || usuario.getCargo().trim().isEmpty()) {
            throw new IllegalArgumentException("O cargo é obrigatório.");
        } else if (usuario.getCargo().length() > 40) {
            throw new IllegalArgumentException("Máximo de caracteres alcaçado.");

        }

        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        } else if (usuario.getEmail().length() > 255) {
            throw new IllegalArgumentException("Máximo de caracteres alcaçado.");

        }
        if (!usuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("O e-mail informado é inválido.");
        }

        if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória.");
        }
        if (usuario.getSenha().length() < 6) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 caracteres.");
        } else if (usuario.getSenha().length() > 255) {
            throw new IllegalArgumentException("Máximo de caracteres alcaçado.");

        }

        dao.salvar(usuario);
    }

    public List<Usuario> listar() {
        return dao.listar();
    }

    public void atualizar(Usuario usuario) {
        dao.atualizar(usuario);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Usuario buscar(Long id) {
        return dao.buscarPorId(id);
    }
}
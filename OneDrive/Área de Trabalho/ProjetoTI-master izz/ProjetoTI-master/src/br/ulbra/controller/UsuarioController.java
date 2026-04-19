package br.ulbra.controller;

import br.ulbra.dao.UsuarioDAOImpl;
import br.ulbra.model.Usuario;
import br.ulbra.service.UsuarioService;
import java.util.List;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController() {
        this.service = new UsuarioService(new UsuarioDAOImpl());
    }

    public String cadastrar(String nome, String cargo, String email, String senha) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setCargo(cargo);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            service.cadastrar(usuario);
            return "Usuário cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro ao cadastrar: " + e.getMessage();
        }
    }

    public List<Usuario> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String nome, String cargo, String email, String senha) {
        try {

            Usuario usuario = new Usuario(id, nome, cargo, email, senha);
            service.atualizar(usuario);
            return "Usuário atualizado com sucesso";

        } catch (Exception e) {
            return "Erro ao atualizar: " + e.getMessage();
        }
    }

    public String deletar(Long id) {
        try {
            service.deletar(id);
            return "Deletado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

}
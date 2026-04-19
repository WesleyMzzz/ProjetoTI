package br.ulbra.controller;

import br.ulbra.dao.EquipamentoDAOImpl;
import br.ulbra.model.Equipamento;
import br.ulbra.service.EquipamentoService;
import java.util.List;

public class EquipamentoController {

    private EquipamentoService service;

    public EquipamentoController() {
        this.service = new EquipamentoService(new EquipamentoDAOImpl());
    }

    public String cadastrar(String produtoTag, String tipo, String sala) {
        try {
            Equipamento equipamento = new Equipamento();
            equipamento.setProdutoTag(produtoTag);
            equipamento.setTipo(tipo);
            equipamento.setSala(sala);

            service.cadastrar(equipamento);
            return "Equipamento cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro ao cadastrar: " + e.getMessage();
        }
    }

    public List<Equipamento> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String produtoTag, String tipo, String sala) {
        try {

            Equipamento equipamento = new Equipamento(id, produtoTag, tipo, sala);
            service.atualizar(equipamento);
            return "Equipamento atualizado com sucesso";

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
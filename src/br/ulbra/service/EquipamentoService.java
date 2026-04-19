package br.ulbra.service;

import br.ulbra.dao.EquipamentoDAO;
import br.ulbra.model.Equipamento;
import java.util.List;

public class EquipamentoService {

    private EquipamentoDAO dao;

    public EquipamentoService(EquipamentoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Equipamento equipamento) {
        if (equipamento.getProdutoTag() == null || equipamento.getProdutoTag().trim().isEmpty()) {
            throw new IllegalArgumentException("A tag do produto não pode ser vazia!.");
        }
        dao.salvar(equipamento);
    }
    
    public List<Equipamento> listar() {
        return dao.listar();
    }

    public void atualizar(Equipamento equipamento) {
        dao.atualizar(equipamento);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Equipamento buscar(Long id) {
        return dao.buscarPorId(id);
    }
    

}
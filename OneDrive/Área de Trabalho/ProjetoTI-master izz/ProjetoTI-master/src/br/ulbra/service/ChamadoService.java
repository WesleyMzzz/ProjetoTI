package br.ulbra.service;

import br.ulbra.dao.ChamadoDAO;
import br.ulbra.model.Chamado;
import java.util.List;

public class ChamadoService {

    private ChamadoDAO dao;

    public ChamadoService(ChamadoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Chamado chamado) {

        if (chamado.getSolicitante() == null || chamado.getSolicitante().trim().isEmpty()) {
            throw new IllegalArgumentException("O solicitante é obrigatório.");
        }
        if (chamado.getSolicitante().length() > 100) {
            throw new IllegalArgumentException("O nome do solicitante não pode exceder 100 caracteres.");
        }

        if (chamado.getSala() != null && chamado.getSala().length() > 50) {
            throw new IllegalArgumentException("O campo sala não pode exceder 50 caracteres.");
        }

        if (chamado.getEquipamentoTag() != null && chamado.getEquipamentoTag().length() > 50) {
            throw new IllegalArgumentException("A tag do equipamento não pode exceder 50 caracteres.");
        }

        if (chamado.getProblemaRelatado() == null || chamado.getProblemaRelatado().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do problema é obrigatória.");
        }

        if (chamado.getPrioridade() != null && chamado.getPrioridade().length() > 20) {
            throw new IllegalArgumentException("O campo prioridade não pode exceder 20 caracteres.");
        }

        if (chamado.getStatus() != null && chamado.getStatus().length() > 20) {
            throw new IllegalArgumentException("O campo status não pode exceder 20 caracteres.");
        }

        if (chamado.getDataAbertura() == null) {
            throw new IllegalArgumentException("A data de abertura deve ser informada.");
        }

        dao.salvar(chamado);
    }

    public List<Chamado> listar() {
        return dao.listar();
    }

    public void atualizar(Chamado chamado) {
        dao.atualizar(chamado);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Chamado buscar(Long id) {
        return dao.buscarPorId(id);
    }

}

package br.ulbra.controller;

import br.ulbra.dao.ChamadoDAOImpl;
import br.ulbra.model.Chamado;
import br.ulbra.service.ChamadoService;
import java.util.Date;
import java.util.List;

public class ChamadoController {

    private ChamadoService service;

    public ChamadoController() {
        this.service = new ChamadoService(new ChamadoDAOImpl());
    }

    public String cadastrar(String solicitante, String sala, String equipamento_tag,
            String problema_relatado, String diagnostico_tecnico, String prioridade,
            String status, Date data_abertura) {
        try {
            Chamado chamado = new Chamado();
            chamado.setSolicitante(solicitante);
            chamado.setSala(sala);
            chamado.setEquipamentoTag(equipamento_tag);
            chamado.setProblemaRelatado(problema_relatado);
            chamado.setDiagnosticoTecnico(diagnostico_tecnico);
            chamado.setPrioridade(prioridade);
            chamado.setStatus(status);
            chamado.setDataAbertura(data_abertura);

            service.cadastrar(chamado);
            return "Chamado cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Chamado> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String solicitante, String sala, String equipamento_tag,
            String problema_relatado, String diagnostico_tecnico, String prioridade,
            String status, Date data_abertura) {
        try {
            Chamado chamado = new Chamado(id, solicitante, sala, equipamento_tag,
                    problema_relatado, diagnostico_tecnico, prioridade,
                    status, data_abertura);
            service.atualizar(chamado);
            return "Atualizado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
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

    public String cadastrar(String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package br.ulbra.dao;

import br.ulbra.model.Chamado;
import java.util.List;

public interface ChamadoDAO {

    void salvar(Chamado chamado);

    List<Chamado> listar();

    Chamado buscarPorId(Long id);

    void atualizar(Chamado chamado);

    void deletar(Long id);
}

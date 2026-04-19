package br.ulbra.dao;

import br.ulbra.model.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAOImpl implements EquipamentoDAO {

    public void salvar(Equipamento equipamento) {
        String sql = "INSERT INTO equipamento (produto_tag, tipo, sala) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getProdutoTag());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getSala());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Equipamento> listar() {
        String sql = "SELECT * FROM equipamento";
        List<Equipamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipamento u = new Equipamento(
                        rs.getLong("id"),
                        rs.getString("produto_tag"),
                        rs.getString("tipo"),
                        rs.getString("sala")
                );
                lista.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Equipamento buscarPorId(Long id) {
        String sql = "SELECT * FROM equipamento WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Equipamento(
                        rs.getLong("id"),
                        rs.getString("produto_tag"),
                        rs.getString("tipo"),
                        rs.getString("sala")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Equipamento equipamento) {
        String sql = "UPDATE equipamento SET produto_tag = ?, tipo = ?, sala = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getProdutoTag());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getSala());
            stmt.setLong(4, equipamento.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM equipamento WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
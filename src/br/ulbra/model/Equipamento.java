package br.ulbra.model;

public class Equipamento {

    private Long id;
    private String produtoTag;
    private String tipo;
    private String sala;

    public Equipamento() {
    }

    public Equipamento(Long id, String produtoTag, String tipo, String sala) {
        this.id = id;
        this.produtoTag = produtoTag;
        this.tipo = tipo;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdutoTag() {
        return produtoTag;
    }

    public void setProdutoTag(String produtoTag) {
        this.produtoTag = produtoTag;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Equipamento{" + "id=" + id + ", produtoTag=" + produtoTag + ", tipo=" + tipo + ", sala=" + sala + '}';
    }

}
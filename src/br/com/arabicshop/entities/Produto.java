package br.com.arabicshop.entities;

public class Produto {

    private String descricaoProduto;
    private double valorProduto;

    public Produto(String descricaoProduto, double valorProduto) {
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    @Override
    public String toString() {
        return getDescricaoProduto() + String.format(" - R$ %.2f", getValorProduto());
    }
}

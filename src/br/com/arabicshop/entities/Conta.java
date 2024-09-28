package br.com.arabicshop.entities;

public class Conta {
    private double cartaoDeCredito;

    public Conta(double cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }

    public double getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public void compras(double valorProduto) {
        this.cartaoDeCredito -= valorProduto;
    }
}

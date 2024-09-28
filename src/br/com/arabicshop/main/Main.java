package br.com.arabicshop.main;

import br.com.arabicshop.entities.Conta;
import br.com.arabicshop.entities.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Bem-vindo ao ArabicShop! *****\n");

        System.out.print("Digite o limite do cartão R$ ");
        double limiteCartaoDeCredito = sc.nextDouble();
        sc.nextLine();
        Conta conta = new Conta(limiteCartaoDeCredito);
        List<Produto> listaDeProdutos = new ArrayList<>();
        System.out.println();

        int opcao = 0;
        while (opcao != 2) {
            System.out.print("Digite a descrição do produto: ");
            String descricaoProduto = sc.nextLine();
            System.out.print("Digite o valor da compra R$ ");
            double valorProduto = sc.nextDouble();

            if (valorProduto <= conta.getCartaoDeCredito()) {
                Produto produto = new Produto(descricaoProduto, valorProduto);
                listaDeProdutos.add(produto);
                System.out.println("\nCompra realizada com sucesso!\n");
                conta.compras(valorProduto);
                System.out.printf("Saldo atual: R$ %.2f\n", conta.getCartaoDeCredito());
            } else {
                System.out.println("\nSaldo insuficiente!\n");
                break;
            }
            System.out.print("Digite 1 para continuar ou 2 para finalizar: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println();
        }
        sc.close();

        if (!listaDeProdutos.isEmpty()) {
            listaDeProdutos.sort(Comparator.comparingDouble(Produto::getValorProduto));
            System.out.println("********************");
            System.out.println("Compras realizadas:\n");
            for (Produto produto : listaDeProdutos) {
                System.out.println(produto);
            }
            System.out.println("********************\n");
            System.out.printf("Saldo do cartão: R$ %.2f" , conta.getCartaoDeCredito());
        } else {
            System.out.println("Nenhuma compra foi realizada.\n");
            System.out.printf("Saldo do cartão: R$ %.2f" , conta.getCartaoDeCredito());
        }
    }
}
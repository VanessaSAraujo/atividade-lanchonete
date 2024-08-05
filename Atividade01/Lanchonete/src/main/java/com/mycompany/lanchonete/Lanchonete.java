package com.mycompany.lanchonete;

import javax.swing.SwingUtilities;

public class Lanchonete {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CadastroDeProduto cadastroProduto = new CadastroDeProduto();
                BuscarProduto produtoManager = new BuscarProduto(cadastroProduto);
                new Funcoes(cadastroProduto, produtoManager);
            }
        });
    }
}

package com.mycompany.lanchonete;

import java.util.Map;

public class BuscarProduto {
    private CadastroDeProduto cadastroDeProduto;

    public BuscarProduto(CadastroDeProduto cadastroDeProduto) {
        this.cadastroDeProduto = cadastroDeProduto;
    }
    
    public Produto buscarProduto(int codigo) {
        Map<Integer, Produto> produtos = cadastroDeProduto.getProdutos();
        return produtos.get(codigo);
    }
}

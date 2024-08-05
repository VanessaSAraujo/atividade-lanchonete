package com.mycompany.lanchonete;

import java.util.HashMap;
import java.util.Map;

public class CadastroDeProduto {
    private Map<Integer, Produto> produtos;
    
    public CadastroDeProduto() {
        this.produtos = new HashMap<>();
    }
    
    public boolean adicionar(int codigo, String nome, double preco, String imagem) {
        if (produtos.containsKey(codigo)) {
            return false;
        }
        Produto produto = new Produto(codigo, nome, preco, imagem);
        produtos.put(codigo, produto);
        return true;
    }
  
    public Map<Integer, Produto> getProdutos() {
        return produtos;
    }
}

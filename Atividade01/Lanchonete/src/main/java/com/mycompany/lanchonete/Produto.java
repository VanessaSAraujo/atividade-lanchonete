package com.mycompany.lanchonete;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private String imagem;

    public Produto(int codigo, String nome, double preco, String imagem) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.imagem = imagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }
    
    
}

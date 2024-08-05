package com.mycompany.lanchonete;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Funcoes {
    private CadastroDeProduto cadastroDeProduto;
    private BuscarProduto buscarProduto;

    public Funcoes(CadastroDeProduto cadastroDeProduto, BuscarProduto buscarProduto) {
        this.cadastroDeProduto = cadastroDeProduto;
        this.buscarProduto = new BuscarProduto(cadastroDeProduto);
        menuPrincipal();
    }
    
    private void menuPrincipal() {
        String[] options = {"Cadastrar Produto", 
            "Calcular Conta", 
            "Sair"};
        
        while(true) {
            int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            switch (escolha) {
                case 0:
                    cadastrarProduto();
                    break;
                case 1:
                    calcularConta();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
            
        }
    }
    
    private void cadastrarProduto() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do Produto:"));
            String nome = JOptionPane.showInputDialog("Nome do Produto:");
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do Produto:"));
            String caminhoImagem = JOptionPane.showInputDialog("Caminho da Imagem:");

            boolean adicionado = cadastroDeProduto.adicionar(codigo, nome, preco, caminhoImagem);
            if (adicionado) {
                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Código do produto já existe. Tente novamente com outro código.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, verifique os campos.");
        }
    }
    
    private void calcularConta() {
        double total = 0.00;
        
        while(true) {
            try {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do Produto:"));
                Produto produto = buscarProduto.buscarProduto(codigo);

                if (produto != null) {
                    String nomeProduto = produto.getNome();
                    ImageIcon imagemIcon = new ImageIcon(produto.getImagem());
                    JLabel imagemLabel = new JLabel(imagemIcon);
                    JOptionPane.showMessageDialog(null, imagemLabel, nomeProduto, JOptionPane.PLAIN_MESSAGE);

                    int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
                    total += produto.getPreco() * quantidade;
                } else {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                }

                String[] options = {"Continuar", "Finalizar"};
                int escolha = JOptionPane.showOptionDialog(null, "Deseja continuar ou finalizar?", "Opções",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (escolha == 1) {
                    JOptionPane.showMessageDialog(null, String.format("Total: R$ %.2f", total));
                    break;
                }
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, tente novamente.");
          }   
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import model.Residuo;

/**
 *
 * @Sophia_Lyandra
 */
public class TelaCadastroResiduos extends JFrame {
       public TelaCadastroResiduos() {
        // Configurações principais da janela
        setTitle("Cadastro de Resíduos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Painel de fundo com cor e imagem decorativa
        JPanel painelFundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carregando a imagem de fundo
                Image background = new ImageIcon("https://i.pinimg.com/736x/03/c0/4a/03c04aa0aa468fcdba47bb6b255c1b4a.jpg").getImage();
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        painelFundo.setLayout(null);
        setContentPane(painelFundo);

        // Título principal
        JLabel lblTitulo = new JLabel("Cadastro de Resíduos");
        lblTitulo.setBounds(250, 20, 300, 30);
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(34, 139, 34));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelFundo.add(lblTitulo);

        // Campos do formulário
        JLabel lblTipo = new JLabel("Tipo de Resíduo:");
        lblTipo.setBounds(200, 80, 150, 20);
        lblTipo.setFont(new Font("Arial", Font.PLAIN, 16));
        painelFundo.add(lblTipo);

        JTextField txtTipo = new JTextField();
        txtTipo.setBounds(350, 80, 250, 30);
        painelFundo.add(txtTipo);

        JLabel lblQuantidade = new JLabel("Quantidade (kg):");
        lblQuantidade.setBounds(200, 130, 150, 20);
        lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 16));
        painelFundo.add(lblQuantidade);

        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setBounds(350, 130, 250, 30);
        painelFundo.add(txtQuantidade);

        JLabel lblOrigem = new JLabel("Origem:");
        lblOrigem.setBounds(200, 180, 150, 20);
        lblOrigem.setFont(new Font("Arial", Font.PLAIN, 16));
        painelFundo.add(lblOrigem);

        JTextField txtOrigem = new JTextField();
        txtOrigem.setBounds(350, 180, 250, 30);
        painelFundo.add(txtOrigem);

        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBounds(200, 230, 150, 20);
        lblDestino.setFont(new Font("Arial", Font.PLAIN, 16));
        painelFundo.add(lblDestino);

        JTextField txtDestino = new JTextField();
        txtDestino.setBounds(350, 230, 250, 30);
        painelFundo.add(txtDestino);

        JLabel lblPeriodo = new JLabel("Período:");
        lblPeriodo.setBounds(200, 280, 150, 20);
        lblPeriodo.setFont(new Font("Arial", Font.PLAIN, 16));
        painelFundo.add(lblPeriodo);

        JTextField txtPeriodo = new JTextField();
        txtPeriodo.setBounds(350, 280, 250, 30);
        painelFundo.add(txtPeriodo);

        // Botões de "Voltar" e "Cadastrar"
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(200, 350, 120, 40);
        btnVoltar.setBackground(new Color(220, 20, 60));
        btnVoltar.setForeground(Color.WHITE);

        // Adiciona o evento de clique no botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a tela de login
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);

                // Fecha a tela atual
                dispose();
            }
        });

        painelFundo.add(btnVoltar);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(480, 350, 120, 40);
        btnCadastrar.setBackground(new Color(34, 139, 34));
        btnCadastrar.setForeground(Color.WHITE);
        painelFundo.add(btnCadastrar);
        
         // Adiciona o evento de clique no botão "Cadastrar"
         btnCadastrar.addActionListener(e -> {
    String tipo = txtTipo.getText();
    double quantidade = Double.parseDouble(txtQuantidade.getText());
    String origem = txtOrigem.getText();
    String destino = txtDestino.getText();

    Residuo.cadastrarResiduo(tipo, quantidade, origem, destino);
    JOptionPane.showMessageDialog(this, "Resíduo cadastrado com sucesso!");
});


        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de cadastro de resíduos
                TelaIndicadoresAmbientais telaIndicadores = new TelaIndicadoresAmbientais();
                telaIndicadores.setVisible(true);

                // Fecha a tela de login
                dispose();
            }
        });

        // Tabela para resíduos cadastrados
        JLabel lblTabelaTitulo = new JLabel("Resíduos Cadastrados");
        lblTabelaTitulo.setBounds(300, 410, 200, 20);
        lblTabelaTitulo.setFont(new Font("Serif", Font.BOLD, 18));
        lblTabelaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTabelaTitulo.setForeground(new Color(34, 139, 34));
        painelFundo.add(lblTabelaTitulo);

        String[] colunas = {"Tipo de Resíduo", "Quantidade", "Origem", "Destino", "Data"};
        Object[][] dados = {}; // Inicialmente vazio
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(150, 440, 500, 100);
        painelFundo.add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastroResiduos telaCadastro = new TelaCadastroResiduos();
            telaCadastro.setVisible(true);
        });
    }
}


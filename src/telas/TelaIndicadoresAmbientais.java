/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import telas.TelaCadastroResiduos;
import telas.TelaRelatorio;


/**
 *
 * @Sophia_Lyandra
 */
public class TelaIndicadoresAmbientais extends JFrame {
   public TelaIndicadoresAmbientais() {
        // Configurações principais da janela
        setTitle("Indicadores Ambientais");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Painel de fundo com imagem decorativa
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

        // Painel centralizado para os campos e botões
        JPanel painelCentral = new JPanel();
        painelCentral.setBounds(150, 100, 500, 400);
        painelCentral.setBackground(new Color(255, 255, 255, 230)); // Fundo branco semi-transparente
        painelCentral.setLayout(null);
        painelFundo.add(painelCentral);

        // Título
        JLabel lblTitulo = new JLabel("Indicadores Ambientais");
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(34, 139, 34));
        lblTitulo.setBounds(100, 20, 300, 30);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelCentral.add(lblTitulo);

        // Filtro: Período
        JLabel lblFiltroPeriodo = new JLabel("Filtro:");
        lblFiltroPeriodo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblFiltroPeriodo.setBounds(50, 80, 80, 20);
        painelCentral.add(lblFiltroPeriodo);

        JButton btnPeriodo = new JButton("Período →");
        btnPeriodo.setBounds(120, 80, 120, 25);
        painelCentral.add(btnPeriodo);

        // Filtro: Tipo
        JButton btnTipo = new JButton("Tipo →");
        btnTipo.setBounds(260, 80, 120, 25);
        painelCentral.add(btnTipo);

        // Campo de Consumo de Água
        JLabel lblConsumoAgua = new JLabel("Consumo de Água:");
        lblConsumoAgua.setFont(new Font("Arial", Font.PLAIN, 16));
        lblConsumoAgua.setBounds(50, 130, 200, 20);
        painelCentral.add(lblConsumoAgua);

        JTextField txtConsumoAgua = new JTextField("ex.: 70%");
        txtConsumoAgua.setBounds(260, 130, 150, 30);
        painelCentral.add(txtConsumoAgua);

        // Campo de Emissão de CO2
        JLabel lblEmissaoCO2 = new JLabel("Emissão de CO2:");
        lblEmissaoCO2.setFont(new Font("Arial", Font.PLAIN, 16));
        lblEmissaoCO2.setBounds(50, 180, 200, 20);
        painelCentral.add(lblEmissaoCO2);

        JTextField txtEmissaoCO2 = new JTextField("ex.: 50%");
        txtEmissaoCO2.setBounds(260, 180, 150, 30);
        painelCentral.add(txtEmissaoCO2);

        // Botão "Voltar"
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(100, 300, 120, 40);
        btnVoltar.setBackground(new Color(220, 20, 60));
        btnVoltar.setForeground(Color.WHITE);
        painelCentral.add(btnVoltar);

        // Botão "Cadastrar"
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(280, 300, 120, 40);
        btnCadastrar.setBackground(new Color(34, 139, 34));
        btnCadastrar.setForeground(Color.WHITE);
        painelCentral.add(btnCadastrar);
        
        // Adiciona o evento de clique no botão "Cadastrar"
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de cadastro de resíduos
                TelaRelatorio telaRelatorio = new TelaRelatorio();
                telaRelatorio.setVisible(true);

                // Fecha a tela de login
                dispose();
            }
        });

        // Eventos para botões
        btnVoltar.addActionListener(e -> {
            TelaCadastroResiduos telaCadastro = new TelaCadastroResiduos();
            telaCadastro.setVisible(true);
            dispose();
        });

        btnCadastrar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Indicadores cadastrados com sucesso!");
        });

        btnPeriodo.addActionListener(e -> abrirDialogoPeriodo());
        btnTipo.addActionListener(e -> abrirDialogoTipo());
    }

    private void abrirDialogoPeriodo() {
        // Janela de seleção para Período
        String[] periodos = {"Última Semana", "Último Mês", "Último Ano"};
        String selecionado = (String) JOptionPane.showInputDialog(
                this,
                "Selecione o período:",
                "Filtro - Período",
                JOptionPane.QUESTION_MESSAGE,
                null,
                periodos,
                periodos[0]
        );

        if (selecionado != null) {
            JOptionPane.showMessageDialog(this, "Período selecionado: " + selecionado);
        }
    }

    private void abrirDialogoTipo() {
        // Janela de seleção para Tipo
        String[] tipos = {"Consumo de Água", "Emissão de CO2", "Resíduos Sólidos"};
        String selecionado = (String) JOptionPane.showInputDialog(
                this,
                "Selecione o tipo:",
                "Filtro - Tipo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]
        );

        if (selecionado != null) {
            JOptionPane.showMessageDialog(this, "Tipo selecionado: " + selecionado);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaIndicadoresAmbientais tela = new TelaIndicadoresAmbientais();
            tela.setVisible(true);
        });
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author lirie
 */
public class TelaRelatorio extends JFrame{
    public TelaRelatorio() {
        // Configuração da janela
        setTitle("Relatório");
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

        // Painel centralizado
        JPanel painelCentral = new JPanel();
        painelCentral.setBounds(100, 50, 600, 500);
        painelCentral.setBackground(new Color(255, 255, 255, 230)); // Fundo branco semi-transparente
        painelCentral.setLayout(null);
        painelFundo.add(painelCentral);

        // Título
        JLabel lblTitulo = new JLabel("Relatório");
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(34, 139, 34));
        lblTitulo.setBounds(200, 10, 200, 30);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelCentral.add(lblTitulo);

        // Subtítulo
        JLabel lblSubtitulo = new JLabel("Relatório: Resumo Mensal");
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSubtitulo.setBounds(50, 50, 300, 20);
        painelCentral.add(lblSubtitulo);

        JLabel lblPeriodo = new JLabel("Período: ex... Janeiro 2025");
        lblPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPeriodo.setBounds(50, 80, 300, 20);
        painelCentral.add(lblPeriodo);

        // Tabela de Resíduos
        JLabel lblResiduos = new JLabel("Resíduos:");
        lblResiduos.setFont(new Font("Arial", Font.BOLD, 16));
        lblResiduos.setBounds(50, 120, 300, 20);
        painelCentral.add(lblResiduos);

        String[] colunasResiduos = {"Tipo", "Quan.", "Destino"};
        DefaultTableModel modeloResiduos = new DefaultTableModel(colunasResiduos, 0);
        JTable tabelaResiduos = new JTable(modeloResiduos);
        JScrollPane scrollResiduos = new JScrollPane(tabelaResiduos);
        scrollResiduos.setBounds(50, 150, 500, 100);
        painelCentral.add(scrollResiduos);

        // Adicionando dados fictícios na tabela de resíduos
        modeloResiduos.addRow(new Object[]{"Plástico", "50kg", "Reciclagem"});
        modeloResiduos.addRow(new Object[]{"Vidro", "30kg", "Reciclagem"});

        // Tabela de Indicadores
        JLabel lblIndicadores = new JLabel("Indicadores:");
        lblIndicadores.setFont(new Font("Arial", Font.BOLD, 16));
        lblIndicadores.setBounds(50, 270, 300, 20);
        painelCentral.add(lblIndicadores);

        String[] colunasIndicadores = {"Indicador", "Meta", "Valor"};
        DefaultTableModel modeloIndicadores = new DefaultTableModel(colunasIndicadores, 0);
        JTable tabelaIndicadores = new JTable(modeloIndicadores);
        JScrollPane scrollIndicadores = new JScrollPane(tabelaIndicadores);
        scrollIndicadores.setBounds(50, 300, 500, 100);
        painelCentral.add(scrollIndicadores);

        // Adicionando dados fictícios na tabela de indicadores
        modeloIndicadores.addRow(new Object[]{"Consumo de Água", "70%", "65%"});
        modeloIndicadores.addRow(new Object[]{"Emissão de CO2", "50%", "45%"});

        // Botões
        JButton btnGerarRelatorio = new JButton("Gerar Relatório");
        btnGerarRelatorio.setBounds(150, 430, 150, 40);
        btnGerarRelatorio.setBackground(new Color(34, 139, 34));
        btnGerarRelatorio.setForeground(Color.WHITE);
        painelCentral.add(btnGerarRelatorio);

        JButton btnExportarPDF = new JButton("Exportar PDF");
        btnExportarPDF.setBounds(320, 430, 150, 40);
        btnExportarPDF.setBackground(new Color(0, 128, 255));
        btnExportarPDF.setForeground(Color.WHITE);
        painelCentral.add(btnExportarPDF);

        // Eventos dos Botões
        btnGerarRelatorio.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso!");
        });

        btnExportarPDF.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Exportação para PDF ainda não implementada.");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaRelatorio tela = new TelaRelatorio();
            tela.setVisible(true);
        });
    }
}


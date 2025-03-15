/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import telas.TelaCadastroResiduos;

/**
 *
 * @Sophia_Lyandra
 */
public class TelaLogin extends JFrame {

    private JTextField txtUsuario; // Ajuste para a variável txtUsuario
    private JPasswordField txtSenha; // Ajuste para a variável txtSenha
  
      public TelaLogin() {
        // Configurações principais da janela
        setTitle("Sistema Ambiental - Login");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Painel para a imagem decorativa
        JPanel painelImagem = new JPanel();
        painelImagem.setBounds(0, 0, 400, 600);
        painelImagem.setBackground(new Color(220, 240, 220));

        // Adicionando imagem decorativa
        JLabel lblImagem = new JLabel(new ImageIcon("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.toledo.pr.gov.br%2Fmunicipio%2Fconselhos_municipais&psig=AOvVaw3hHUL2cSuwPeYfX3Df-dNY&ust=1737482016171000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCKiVlZTvhIsDFQAAAAAdAAAAABAJ"));
        painelImagem.add(lblImagem);
        add(painelImagem);

        // Painel para o formulário
        JPanel painelFormulario = new JPanel();
        painelFormulario.setBounds(400, 0, 400, 600);
        painelFormulario.setBackground(Color.WHITE);
        painelFormulario.setLayout(null);

        // Título do sistema
        JLabel lblTitulo = new JLabel("Sistema Ambiental");
        lblTitulo.setBounds(80, 50, 300, 30);
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(34, 139, 34));
        painelFormulario.add(lblTitulo);

        // Campo de email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 150, 300, 20);
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        painelFormulario.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(50, 180, 300, 30);
        painelFormulario.add(txtEmail);

        // Campo de senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 230, 300, 20);
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 16));
        painelFormulario.add(lblSenha);

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(50, 260, 300, 30);
        painelFormulario.add(txtSenha);

        // Checkbox "Lembrar senha"
        JCheckBox chkLembrar = new JCheckBox("Lembrar senha");
        chkLembrar.setBounds(50, 310, 150, 20);
        painelFormulario.add(chkLembrar);

        // Botão de entrar
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(50, 350, 300, 40);
        btnEntrar.setBackground(new Color(34, 139, 34));
        btnEntrar.setForeground(Color.WHITE);

        // Adiciona o evento de clique no botão "Entrar"
        btnEntrar.addActionListener(e -> {
    Usuario usuario = new Usuario(txtUsuario.getText(), new String(txtSenha.getPassword()));
    if (usuario.autenticar()) {
        JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
        new TelaCadastroResiduos().setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!");
    }
});
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de cadastro de resíduos
                TelaCadastroResiduos telaCadastro = new TelaCadastroResiduos();
                telaCadastro.setVisible(true);

                // Fecha a tela de login
                dispose();
            }
        });
        
        painelFormulario.add(btnEntrar);

        // Link para criar conta ou recuperar senha
        JLabel lblCriarConta = new JLabel("<html><u>Esqueceu a senha? Criar conta</u></html>");
        lblCriarConta.setBounds(50, 410, 300, 20);
        lblCriarConta.setForeground(Color.BLUE);
        lblCriarConta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        painelFormulario.add(lblCriarConta);

        // Adiciona o painel de formulário à janela
        add(painelFormulario);
    }
      

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
          
        });
    }
}

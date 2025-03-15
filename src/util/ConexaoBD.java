/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * Sophia_Lyandra
 */
public class ConexaoBD {
    
    public ConexaoBD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Connection getConnection(){
        try{
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sistema_ambiental", "root", "messa58");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao conectar");
            return null;
        }
    }     
}

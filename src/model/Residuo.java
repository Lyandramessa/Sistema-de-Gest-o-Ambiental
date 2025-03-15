/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @Sophia_Lyandra
 */
public class Residuo {

    private static Object con;
    private final int id;
    private final String tipo;
    private final int quantidade;
    private final String origem;
    private final String destino;
    private final Date dataRegistro;
    

    public Residuo(int id, String tipo, int quantidade, String origem, String destino, Date dataRegistro) {
        this.id = id;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.origem = origem;
        this.destino = destino;
        this.dataRegistro = dataRegistro;
    }

    public Residuo(String tipo, double quantidade, String origem, String destino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   public static void cadastrarResiduo(String tipo, double quantidade, String origem, String destino) {
    String sql = "INSERT INTO residuo (tipo, quantidade, origem, destino) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, tipo);
        stmt.setDouble(2, quantidade);
        stmt.setString(3, origem);
        stmt.setString(4, destino);
        stmt.executeUpdate();
    } catch (SQLException e) {
    }
}

public static List<Residuo> consultarResiduos() {
    List<Residuo> residuo = new ArrayList<>();
    String sql = "SELECT * FROM residuo";
    try (PreparedStatement stmt = con.prepareStatement(sql);
         var rs = stmt.executeQuery()) {
        while (rs.next()) {
            residuo.add(new Residuo(
                rs.getString("tipo"),
                rs.getDouble("quantidade"),
                rs.getString("origem"),
                rs.getString("destino")
            ));
        }
    } catch (SQLException e) {
    }
    return residuo;

   }
}
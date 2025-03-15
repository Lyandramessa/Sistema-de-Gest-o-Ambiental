/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @Sophia_Lyandra
 */
public class Indicadorambiental {
    private final int id;
    private final String tipo;
    private final double valor;
    private final Date dataRegistro;
    private final double meta;

    public Indicadorambiental(int id, String tipo, double valor, Date dataRegistro, double meta) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
        this.meta = meta;
    }

    public void registrarIndicador() {
        System.out.println("Indicador registrado: " + tipo + " - Valor: " + valor);
    }
}

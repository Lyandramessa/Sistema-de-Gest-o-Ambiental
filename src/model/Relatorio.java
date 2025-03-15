/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @Sophia_Lyandra
 */
public class Relatorio {
    private final int id;
    private final String tipo;
    private final String periodo;
    private final String dados;

    public Relatorio(int id, String tipo, String periodo, String dados) {
        this.id = id;
        this.tipo = tipo;
        this.periodo = periodo;
        this.dados = dados;
    }

    public void gerarRelatorio() {
        System.out.println("Relatório gerado: " + tipo + " - Período: " + periodo);
    }
}

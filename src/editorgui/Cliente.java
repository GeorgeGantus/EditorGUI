/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;

/**
 *
 * @author georg
 */
public class Cliente {
    private EditorGUI gui;
    private String nomeUsuario;
    private String nomeArquivo;

    public EditorGUI getGui() {
        return gui;
    }

    public void setGui(EditorGUI gui) {
        this.gui = gui;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
}

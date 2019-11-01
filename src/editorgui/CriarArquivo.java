/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author georg
 */
public class CriarArquivo implements Runnable{
    String nome;
    @Override
    public void run() {
        try {
            File arquivo = new File(nome);
            arquivo.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possivel criar o arquivo");
            
        }
    }
    public CriarArquivo(String nome) {
        this.nome = nome;
    }
    
}

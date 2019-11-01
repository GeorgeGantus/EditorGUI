/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;

import java.awt.TextArea;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author georg
 */
public class AbrirArquivo implements Runnable{
    ArrayList<EditorGUI> logins;
    Cliente c;
    public AbrirArquivo(Cliente c, ArrayList<EditorGUI> logins) {
        this.c = c;
        this.logins = logins;
    }
    
    
    @Override
    public void run() {
        System.out.println("TESTE ABRIR");
//        FileReader inputStream;
        try (FileReader inputStream = new FileReader(this.c.getNomeArquivo())){
//            inputStream = new FileReader(nomeArquivo);
            int c;
            StringBuilder sb = new StringBuilder();
            while((c = inputStream.read()) != -1){
                sb.append(Character.toChars(c));
            }
            this.c.getGui().getTexto().setText(sb.toString());
            this.c.getGui().setArquivoAberto(this.c.getNomeArquivo());
            logins.add(this.c.getGui());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"nao foi possivel acessar esse arquivo");
        } catch (IOException ex) {
            Logger.getLogger(AbrirArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

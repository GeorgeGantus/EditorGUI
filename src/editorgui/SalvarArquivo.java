/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author georg
 */
public class SalvarArquivo implements Runnable{
    Cliente cliente;
    ArrayList<EditorGUI> logins;
    public SalvarArquivo(Cliente cliente) {
        this.cliente = cliente;
        logins = logins;
    }
    
    @Override
    public void run() {
       
        try( FileWriter outputStream = new FileWriter(cliente.getNomeArquivo())){
                
            outputStream.write(cliente.getGui().getTexto().getText());
            logins.add(cliente.getGui());
        } catch (IOException ex) {
            Logger.getLogger(SalvarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

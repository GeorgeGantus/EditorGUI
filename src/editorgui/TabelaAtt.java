/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;

import java.util.ArrayList;

/**
 *
 * @author georg
 */
public class TabelaAtt implements Runnable{
    
    private ArrayList<EditorGUI> logins;
    private GUIServidor servidor;
    private TabelaModel tblModel;
    public TabelaAtt(ArrayList<EditorGUI> logins, GUIServidor servidor) {
        this.logins = logins;
        this.servidor = servidor;
    }
    
    public void run() {

    }
    
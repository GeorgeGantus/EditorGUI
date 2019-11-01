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
public class Editor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorThread servidor = new ServidorThread();
        Thread thread = new Thread(servidor);
        new GUIServidor(thread,servidor);
        new EditorGUI(servidor);
    }
}

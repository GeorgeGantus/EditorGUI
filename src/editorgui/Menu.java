/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Victor
 */
public class Menu extends JMenuBar{
    JMenu arquivo;
    JMenu ferramentas;
    JMenuItem new_file;
    JMenuItem open_file;
    JMenuItem save_file;
    JMenuItem desfazer;
    JMenuItem refazer;
    JMenuItem copiar;
    JMenuItem colar;
    JMenuItem recortar;
    public Menu(){
        arquivo = new JMenu("Arquivo");
        ferramentas = new JMenu("Ferramentas");
        new_file = new JMenuItem("Novo");
        open_file = new JMenuItem("Abrir");
        save_file = new JMenuItem("Salvar");
        desfazer = new JMenuItem();
        refazer = new JMenuItem();
        copiar = new JMenuItem("Copiar");
        colar = new JMenuItem("Colar");
        recortar = new JMenuItem("Recortar");
        new_file.setAccelerator(KeyStroke.getKeyStroke('N',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        open_file.setAccelerator(KeyStroke.getKeyStroke('O',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        save_file.setAccelerator(KeyStroke.getKeyStroke('S',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        desfazer.setAccelerator(KeyStroke.getKeyStroke('Z',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        refazer.setAccelerator(KeyStroke.getKeyStroke('Y',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        copiar.setAccelerator(KeyStroke.getKeyStroke('C',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        colar.setAccelerator(KeyStroke.getKeyStroke('V',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        recortar.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        arquivo.add(new_file);
        arquivo.add(open_file);
        arquivo.add(save_file);
        ferramentas.add(desfazer);
        ferramentas.add(refazer);
        ferramentas.add(copiar);
        ferramentas.add(colar);
        ferramentas.add(recortar);
        this.add(arquivo);
        this.add(ferramentas);
    }
    
    
}

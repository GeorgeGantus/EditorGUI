/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Victor
 */
public class EditorGUI extends JFrame {

    private ServidorThread server;
    private JScrollPane area_texto;
    private JPanel area_menu;
    private JTextArea texto;
    private Menu menu;
    private UndoManager acao;
    private Clipboard clipboard;
    private String arquivoAberto = "Novo Arquivo";

    public EditorGUI(ServidorThread t) {
        super("Editor de Texto");
        this.server = t;
        texto = new JTextArea();
        area_texto = new JScrollPane(this.texto);
        menu = new Menu();
        area_menu = new JPanel(new GridLayout());
        acao = new UndoManager();
        area_menu.add(menu);
        texto.setEditable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().add(area_menu, BorderLayout.NORTH);
        this.getContentPane().add(area_texto, BorderLayout.CENTER);
        this.setVisible(true);
        this.setSize(800, 800);
        menu.new_file.addActionListener((ActionEvent ae) -> {
            new EditorGUI(server);
        });
        menu.open_file.addActionListener((ActionEvent ae) -> {
            server.getClienteOperacao().setGui(this);
            server.getClienteOperacao().setNomeUsuario("User");
            server.getClienteOperacao().setNomeArquivo("teste.txt");
            server.setOperacao(1);
            //JOptionPane.showMessageDialog(null,"SERVIDOR EM CONSTRUÇÃO");
        });
        menu.save_file.addActionListener((ActionEvent ae) -> {
            server.getClienteOperacao().setGui(this);
            server.getClienteOperacao().setNomeUsuario("User");
            server.getClienteOperacao().setNomeArquivo(arquivoAberto);
            server.setOperacao(3);
        });
        menu.desfazer.addActionListener((ActionEvent ae) -> {
            try {
                acao.undo();
            } catch (CannotUndoException a) {
            }
        });
        menu.refazer.addActionListener((ActionEvent ae) -> {
            try {
                acao.redo();
            } catch (CannotUndoException a) {
            }
        });
        texto.getDocument().addUndoableEditListener((UndoableEditEvent e) -> {
            acao.addEdit(e.getEdit());
            updateButtons();
        });
    }

    public void updateButtons() {
        menu.desfazer.setText(acao.getUndoPresentationName());
        menu.refazer.setText(acao.getRedoPresentationName());
        menu.desfazer.setEnabled(acao.canUndo());

    }

    public JTextArea getTexto() {
        return texto;
    }

    public void setTexto(JTextArea texto) {
        this.texto = texto;
    }

    public String getArquivoAberto() {
        return arquivoAberto;
    }

    public void setArquivoAberto(String arquivoAberto) {
        this.arquivoAberto = arquivoAberto;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author georg
 */
public class TabelaModel extends AbstractTableModel{
    
    private static final int USUARIO = 0;
    private static final int ARQUIVO = 1;
    private final List<EditorGUI> linhas = new ArrayList<EditorGUI>();
    private final String[] colunas = {"Usuario","Arquivo"};
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EditorGUI  elem = linhas.get(rowIndex);
        switch (columnIndex) {
            case USUARIO:
                return "User";
            case ARQUIVO:
                return elem.getArquivoAberto();
            default:
                return "";
        }
    }
    public EditorGUI getGUI(int rowIndex){
        EditorGUI  elem = linhas.get(rowIndex);
        return elem;
        
    }
    public void addElem(EditorGUI edGui){
        linhas.add(edGui);
    }
}

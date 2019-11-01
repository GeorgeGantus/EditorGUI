/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author georg
 */
public class ServidorThread implements Runnable {

    private int operacao = 0;//Simula qual a requisição esta sendo feita
    private Cliente clienteOperacao = new Cliente();//Simula os Dados recebidos a respeito de qual cliente esta realizando a requisição
    private Runnable operador;
    private Thread acao;
    private ArrayList<EditorGUI> logins;
    private GUIServidor guisv;
    
    /*Operaçoes feitas pelo servidor
    1- Abrir arquivo
    2- Criar Arquivo
    Thre
    3- Salvar Arquivo
     */    
    @Override
    public void run() {
        System.out.println("Thread rodando ->" + Thread.currentThread().getId());
        while (true) {

            switch (operacao) {
                case 1:
                    operacao = 0;
                    operador = new AbrirArquivo(clienteOperacao,logins);
                    acao = new Thread(operador);
                    acao.start();
                    break;
                case 2:
                    operacao = 0;
                    operador = new CriarArquivo("teste.txt");
                    acao = new Thread(operador);
                    acao.start();
                    break;
                case 3:
                    operacao = 0;
                    operador = new SalvarArquivo(clienteOperacao);
                    acao=new Thread(operador);
                    acao.start();
                    break;
                case 4:
                    operacao = 0;
                    clienteOperacao.getGui().dispose();
                    //Tirar da lista
                    break;
                case 5:
                    operacao = 0;
                    //Adicionar ClienteOperacao na Lista
                    break;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getOperacao() {
        return operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    public Cliente getClienteOperacao() {
        return clienteOperacao;
    }

    public void setClienteOperacao(EditorGUI gui, String nome, String arquivo) {
        clienteOperacao.setGui(gui);
        clienteOperacao.setNomeArquivo(arquivo);
        clienteOperacao.setNomeUsuario(nome);
    }

}

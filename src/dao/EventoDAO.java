/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import vo.EventoVO;

/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class EventoDAO implements CrudDAO {

    private File arquivo;
    private EventoVO eventoVO;
    private ArrayList<EventoVO> eventos;

    public EventoDAO() {

        arquivo = new File("");
    }

    public EventoDAO(EventoVO eventoVO) {

        arquivo = new File("");
        this.eventoVO = eventoVO;
    }

    public EventoDAO(ArrayList<EventoVO> eventos) {

        arquivo = new File("");
        this.eventos = eventos;
    }

    @Override
    public void cadastrar() throws IOException, SQLException, Exception {

        String linha;

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "\\data\\Eventos.xls", true));
        String texto = eventoVO.getNomeEvento() + "\t" + eventoVO.getData() + "\t" + eventoVO.getHoraInicial() + "\t" + eventoVO.getHoraFinal() + "\t" + eventoVO.getTipoEvento() + "\t" + eventoVO.getTotal();
        StringTokenizer st = new StringTokenizer(texto, "\n");

        while (st.hasMoreTokens()) {

            linha = st.nextToken();

            documento.write(linha);
            documento.newLine();
        }

        documento.close();
    }

    @Override
    public ArrayList<EventoVO> buscar() throws IOException, SQLException, Exception {

        ArrayList<EventoVO> eventos = new ArrayList<>();
        
        BufferedReader documento = new BufferedReader(new FileReader(arquivo.getAbsolutePath() + "\\data\\Eventos.xls"));
        String linha = documento.readLine();
         
        
        while (linha != null) {
            String[] evento = linha.split("\t");
            EventoVO eventoVO = new EventoVO();
            eventoVO.setNomeEvento(evento[0]);
            eventoVO.setData(evento[1]);
            eventoVO.setHoraInicial(evento[2]);
            eventoVO.setHoraFinal(evento[3]);
            eventoVO.setTipoEvento(evento[4]);
            eventoVO.setTotal(evento[2], evento[3]);
            eventos.add(eventoVO);
            linha = documento.readLine();
        }
        documento.close();

        return eventos;
    }

    @Override
    public void editar() throws IOException, SQLException, Exception {

        String linha;
        String texto;

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "\\data\\Eventos.xls"));

        for (int i = 0; i < this.eventos.size(); i++) {

            EventoVO evento = eventos.get(i);

            texto = evento.getNomeEvento() + "\t" + evento.getData() + "\t" + evento.getHoraInicial() + "\t" + evento.getHoraFinal() + "\t" + evento.getTipoEvento() + "\t" + evento.getTotal();
            StringTokenizer st = new StringTokenizer(texto, "\n");

            while (st.hasMoreTokens()) {

                linha = st.nextToken();

                documento.write(linha);
                documento.newLine();
            }
        }

        documento.close();
    }

    @Override
    public void excluir() throws IOException, SQLException, Exception {

        String linha;
        String texto;

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "\\data\\Eventos.xls"));

        for (int i = 0; i < this.eventos.size(); i++) {

            EventoVO evento = eventos.get(i);

            texto = evento.getNomeEvento() + "\t" + evento.getData() + "\t" + evento.getHoraInicial() + "\t" + evento.getHoraFinal() + "\t" + evento.getTipoEvento() + "\t" + evento.getTotal();
            StringTokenizer st = new StringTokenizer(texto, "\n");

            while (st.hasMoreTokens()) {

                linha = st.nextToken();

                documento.write(linha);
                documento.newLine();
            }
        }

        documento.close();
    }

    public boolean verificarExistencia(String nomeArquivo) throws IOException, SQLException, Exception {
        
        File arquivo = new File(nomeArquivo);

        return arquivo.exists();        
    }
    
    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception {
        
        String linha;
        String texto;

        BufferedWriter documento = new BufferedWriter(new FileWriter(nomeArquivo));

        for (int i = 0; i < this.eventos.size(); i++) {

            EventoVO evento = eventos.get(i);

            texto = evento.getNomeEvento() + "\t" + evento.getData() + "\t" + evento.getHoraInicial() + "\t" + evento.getHoraFinal() + "\t" + evento.getTipoEvento();
            StringTokenizer st = new StringTokenizer(texto, "\n");

            while (st.hasMoreTokens()) {

                linha = st.nextToken();

                documento.write(linha);
                documento.newLine();
            }
        }

        documento.close();
    }


   
}

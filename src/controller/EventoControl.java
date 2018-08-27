/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.EventoVO;
/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class EventoControl implements CrudControl {

    public EventoControl() {

    }

    public void cadastrar(String nomeEvento, String data, String horaInicial, String horaFinal, String tipoEvento) throws ValidacaoException, IOException, SQLException, Exception {
        this.validarCamposObrigatorios(nomeEvento, data, horaInicial, horaFinal, tipoEvento);
        this.verificarEvento(nomeEvento, data, horaInicial, horaFinal, tipoEvento);
        EventoVO eventoVO = new EventoVO();
        eventoVO.setNomeEvento(nomeEvento);
        eventoVO.setData(data);
        eventoVO.setHoraInicial(horaInicial);
        eventoVO.setHoraFinal(horaFinal);
        eventoVO.setTipoEvento(tipoEvento);
        eventoVO.setTotal(horaInicial, horaFinal);
       

        EventoDAO eventoDao = new EventoDAO(eventoVO);
        eventoDao.cadastrar();
    }

    @Override
    public ArrayList<EventoVO> buscar() throws IOException, SQLException, Exception {
        
        EventoDAO eventoDao = new EventoDAO();
        
        return eventoDao.buscar();
    }

    public void editar(String nomeEvento, String data, String horaInicial, String horaFinal, String tipoEvento) throws ValidacaoException, IOException, SQLException, Exception {

        this.validarCamposObrigatorios(nomeEvento, data, horaInicial, horaFinal, tipoEvento);

        EventoVO eventoVO = new EventoVO();

        eventoVO.setNomeEvento(nomeEvento);
        eventoVO.setData(data);
        eventoVO.setHoraInicial(horaInicial);
        eventoVO.setHoraFinal(horaFinal);
        eventoVO.setTipoEvento(tipoEvento);
        eventoVO.setTotal(horaInicial, horaFinal);

        ArrayList<EventoVO> eventos = this.buscar();

        for (int i = 0; i < eventos.size(); i++) {

            EventoVO evento = eventos.get(i);

            if (evento.getNomeEvento().equals(eventoVO.getNomeEvento())) {

                eventos.remove(i);
                eventos.add(eventoVO);
            }
        }

        EventoDAO eventoPers = new EventoDAO(eventos);
        eventoPers.editar();
    }

    public void excluir(String nomeEvento, String data, String horaInicial, String horaFinal, String tipoEvento) throws IOException, SQLException, Exception {

        ArrayList<EventoVO> eventos = this.buscar();

        for (int i = 0; i < eventos.size(); i++) {

            EventoVO eventoVO = eventos.get(i);

            if (nomeEvento.equals(eventoVO.getNomeEvento()) &&
                data.equals(eventoVO.getData()) &&
                horaInicial.equals(eventoVO.getHoraInicial()) &&
                horaFinal.equals(eventoVO.getHoraFinal()) &&
                tipoEvento.equals(eventoVO.getTipoEvento())) {

                eventos.remove(i);
            }
        }
        EventoDAO eventoPers = new EventoDAO(eventos);
        eventoPers.excluir();
    }

    public boolean verificarExistencia(String nomeArquivo) throws IOException, SQLException, Exception {

        EventoDAO eventoDAO = new EventoDAO();
        return eventoDAO.verificarExistencia(nomeArquivo);
    }

    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception {

        ArrayList <EventoVO> eventos = this.buscar();
        
        EventoDAO eventoDAO = new EventoDAO(eventos);
        eventoDAO.gerarRelatorio(nomeArquivo);
    }

    private void validarCamposObrigatorios (String nomeEvento, String data, String horaInicial, String horaFinal, String tipoEvento) throws ValidacaoException {
        if (data.equals("")){
            
            throw new ValidacaoException("Campo Data é obrigatório.");
        } else if (nomeEvento.equals("")) {

            throw new ValidacaoException("Campo Nome Evento é obrigatório.");

        } else if (data.equals("")) {

            throw new ValidacaoException(("Campo Data é obrigatório."));

        } else if (horaInicial.equals("  :  ")) {
            
            throw new ValidacaoException("Campo Hora Inicial é obrigatório.");

        } else if (horaFinal.equals("  :  ")){
            
            throw new ValidacaoException("Campo Hora Final é obrigatório.");
            
        } else if (tipoEvento.equals("")){
            
            throw new ValidacaoException("Campo Tipo Evento é obrigatório.");
            
        } 
        
        int hf = Integer.parseInt(horaFinal.substring(0, 2));
        int hi = Integer.parseInt(horaInicial.substring(0, 2));
        int mi = Integer.parseInt(horaFinal.substring(3, 5));
        int mf = Integer.parseInt(horaInicial.substring(3, 5));
        
        if ( hi > hf){
            
            throw new ValidacaoException("Hora final não pode ser antes de hora inicial.");
            
        } else if ( hi > 23 || hf > 23){
            
            throw new ValidacaoException("Formato de Hora inválido.");
            
        } else if ( mi > 59 || mf > 59){
            
            throw new ValidacaoException("Formato de Hora inválido.");
            
        } else if ( hi == hf && mi == mf){
            
            throw new ValidacaoException("Hora inválida.");
        }
    }
    
    private void verificarEvento(String nomeEvento, String data, String horaInicial, String horaFinal, String tipoEvento) throws ValidacaoException, SQLException, Exception{
        ArrayList<EventoVO> eventos = this.buscar();
        for (int i = 0; i < eventos.size(); i++) {
            EventoVO evento = eventos.get(i);
            if (evento.getNomeEvento().equals(nomeEvento)  &&
                evento.getData().equals(data) &&
                evento.getHoraInicial().equals(horaInicial) &&
                evento.getHoraFinal().equals(horaFinal) &&
                evento.getTipoEvento().equals(tipoEvento)){
                throw new ValidacaoException("Evento já cadastrado.");
            } else if ((evento.getNomeEvento().equals(nomeEvento)) && (evento.getData().equals(data))  && (evento.getHoraInicial().equals(horaFinal)))  {
                throw new ValidacaoException("Este evento não pode ser cadastrado!");
            } else if ((evento.getNomeEvento().equals(nomeEvento)) && (evento.getData().equals(data))  && (evento.getHoraFinal().equals(horaInicial)))  {
                throw new ValidacaoException("Este evento não pode ser cadastrado!");
            }
        }
    }
}
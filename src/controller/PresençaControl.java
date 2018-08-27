/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PresençaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.PresençaVO;

/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class PresençaControl implements CrudControl{

    public void cadastrar(int ra, String nomeEvento, int total) throws ValidacaoException, IOException, SQLException, Exception {

        this.validarCamposObrigatorios(ra, nomeEvento);
        PresençaVO presençaVO = new PresençaVO();
        presençaVO.setRa(ra);
        presençaVO.setNomeEvento(nomeEvento);
        presençaVO.setTotal(total);
                
        PresençaDAO presençaDao = new PresençaDAO(presençaVO);
        presençaDao.cadastrar();
        
    }

    
    public ArrayList<PresençaVO> buscar() throws IOException, SQLException, Exception {
        
        PresençaDAO presençaDao = new PresençaDAO();
        return presençaDao.buscar();
    }
    
        public boolean verificarExistencia(String nomeArquivo) throws IOException, SQLException, Exception {

        PresençaDAO presençaDAO = new PresençaDAO();
        return presençaDAO.verificarExistencia(nomeArquivo);
    }

    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception  {
        ArrayList <PresençaVO> presenças = this.buscar();

        PresençaDAO presençaDAO = new PresençaDAO(presenças);
        presençaDAO.gerarRelatorio(nomeArquivo);
}
    public String gerarSorteio(String nomeEvento) throws ValidacaoException, SQLException, Exception {
        String nomeSorteado;
        ArrayList <PresençaVO> presenças = this.buscar();
        PresençaDAO presençaDAO = new PresençaDAO(presenças);
        nomeSorteado = presençaDAO.gerarSorteio(nomeEvento);
        this.validarCampos(nomeSorteado);
        return nomeSorteado;
    }

    private void validarCampos(String nomeSorteado) throws ValidacaoException {
        if (nomeSorteado.equals("erro")) {
            throw new ValidacaoException("Evento vazio.");
        }
    }

    private void validarCamposObrigatorios(int ra, String nomeEvento) throws SQLException, Exception {
        ArrayList <PresençaVO> presenças = this.buscar();
        for (int i = 0; i < presenças.size(); i++) {
            PresençaVO presença = presenças.get(i);
            if ( ra == presença.getRa() && nomeEvento.equals(presença.getNomeEvento())){
                throw new ValidacaoException("Aluno já cadastrado no evento.");
            }
        }
    }

    public void gerarRelatorioAluno(String nomeArquivo, int ra) throws SQLException, Exception {
        ArrayList <PresençaVO> presenças = this.buscar();

        PresençaDAO presençaDAO = new PresençaDAO(presenças);
        presençaDAO.gerarRelatorioAluno(nomeArquivo, ra);
    }

}
    

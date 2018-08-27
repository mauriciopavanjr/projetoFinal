/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AlunoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.AlunoVO;

/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class AlunoControl implements CrudControl {

    public AlunoControl() {

    }

    public void cadastrar(String ra, String nome, String curso, String periodo, String turno, String email, String telefone) throws ValidacaoException, IOException, SQLException, Exception {

        this.validarCamposObrigatorios(ra, nome, curso, periodo, turno, email, telefone);
        
        AlunoVO alunoVO = new AlunoVO();
        this.verificarRa(ra);
        alunoVO.setRa(Integer.parseInt(ra));
        alunoVO.setNome(nome);
        alunoVO.setCurso(curso);
        alunoVO.setPeriodo(Integer.parseInt(periodo));
        alunoVO.setTurno(turno);
        alunoVO.setEmail(email);
        alunoVO.setTelefone(telefone);

        AlunoDAO alunoDao = new AlunoDAO(alunoVO);
        alunoDao.cadastrar();
    }

    @Override
    public ArrayList<AlunoVO> buscar() throws IOException, SQLException, Exception {

        AlunoDAO alunoDao = new AlunoDAO();
        return alunoDao.buscar();
    }

    public void editar(String ra, String nome, String curso, String periodo, String turno, String email, String telefone) throws ValidacaoException, IOException, SQLException, Exception {

        this.validarCamposObrigatorios(ra, nome, curso, periodo, turno, email, telefone);

        AlunoVO alunoVO = new AlunoVO();
        alunoVO.setRa(Integer.parseInt(ra));
        alunoVO.setNome(nome);
        alunoVO.setCurso(curso);
        alunoVO.setPeriodo(Integer.parseInt(periodo));
        alunoVO.setTurno(turno);
        alunoVO.setEmail(email);
        alunoVO.setTelefone(telefone);

        ArrayList<AlunoVO> alunos = this.buscar();

        for (int i = 0; i < alunos.size(); i++) {

            AlunoVO aluno = alunos.get(i);

            if (aluno.getRa() == alunoVO.getRa()) {

                alunos.remove(i);
                alunos.add(alunoVO);
            }
        }

        AlunoDAO alunoPers = new AlunoDAO(alunos);
        alunoPers.editar();
    }

    public void excluir(String ra) throws IOException, SQLException, Exception {

        ArrayList<AlunoVO> alunos = this.buscar();

        for (int i = 0; i < alunos.size(); i++) {

            AlunoVO alunoVO = alunos.get(i);

            if (Integer.parseInt(ra) == alunoVO.getRa()) {

                alunos.remove(i);
            }
        }

        AlunoDAO alunoPers = new AlunoDAO(alunos);
        alunoPers.excluir();
    }

    public boolean verificarExistencia(String nomeArquivo) throws IOException, SQLException, Exception {

        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.verificarExistencia(nomeArquivo);
    }

    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception {

        ArrayList <AlunoVO> alunos = this.buscar();
        
        AlunoDAO alunoDAO = new AlunoDAO(alunos);
        alunoDAO.gerarRelatorio(nomeArquivo);
    }

    private void validarCamposObrigatorios(String ra, String nome, String curso, String periodo, String turno, String email, String telefone) throws ValidacaoException, SQLException, Exception{
        
        if (ra.equals("")) {

            throw new ValidacaoException("Campo RA é obrigatório.");

        } else if (nome.equals("")) {

            throw new ValidacaoException(("Campo Nome é obrigatório."));

        } else if (Integer.parseInt(periodo) <= 0) {

            throw new ValidacaoException("O Período deve ser um número maior ou igual a 1.");

        }else if (Integer.parseInt(periodo) > 10) {

            throw new ValidacaoException("O Período deve ser um número menor ou igual a 10.");

        } else if (email.equals("")) {

            throw new ValidacaoException("Campo Email é obrigatório.");

        } else if (telefone.equals("(  )       -     ")){
            throw new ValidacaoException("Campo Telefone é obrigatório.");
        }
        /*ArrayList<AlunoVO> alunos = new ArrayList<>();
        alunos = this.buscar();
        for(AlunoVO aluno : alunos){
            if (Integer.parseInt(ra) == aluno.getRa()){
                throw new ValidacaoException("RA já cadastrado!");
            }
        }*/
        boolean verificadorTelefone = this.verificarTelefone(telefone);
        if (!verificadorTelefone){
            throw new ValidacaoException("Somente números no campo Telefone.");
        }
}
    
    private void verificarRa(String ra) throws ValidacaoException, SQLException, Exception{
        ArrayList<AlunoVO> alunos = new ArrayList<>();
        alunos = this.buscar();
        for(AlunoVO aluno : alunos){
            if (Integer.parseInt(ra) == aluno.getRa()){
                throw new ValidacaoException("RA já cadastrado!");
            }
        }
    }

    private boolean verificarTelefone(String telefone) {
        String ddd = telefone.substring(1, 3);
        String t1 = telefone.substring(5, 10);
        String t2 = telefone.substring(13, 17);
        char[] dddC = ddd.toCharArray();
        char[] t1C = t1.toCharArray();
        char[] t2C = t2.toCharArray();
        boolean verificador = true;
        for ( int i = 0; i < dddC.length; i++ ){
            if ( !Character.isDigit(dddC[i])) {
            verificador = false;
            }
        }
        for (int i = 0; i < t1C.length; i++ ){
            if ( !Character.isDigit(t1C[i])) {
            verificador = false;
            }
        }
        for (int i = 0; i < t2C.length; i++ ){
            if ( !Character.isDigit(t2C[i])) {
            verificador = false;
            }
        }
        return verificador;
        
 }


}


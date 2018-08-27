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
import vo.AlunoVO;

/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class AlunoDAO implements CrudDAO {

    private File arquivo;
    private AlunoVO alunoVO;
    private ArrayList<AlunoVO> alunos;

    public AlunoDAO() {

        arquivo = new File("");
    }

    public AlunoDAO(AlunoVO alunoVO) {

        arquivo = new File("");
        this.alunoVO = alunoVO;
    }

    public AlunoDAO(ArrayList<AlunoVO> alunos) {

        arquivo = new File("");
        this.alunos = alunos;
    }

    @Override
    public void cadastrar() throws IOException, SQLException, Exception {

        String linha;

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "\\data\\Alunos.xls", true));

        String texto = alunoVO.getRa() + "\t" + alunoVO.getNome() + "\t" + alunoVO.getCurso() + "\t" + alunoVO.getPeriodo() + "\t" + alunoVO.getTurno() + "\t" + alunoVO.getEmail() + "\t" + alunoVO.getTelefone();
        StringTokenizer st = new StringTokenizer(texto, "\n");

        while (st.hasMoreTokens()) {

            linha = st.nextToken();

            documento.write(linha);
            documento.newLine();
        }

        documento.close();
    }

    @Override
    public ArrayList<AlunoVO> buscar() throws IOException, SQLException, Exception {

        ArrayList<AlunoVO> alunos = new ArrayList<>();

        BufferedReader documento = new BufferedReader(new FileReader(arquivo.getAbsolutePath() + "\\data\\Alunos.xls"));
        String linha = documento.readLine();
         

        while (linha != null) {

            String[] aluno = linha.split("\t");

            AlunoVO alunoVO = new AlunoVO();

            alunoVO.setRa(Integer.parseInt(aluno[0]));
            alunoVO.setNome(aluno[1]);
            alunoVO.setCurso(aluno[2]);
            alunoVO.setPeriodo(Integer.parseInt(aluno[3]));
            alunoVO.setTurno(aluno[4]);
            alunoVO.setEmail(aluno[5]);
            alunoVO.setTelefone(aluno[6]);

            alunos.add(alunoVO);

            linha = documento.readLine();
        }
        
        documento.close();

        return alunos;
    }

    @Override
    public void editar() throws IOException, SQLException, Exception {

        String linha;
        String texto;

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "\\data\\Alunos.xls"));

        for (int i = 0; i < this.alunos.size(); i++) {

            AlunoVO aluno = alunos.get(i);

            texto = aluno.getRa() + "\t" + aluno.getNome() + "\t" + aluno.getCurso() + "\t" + aluno.getPeriodo() + "\t" + aluno.getTurno() + "\t" + aluno.getEmail() + "\t" + aluno.getTelefone();
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

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "\\data\\Alunos.xls"));

        for (int i = 0; i < this.alunos.size(); i++) {

            AlunoVO aluno = alunos.get(i);

            texto = aluno.getRa() + "\t" + aluno.getNome() + "\t" + aluno.getCurso() + "\t" + aluno.getPeriodo() + "\t" + aluno.getTurno() + "\t" + aluno.getEmail() + "\t" + aluno.getTelefone();
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

        for (int i = 0; i < this.alunos.size(); i++) {

            AlunoVO aluno = alunos.get(i);

            texto = aluno.getRa() + "\t" + aluno.getNome() + "\t" + aluno.getCurso() + "\t" + aluno.getPeriodo() + "\t" + aluno.getTurno() + "\t" + aluno.getEmail() + "\t" + aluno.getTelefone();
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

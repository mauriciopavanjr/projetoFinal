/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.AlunoControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import vo.AlunoVO;
import vo.PresençaVO;

/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class PresençaDAO {
    
    private File arquivo;
    private PresençaVO presençaVO;
    private ArrayList<PresençaVO> presenças;

    public PresençaDAO() {

        arquivo = new File("");
    }

    public PresençaDAO(PresençaVO presençaVO) {

        arquivo = new File("");
        this.presençaVO = presençaVO;
    }

    public PresençaDAO(ArrayList<PresençaVO> presenças) {

        arquivo = new File("");
        this.presenças = presenças;
    }
    
    public void cadastrar() throws IOException, SQLException, Exception {

        String linha;
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "\\data\\Presença.xls", true));
        String texto = presençaVO.getRa() + "\t" + presençaVO.getNomeEvento() + "\t" + presençaVO.getTotal();
        StringTokenizer st = new StringTokenizer(texto, "\n");

        while (st.hasMoreTokens()) {

            linha = st.nextToken();

            documento.write(linha);
            documento.newLine();
        }

        documento.close();
    }
    
        public ArrayList<PresençaVO> buscar() throws IOException, SQLException, Exception {

        ArrayList<PresençaVO> presenças = new ArrayList<>();
        BufferedReader documento = new BufferedReader(new FileReader(arquivo.getAbsolutePath() + "\\data\\Presença.xls"));
        String linha = documento.readLine();

        while (linha != null) {
            String[] presença = linha.split("\t");

            PresençaVO presençaVO = new PresençaVO();
            
            presençaVO.setRa(Integer.parseInt(presença[0]));
            presençaVO.setNomeEvento(presença[1]);
            presençaVO.setTotal(Integer.parseInt(presença[2]));

            

            presenças.add(presençaVO);
            
            linha = documento.readLine();
        }

        documento.close();

        return presenças;
    }
    
    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception {
        
        String linha;
        String texto;
        BufferedWriter documento = new BufferedWriter(new FileWriter(nomeArquivo));
        AlunoControl alunoControl = new AlunoControl();
        ArrayList <AlunoVO> alunos = alunoControl.buscar();

        for (int i = 0; i < alunos.size(); i++) {

            AlunoVO aluno = alunos.get(i);
            
            int ra = aluno.getRa();
            int cargaHoraria = 0;
            texto = aluno.getNome() + "\t" + aluno.getRa();
            StringTokenizer st = new StringTokenizer(texto, "\n");
            
            while (st.hasMoreTokens()) {
                linha = st.nextToken();
                documento.write(linha);
                documento.newLine();
            }
            texto = aluno.getCurso() + "\t" + "Periodo: " + aluno.getPeriodo() + "\t" + aluno.getTurno();
            st = new StringTokenizer(texto, "\n");
            
            while (st.hasMoreTokens()) {
                linha = st.nextToken();
                documento.write(linha);
                documento.newLine();
            }
            texto = aluno.getEmail() + "\t" + aluno.getTelefone();
            st = new StringTokenizer(texto, "\n");
            while (st.hasMoreTokens()) {
                linha = st.nextToken();
                documento.write(linha);
                documento.newLine();
                documento.newLine();
            }
            
            for (int x = 0; x < this.presenças.size(); x++){
                
                PresençaVO presença = presenças.get(x);
                
                int raEvento = presença.getRa();
                
                if (raEvento == ra){
                    texto = "\t" + presença.getNomeEvento() + "\t" + "Carga Horaria: " + presença.getTotal();
                    st = new StringTokenizer(texto, "\n");
                    
                    while (st.hasMoreTokens()) {
                        linha = st.nextToken();
                        documento.write(linha);
                        documento.newLine();
                    }
                    
                    cargaHoraria = cargaHoraria + presença.getTotal();
                }
                
            }
            
            if ( 0 == cargaHoraria){
                texto = "Aluno não participou de nenhum evento.";
                st = new StringTokenizer(texto, "\n");
                
                while (st.hasMoreTokens()) {
                        linha = st.nextToken();
                        documento.newLine();
                        documento.write(linha);
                        documento.newLine();
                        documento.newLine();
                }
                
            } else {
            texto = "Total de carga horária do aluno: " + cargaHoraria;
                st = new StringTokenizer(texto, "\n");
                
                while (st.hasMoreTokens()) {
                        linha = st.nextToken();
                        documento.newLine();
                        documento.write(linha);
                        documento.newLine();
                        documento.newLine();
                    }
            
            }
            texto = "------------------------------------------------------------------------";
                st = new StringTokenizer(texto, "\n");
                
                while (st.hasMoreTokens()) {
                        linha = st.nextToken();
                        documento.write(linha);
                        documento.newLine();
                        documento.newLine();
                    }
        }

        documento.close();
    }

    public boolean verificarExistencia(String nomeArquivo) {
        
        File arquivo = new File(nomeArquivo);

        return arquivo.exists();        
    
    }
    
    public String gerarSorteio(String nomeEvento) throws SQLException, Exception{
        String nome = null;
        int v = this.presenças.size();
        int[] presentes = new int[v];
        int cont = 0;
        for (int x = 0; x < this.presenças.size(); x++){
            PresençaVO presença = presenças.get(x);
            if (nomeEvento.equals(presença.getNomeEvento())){
                presentes[cont] = presença.getRa();
                cont++;
            } 
        }
        if (cont == 0){
            String erro = "erro";
            return erro;
        }
        
        Random valor = new Random();
        int sorteado = valor.nextInt(cont);
        AlunoControl alunoControl = new AlunoControl();
        ArrayList <AlunoVO> alunos = alunoControl.buscar();
        
        for (int i = 0; i < alunos.size(); i++) {
            AlunoVO aluno = alunos.get(i);
            int ra = aluno.getRa();
            if ( ra == presentes[sorteado]){
                nome = aluno.getNome();
                return nome;
            }
        }
        return nome;
    }

    public void gerarRelatorioAluno(String nomeArquivo, int ra) throws IOException, Exception {
        String linha;
        String texto;
        BufferedWriter documento = new BufferedWriter(new FileWriter(nomeArquivo));
        AlunoControl alunoControl = new AlunoControl();
        ArrayList <AlunoVO> alunos = alunoControl.buscar();
        for (int i = 0; i < alunos.size(); i++) {
            AlunoVO aluno = alunos.get(i);
            if (ra == aluno.getRa()){
            int cargaHoraria = 0;
            texto = aluno.getNome() + "\t" + aluno.getRa();
            StringTokenizer st = new StringTokenizer(texto, "\n");
            while (st.hasMoreTokens()) {
                linha = st.nextToken();
                documento.write(linha);
                documento.newLine();
            }
            texto = aluno.getCurso() + "\t" + "Periodo: " + aluno.getPeriodo() + "\t" + aluno.getTurno();
            st = new StringTokenizer(texto, "\n");
            
            while (st.hasMoreTokens()) {
                linha = st.nextToken();
                documento.write(linha);
                documento.newLine();
            }
            texto = aluno.getEmail() + "\t" + aluno.getTelefone();
            st = new StringTokenizer(texto, "\n");
            while (st.hasMoreTokens()) {
                linha = st.nextToken();
                documento.write(linha);
                documento.newLine();
                documento.newLine();
            }
            for (int x = 0; x < this.presenças.size(); x++){
                PresençaVO presença = presenças.get(x);
                int raEvento = presença.getRa();
                if (raEvento == ra){
                    texto = "\t" + presença.getNomeEvento() + "\t" + "Carga Horaria: " + presença.getTotal();
                    st = new StringTokenizer(texto, "\n");
                    
                    while (st.hasMoreTokens()) {
                        linha = st.nextToken();
                        documento.write(linha);
                        documento.newLine();
                    }
                    
                    cargaHoraria = cargaHoraria + presença.getTotal();
                }                
            }
            if ( 0 == cargaHoraria){
                texto = "Aluno não participou de nenhum evento.";
                st = new StringTokenizer(texto, "\n");
                
                while (st.hasMoreTokens()) {
                        linha = st.nextToken();
                        documento.newLine();
                        documento.write(linha);
                        documento.newLine();
                        documento.newLine();
                }
                
            } else {
            texto = "Total de carga horária do aluno: " + cargaHoraria;
                st = new StringTokenizer(texto, "\n");
                
                while (st.hasMoreTokens()) {
                        linha = st.nextToken();
                        documento.newLine();
                        documento.write(linha);
                        documento.newLine();
                        documento.newLine();
                    }
            
            }
            }
        }
        documento.close();
}
}
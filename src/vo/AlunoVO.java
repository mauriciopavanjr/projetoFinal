/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class AlunoVO {

    private int ra;
    private String nome;
    private String curso;
    private int periodo;
    private String turno;
    private String email;
    private String telefone;

    public AlunoVO() {
    
    }
    
    public AlunoVO(int ra, String nome, String curso, int periodo, String turno, String email, String telefone) {
     
        this.ra = ra;
        this.nome = nome;
        this.curso = curso;
        this.periodo = periodo;
        this.turno = turno;
        this.email = email;
        this.telefone = telefone;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}


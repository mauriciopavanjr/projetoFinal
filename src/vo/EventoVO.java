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
public class EventoVO {

    private String nomeEvento;
    private String data;
    private String horaInicial;
    private String horaFinal;
    private String tipoEvento;
    private int total;

    public EventoVO() {
    
    }
    
    public EventoVO(String nomeEvento, String data, String horaInicial, String horaFinal, String tipoEvento) {
     
        this.nomeEvento = nomeEvento;
        this.data = data;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.tipoEvento = tipoEvento;
        this.total = calcularHora(horaInicial, horaFinal);
        
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String horaInicial, String horaFinal) {
        
        this.total = calcularHora(horaInicial, horaFinal);
        //System.out.println(this.total);
    }

    private int calcularHora(String horaInicial, String horaFinal) {
        int hf = Integer.parseInt(horaFinal.substring(0, 2));
        int hi = Integer.parseInt(horaInicial.substring(0, 2));
        int mf = Integer.parseInt(horaFinal.substring(3, 5));
        int mi = Integer.parseInt(horaInicial.substring(3, 5));
        
        if ( hf == hi ){
            return (mf - mi); 
        } 
        else if (mf > mi || mf == mi){
            return ((60*(hf-hi)) + (mf-mi));
        }
        else {
            return (60*(hf-hi) - (mi-mf));
        }
        
    }
}


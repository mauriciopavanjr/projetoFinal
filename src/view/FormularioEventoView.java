/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EventoControl;
import controller.ValidacaoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import vo.EventoVO;

/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class FormularioEventoView extends javax.swing.JFrame {
    
    Date dataAtual = new Date();

    private BuscaAlunoEventoControlePresençaView buscaAlunoEventoControlePresençaView;
    
    public FormularioEventoView(BuscaAlunoEventoControlePresençaView buscaAlunoEventoControlePresençaVisao) {
        initComponents();
        this.setTitle("Cadastro de Evento");
        this.bEditar.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.buscaAlunoEventoControlePresençaView = buscaAlunoEventoControlePresençaVisao; 
        GregorianCalendar calendar = new GregorianCalendar();
        jCalendarData.setMinSelectableDate(calendar.getTime());
    }

    public FormularioEventoView(BuscaAlunoEventoControlePresençaView buscaAlunoEventoControlePresençaView, EventoVO eventoVO) {

        initComponents();
        this.setTitle("Edição de Registro de Eventos");
        this.bCadastrar.setEnabled(false);
        this.tNomeEvento.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.buscaAlunoEventoControlePresençaView = buscaAlunoEventoControlePresençaView;
        GregorianCalendar calendar = new GregorianCalendar();
        jCalendarData.setMinSelectableDate(calendar.getTime());
        popularCampos(eventoVO);
    }
    
    public void popularCampos(EventoVO eventoVO) {
        
        this.gettNomeEvento().setText(eventoVO.getNomeEvento());
        ((JTextField)jCalendarData.getDateEditor().getUiComponent()).setText(eventoVO.getData());
        this.getjFormattedTextFieldHoraInicial().setText(eventoVO.getHoraInicial());
        this.getjFormattedTextFieldHoraFinal().setText(eventoVO.getHoraFinal());
        this.getjComboBoxTipoEvento().setSelectedItem(eventoVO.getTipoEvento());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        bEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();
        jComboBoxTipoEvento = new javax.swing.JComboBox<>();
        jFormattedTextFieldHoraInicial = new javax.swing.JFormattedTextField();
        jFormattedTextFieldHoraFinal = new javax.swing.JFormattedTextField();
        tNomeEvento = new javax.swing.JTextField();
        jCalendarData = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Evento");

        jLabel2.setText("Data:");

        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        jLabel3.setText("HoraInicial:");

        jLabel4.setText("Hora Final:");

        bEditar.setText("Concluir Edição");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo do Evento:");

        jLabel1.setText("Nome do Evento:");

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jComboBoxTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Palestras", "Minicursos", "Mesa redonda", "Oficina", "outros" }));

        try {
            jFormattedTextFieldHoraInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**:**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldHoraFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**:**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tNomeEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNomeEventoActionPerformed(evt);
            }
        });

        jCalendarData.setMinSelectableDate(new java.util.Date(-62135755100000L));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNomeEvento)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCalendarData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jCalendarData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextFieldHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed

        try {
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            String data = fmt.format(this.jCalendarData.getDate());
            EventoControl eventoControl = new EventoControl();
            eventoControl.cadastrar(this.tNomeEvento.getText(),
                data,
                this.jFormattedTextFieldHoraInicial.getText(),
                this.jFormattedTextFieldHoraFinal.getText(),
                this.jComboBoxTipoEvento.getSelectedItem().toString());
            this.buscaAlunoEventoControlePresençaView.popularTabelaEventos();

            JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso!", "Cadastro Evento", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (ValidacaoException validacaoException) {
            
            JOptionPane.showMessageDialog(rootPane, validacaoException.getMessage(), "Cadastro Evento", JOptionPane.WARNING_MESSAGE);
        
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao efetuar o cadastro.", "Cadastro Evento", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed

        try {
            
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            String data = fmt.format(this.jCalendarData.getDate());

            EventoControl eventoControl = new EventoControl();
            eventoControl.editar(this.tNomeEvento.getText(),
                data,
                this.jFormattedTextFieldHoraInicial.getText(),
                this.jFormattedTextFieldHoraFinal.getText(),
                this.jComboBoxTipoEvento.getSelectedItem().toString());
            
            

            this.buscaAlunoEventoControlePresençaView.popularTabelaEventos();

            JOptionPane.showMessageDialog(rootPane, "Edição realizada com sucesso!", "Editar Eventos", JOptionPane.INFORMATION_MESSAGE);

            this.dispose();

        } catch (ValidacaoException validacaoException) {
            
            JOptionPane.showMessageDialog(rootPane, validacaoException.getMessage(), "Editar Eventos", JOptionPane.WARNING_MESSAGE);
        
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao efetuar a edição!", "Editar Eventos", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_bEditarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed

        this.dispose();

    }//GEN-LAST:event_bCancelarActionPerformed

    private void tNomeEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNomeEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNomeEventoActionPerformed

    
    private javax.swing.JComboBox<String> getjComboBoxTipoEvento(){
        return jComboBoxTipoEvento;
    }
    
    private javax.swing.JFormattedTextField getjFormattedTextFieldHoraFinal(){
        return jFormattedTextFieldHoraFinal;
    }
    
    private javax.swing.JFormattedTextField getjFormattedTextFieldHoraInicial(){
        return jFormattedTextFieldHoraInicial;
    }
    
    private com.toedter.calendar.JDateChooser getjCalendarData(){
        return jCalendarData;
    }
    
    public javax.swing.JTextField gettNomeEvento() {
        return tNomeEvento;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bEditar;
    private com.toedter.calendar.JDateChooser jCalendarData;
    private javax.swing.JComboBox<String> jComboBoxTipoEvento;
    private javax.swing.JFormattedTextField jFormattedTextFieldHoraFinal;
    private javax.swing.JFormattedTextField jFormattedTextFieldHoraInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tNomeEvento;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import controller.AlunoControl;
import controller.ValidacaoException;
import vo.AlunoVO;


/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class FormularioAlunoView extends javax.swing.JFrame {

   private BuscaAlunoEventoControlePresençaView buscaAlunoEventoControlePresençaView;

    public FormularioAlunoView(BuscaAlunoEventoControlePresençaView buscaAlunoEventoControlePresençaVisao) {

        initComponents();
        this.setTitle("Cadastro de Aluno");
        this.bEditar.setEnabled(false);
        this.setLocationRelativeTo(null);
        
        this.buscaAlunoEventoControlePresençaView = buscaAlunoEventoControlePresençaVisao;      
    }
    
    public FormularioAlunoView(BuscaAlunoEventoControlePresençaView buscaAlunoEventoControlePresençaView, AlunoVO alunoVO) {

        initComponents();
        this.setTitle("Edição de Registro de Aluno");
        this.bCadastrar.setEnabled(false);
        this.tRA.setEnabled(false);
        this.setLocationRelativeTo(null);
        
        this.buscaAlunoEventoControlePresençaView = buscaAlunoEventoControlePresençaView;
        
        popularCampos(alunoVO);
    }
    
    public void popularCampos(AlunoVO alunoVO) {
        
        this.gettRA().setText(String.valueOf(alunoVO.getRa()));
        this.gettNome().setText(alunoVO.getNome());
        this.getCbCurso().setSelectedItem(alunoVO.getCurso());
        this.getsPeriodo().setValue(alunoVO.getPeriodo());
        this.getCbTurno().setSelectedItem(alunoVO.getTurno());
        this.gettEmail().setText(alunoVO.getEmail());
        this.getjfTelefone().setText(alunoVO.getTelefone());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        tEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tNome = new javax.swing.JTextField();
        cbCurso = new javax.swing.JComboBox<>();
        sPeriodo = new javax.swing.JSpinner();
        cbTurno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jfTelefone = new javax.swing.JFormattedTextField();
        tRA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Aluno");

        jLabel2.setText("Nome:");

        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Curso:");

        jLabel4.setText("Período:");

        jLabel5.setText("Turno:");

        bEditar.setText("Concluir Edição");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        jLabel6.setText("Email:");

        cbCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bacharelado em Ciência da Computação", "Engenharia de Bioprocessos e Biotecnologia", "Engenharia de Produção", "Engenharia Elétrica", "Engenharia Eletrônica", "Engenharia Mecânica", "Engenharia Química", "Licenciatura em Ciências Biológicas", "Tecnologia em Análise e Desenvolvimento de Sistemas", "Tecnologia em Automação Industrial", "Tecnologia em Fabricação Mecânica" }));

        sPeriodo.setValue(1);

        cbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Integral", "Noturno", " " }));

        jLabel1.setText("RA:");

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("Telefone:");

        try {
            jfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(**) ***** - ****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbTurno, javax.swing.GroupLayout.Alignment.LEADING, 0, 183, Short.MAX_VALUE))
                    .addComponent(jfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tRA, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

            AlunoControl alunoControl = new AlunoControl();
            alunoControl.cadastrar(this.tRA.getText(),
                this.tNome.getText(),
                this.cbCurso.getSelectedItem().toString(),
                this.sPeriodo.getValue().toString(),
                this.cbTurno.getSelectedItem().toString(),
                this.tEmail.getText(),
                this.jfTelefone.getText());

            this.buscaAlunoEventoControlePresençaView.popularTabelaAlunos();

            JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso!", "Cadastro Aluno", JOptionPane.INFORMATION_MESSAGE);

            this.dispose();

        } catch (ValidacaoException validacaoException) {
            
            JOptionPane.showMessageDialog(rootPane, validacaoException.getMessage(), "Cadastro Aluno", JOptionPane.WARNING_MESSAGE);
        
        } catch (NumberFormatException nfe){
            
            JOptionPane.showMessageDialog(rootPane, "O campo RA deve conter apenas números!", "Cadastro Aluno", JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao efetuar o cadastro!", "Cadastro Aluno", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed

        try {

            AlunoControl alunoControl = new AlunoControl();
            alunoControl.editar(this.tRA.getText(),
                this.tNome.getText(),
                this.cbCurso.getSelectedItem().toString(),
                this.sPeriodo.getValue().toString(),
                this.cbTurno.getSelectedItem().toString(),
                this.tEmail.getText(),
                this.jfTelefone.getText());

            this.buscaAlunoEventoControlePresençaView.popularTabelaAlunos();

            JOptionPane.showMessageDialog(rootPane, "Edição realizada com sucesso!", "Editar Aluno", JOptionPane.INFORMATION_MESSAGE);

            this.dispose();

        } catch (ValidacaoException validacaoException) {
            
            JOptionPane.showMessageDialog(rootPane, validacaoException.getMessage(), "Editar Aluno", JOptionPane.WARNING_MESSAGE);
        
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao efetuar a edição!", "Editar Aluno", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_bEditarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed

        this.dispose();

    }//GEN-LAST:event_bCancelarActionPerformed

  
     public javax.swing.JFormattedTextField getjfTelefone() {
        return jfTelefone;
    }


    public javax.swing.JTextField gettEmail() {
        return tEmail;
    }
    
    public javax.swing.JComboBox<String> getCbCurso() {
        return cbCurso;
    }

    public javax.swing.JComboBox<String> getCbTurno() {
        return cbTurno;
    }

    public javax.swing.JSpinner getsPeriodo() {
        return sPeriodo;
    }


    public javax.swing.JTextField gettNome() {
        return tNome;
    }

    public javax.swing.JTextField gettRA() {
        return tRA;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bEditar;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField jfTelefone;
    private javax.swing.JSpinner sPeriodo;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tRA;
    // End of variables declaration//GEN-END:variables
}

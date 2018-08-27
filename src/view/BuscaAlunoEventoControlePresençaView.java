/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.AlunoControl;
import controller.EventoControl;
import controller.PresençaControl;
import controller.ValidacaoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import vo.AlunoVO;
import vo.EventoVO;

/**
 *
 * @author Juliano, Mauricio, Tamara
 */
public class BuscaAlunoEventoControlePresençaView extends javax.swing.JFrame {
    
    
    TableRowSorter sorter = null;
    

    /**
     * Creates new form BuscaAlunoView
     */
    public BuscaAlunoEventoControlePresençaView() {
        initComponents();
        this.setLocationRelativeTo(null);

        this.popularTabelaAlunos();
        this.popularTabelaEventos();
    }

     public void popularTabelaAlunos() {

        try {

            

            AlunoControl alunoControl = new AlunoControl();
            ArrayList<AlunoVO> alunos = alunoControl.buscar();

            DefaultTableModel dtmAluno = (DefaultTableModel) tAlunos.getModel();
            DefaultTableModel dtmAluno1 = (DefaultTableModel) tAlunos1.getModel();
            
            dtmAluno.fireTableDataChanged();
            dtmAluno.setRowCount(0);
            dtmAluno1.fireTableDataChanged();
            dtmAluno1.setRowCount(0);
            
            for (AlunoVO alunoVO : alunos) {

                dtmAluno.addRow(new Object[]{alunoVO.getRa(), alunoVO.getNome(), alunoVO.getCurso(), alunoVO.getPeriodo(), alunoVO.getTurno(), alunoVO.getEmail(), alunoVO.getTelefone()});
                dtmAluno1.addRow(new Object[]{alunoVO.getRa(), alunoVO.getNome(), alunoVO.getCurso(), alunoVO.getPeriodo(), alunoVO.getTurno(), alunoVO.getEmail(), alunoVO.getTelefone()});
            
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro de comunicação com o Banco de Dados.", "Buscar Alunos", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Buscar Alunos", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void popularTabelaEventos() {

        try {

            
            
            EventoControl eventoControl = new EventoControl();
            
            ArrayList<EventoVO> eventos = eventoControl.buscar();
            
            DefaultTableModel dtmEvento = (DefaultTableModel) tEventos.getModel();
            
            dtmEvento.fireTableDataChanged();
            dtmEvento.setRowCount(0);
            DefaultTableModel dtmEvento1 = (DefaultTableModel) tEventos1.getModel();
            sorter = new TableRowSorter<TableModel>(dtmEvento1);
            dtmEvento1.fireTableDataChanged();
            dtmEvento1.setRowCount(0);
            
            for (EventoVO eventoVO : eventos) {

                dtmEvento.addRow(new Object[]{eventoVO.getNomeEvento(), eventoVO.getData(), eventoVO.getHoraInicial(), eventoVO.getHoraFinal(), eventoVO.getTipoEvento(), eventoVO.getTotal()});// adiciona na jtbale
                dtmEvento1.addRow(new Object[]{eventoVO.getNomeEvento(), eventoVO.getData(), eventoVO.getHoraInicial(), eventoVO.getHoraFinal(), eventoVO.getTipoEvento(), eventoVO.getTotal()});// adiciona na jtbale
            
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro de comunicação com o Banco de Dados.", "Buscar Eventos", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela", "Buscar Eventos", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        bEditar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlunos = new javax.swing.JTable();
        bNovo = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bRelatorio = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bNovo1 = new javax.swing.JButton();
        bFechar1 = new javax.swing.JButton();
        bExcluir1 = new javax.swing.JButton();
        bEditar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tEventos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tEventos1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tAlunos1 = new javax.swing.JTable();
        bAdicionar = new javax.swing.JButton();
        bSorteio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBuscaNome = new javax.swing.JTextField();
        tRa = new javax.swing.JLabel();
        jBuscaRa = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuGerarRelatorio = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Controle de Presença em Eventos");

        bEditar.setText("Editar");
        bEditar.setMaximumSize(new java.awt.Dimension(57, 23));
        bEditar.setMinimumSize(new java.awt.Dimension(57, 23));
        bEditar.setPreferredSize(new java.awt.Dimension(57, 23));
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alunos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(153, 153, 153))); // NOI18N

        tAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RA", "Nome", "Curso", "Período", "Turno", "Email", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tAlunos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        bNovo.setText("Novo");
        bNovo.setFocusPainted(false);
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bFechar.setText("Fechar");
        bFechar.setMaximumSize(new java.awt.Dimension(57, 23));
        bFechar.setMinimumSize(new java.awt.Dimension(57, 23));
        bFechar.setPreferredSize(new java.awt.Dimension(57, 23));
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        bExcluir.setText("Excluir");
        bExcluir.setMaximumSize(new java.awt.Dimension(57, 23));
        bExcluir.setMinimumSize(new java.awt.Dimension(57, 23));
        bExcluir.setPreferredSize(new java.awt.Dimension(57, 23));
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bRelatorio.setText("Relátorio");
        bRelatorio.setMaximumSize(new java.awt.Dimension(57, 23));
        bRelatorio.setMinimumSize(new java.awt.Dimension(57, 23));
        bRelatorio.setPreferredSize(new java.awt.Dimension(57, 23));
        bRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(bFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(bExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bFechar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Alunos", jPanel1);

        bNovo1.setText("Novo");
        bNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovo1ActionPerformed(evt);
            }
        });

        bFechar1.setText("Fechar");
        bFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFechar1ActionPerformed(evt);
            }
        });

        bExcluir1.setText("Excluir");
        bExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluir1ActionPerformed(evt);
            }
        });

        bEditar1.setText("Editar");
        bEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditar1ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eventos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(153, 153, 153))); // NOI18N

        tEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Evento", "Data", "Hora Inicial", "Hora Final", "Tipo do Evento", "Carga Horária"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tEventos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bFechar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(bExcluir1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEditar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bNovo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Eventos", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle de Presença", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(153, 153, 153))); // NOI18N

        tEventos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Evento", "Data", "Hora Inicial", "Hora Final", "Tipo do Evento", "Carga Horária"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tEventos1.setName(""); // NOI18N
        jScrollPane3.setViewportView(tEventos1);
        tEventos1.getAccessibleContext().setAccessibleName("Eventos");

        tAlunos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RA", "Nome", "Curso", "Período", "Turno", "Email", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tAlunos1);

        bAdicionar.setText("Adicionar Aluno");
        bAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdicionarActionPerformed(evt);
            }
        });

        bSorteio.setText("Sortear");
        bSorteio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSorteioActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jBuscaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBuscaNomeKeyPressed(evt);
            }
        });

        tRa.setText("RA:");

        jBuscaRa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBuscaRaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bSorteio, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(tRa)
                .addGap(18, 18, 18)
                .addComponent(jBuscaRa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tRa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBuscaRa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(bSorteio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Controle de Presença", jPanel3);

        jMenu1.setText("Arquivo");

        menuGerarRelatorio.setText("Gerar Relatório");
        menuGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGerarRelatorioActionPerformed(evt);
            }
        });
        jMenu1.add(menuGerarRelatorio);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        jMenu2.add(menuSobre);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGerarRelatorioActionPerformed

        try {

            int confirmacao = 0;
            String extensao = "";
            JFileChooser jFileChooser = new JFileChooser();

            FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Documento de texto (*.txt)", "txt");
            FileNameExtensionFilter filtroDoc = new FileNameExtensionFilter("Documento do word (*.doc)", "txt");
            FileNameExtensionFilter filtroXls = new FileNameExtensionFilter("Pasta de Trabalho do Excel (*.xls)", "txt");

            jFileChooser.setFileFilter(filtroDoc);
            jFileChooser.setFileFilter(filtroXls);
            jFileChooser.setFileFilter(filtroTxt);

            int valorRetorno = jFileChooser.showSaveDialog(null);

            if (valorRetorno == JFileChooser.APPROVE_OPTION) {

                if (jFileChooser.getFileFilter().getDescription().equals("Documento de texto (*.txt)")) {

                    extensao = ".txt";

                } else if (jFileChooser.getFileFilter().getDescription().equals("Documento do word (*.doc)")) {

                    extensao = ".doc";

                } else if (jFileChooser.getFileFilter().getDescription().equals("Pasta de Trabalho do Excel (*.xls)")) {

                    extensao = ".xls";

                }

                String nomeArquivo = jFileChooser.getSelectedFile().getAbsolutePath() + extensao;

                PresençaControl presençaControl = new PresençaControl();
                AlunoControl alunoControl = new AlunoControl();
                boolean arquivoExiste = alunoControl.verificarExistencia(nomeArquivo);

                if (arquivoExiste) {

                    confirmacao = JOptionPane.showConfirmDialog(null, jFileChooser.getSelectedFile().getName() + " já existe.\nDeseja substituí-lo?", "Confirmar Salvar Arquivo", JOptionPane.YES_NO_OPTION);
                }

                if (confirmacao == 0) {

                    presençaControl.gerarRelatorio(nomeArquivo);
                    JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!", "Gerar Relatório", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "Erro: " + ioe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException sqle) {

            JOptionPane.showMessageDialog(null, "Erro: " + sqle.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuGerarRelatorioActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed

        this.dispose();
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed

        Sobre sobre = new Sobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_menuSobreActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed

        try {

            AlunoVO alunoVO = new AlunoVO();

            alunoVO.setRa(Integer.parseInt(this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 0).toString()));
            alunoVO.setNome((String) this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 1));
            alunoVO.setCurso((String) this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 2));
            alunoVO.setPeriodo(Integer.parseInt(this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 3).toString()));
            alunoVO.setTurno((String) this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(),4));
            alunoVO.setEmail((String) this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 5));
            alunoVO.setTelefone((String) this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 6));

            FormularioAlunoView formularioAlunoVisao = new FormularioAlunoView(this, alunoVO);
            formularioAlunoVisao.setVisible(true);

        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Edição de Registro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bEditarActionPerformed

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed

        FormularioAlunoView formularioAlunoVisao = new FormularioAlunoView(this);
        formularioAlunoVisao.setVisible(true);
    }//GEN-LAST:event_bNovoActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed

        this.dispose();
    }//GEN-LAST:event_bFecharActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed

        try {

            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o aluno " + this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 1).toString() + "?", "Exclusão de Registro", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirmacao == 0) {

                AlunoControl alunoControl = new AlunoControl();
                alunoControl.excluir(this.tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 0).toString());

                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso!", "Exclusão de Registro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Exclusão de Registro", JOptionPane.WARNING_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir o registro!", "Exclusão de Registro", JOptionPane.ERROR_MESSAGE);

        } finally {

            this.popularTabelaAlunos();
        }
    }//GEN-LAST:event_bExcluirActionPerformed

    private void bNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovo1ActionPerformed
        FormularioEventoView formularioEventoVisao = new FormularioEventoView(this);
        formularioEventoVisao.setVisible(true);
    }//GEN-LAST:event_bNovo1ActionPerformed

    private void bFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFechar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_bFechar1ActionPerformed

    private void bExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluir1ActionPerformed
         try {

            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o evento " + this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 0).toString() + "?", "Exclusão de Registro", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirmacao == 0) {

                EventoControl eventoControl = new EventoControl();
                eventoControl.excluir(this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 0).toString(),
                                      this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 1).toString(),
                                      this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 2).toString(),
                                      this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 3).toString(),
                                      this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 4).toString());

                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso!", "Exclusão de Registro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Exclusão de Registro", JOptionPane.WARNING_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir o registro!", "Exclusão de Registro", JOptionPane.ERROR_MESSAGE);

        } finally {

            this.popularTabelaEventos();
        }                                        

    }//GEN-LAST:event_bExcluir1ActionPerformed

    private void bEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditar1ActionPerformed
          try {

            EventoVO eventoVO = new EventoVO();

            eventoVO.setNomeEvento((String) this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 0));
            eventoVO.setData((String) this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 1));
            eventoVO.setHoraInicial((String) this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 2));
            eventoVO.setHoraFinal((String) this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 3));
            eventoVO.setTipoEvento((String) this.tEventos.getValueAt(this.tEventos.getSelectedRow(), 4));
            
            
                    

            FormularioEventoView formularioEventoVisao = new FormularioEventoView(this, eventoVO);
            formularioEventoVisao.setVisible(true);

        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Edição de Registro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bEditar1ActionPerformed

    private void jBuscaRaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscaRaKeyPressed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tAlunos1.getModel();
        sorter = new TableRowSorter<TableModel>(dtm);
        tAlunos1.setRowSorter(sorter);
        String text = jBuscaRa.getText();
        if (text.length() == 0){

            sorter.setRowFilter(null);
        } else{
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_jBuscaRaKeyPressed

    private void jBuscaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBuscaNomeKeyPressed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tAlunos1.getModel();
        sorter = new TableRowSorter<TableModel>(dtm);
        tAlunos1.setRowSorter(sorter);
        String text = jBuscaNome.getText();
        if (text.length() == 0){
            sorter.setRowFilter(null);
        } else{
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_jBuscaNomeKeyPressed

    private void bSorteioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSorteioActionPerformed
        // TODO add your handling code here:
        try{
            String nomeEvento;
            String nomeSorteado;
            PresençaControl presença = new PresençaControl();
            nomeEvento = ((String) this.tEventos1.getValueAt(this.tEventos1.getSelectedRow(), 0));
            nomeSorteado = presença.gerarSorteio(nomeEvento);
            JOptionPane.showMessageDialog(null, "Aluno sorteado: " + nomeSorteado, "Sorteio", JOptionPane.PLAIN_MESSAGE);

        } catch (ValidacaoException validacaoException) {

            JOptionPane.showMessageDialog(rootPane, validacaoException.getMessage(), "Sorteio", JOptionPane.WARNING_MESSAGE);

        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um evento na tabela", "Sorteio", JOptionPane.WARNING_MESSAGE);

        } catch (Exception ex) {

            Logger.getLogger(BuscaAlunoEventoControlePresençaView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bSorteioActionPerformed

    private void bAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdicionarActionPerformed
        // TODO add your handling code here:
        try {

            String nomeEvento = (String) tEventos1.getValueAt(this.tEventos1.getSelectedRow(), 0);

            int ra = (int) tAlunos1.getValueAt(this.tAlunos1.getSelectedRow(), 0);

            int total = (int) this.tEventos1.getValueAt(this.tEventos1.getSelectedRow(), 5);

            PresençaControl presençaControl = new PresençaControl();
            
            presençaControl.cadastrar(ra, nomeEvento, total);

            JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso!", "Cadastro de Presença", JOptionPane.INFORMATION_MESSAGE);

        } catch (ValidacaoException ve){
            
            JOptionPane.showMessageDialog(rootPane, ve.getMessage(), "Cadastro de Presença", JOptionPane.ERROR_MESSAGE);
            
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao efetuar o cadastro!", "Cadastro de Presença", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_bAdicionarActionPerformed

    private void bRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRelatorioActionPerformed
        // TODO add your handling code here:
        try {
            int raAluno;
            raAluno = (int) tAlunos.getValueAt(this.tAlunos.getSelectedRow(), 0);

            int confirmacao = 0;
            String extensao = "";
            JFileChooser jFileChooser = new JFileChooser();

            FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Documento de texto (*.txt)", "txt");
            FileNameExtensionFilter filtroDoc = new FileNameExtensionFilter("Documento do word (*.doc)", "txt");
            FileNameExtensionFilter filtroXls = new FileNameExtensionFilter("Pasta de Trabalho do Excel (*.xls)", "txt");

            jFileChooser.setFileFilter(filtroDoc);
            jFileChooser.setFileFilter(filtroXls);
            jFileChooser.setFileFilter(filtroTxt);

            int valorRetorno = jFileChooser.showSaveDialog(null);

            if (valorRetorno == JFileChooser.APPROVE_OPTION) {

                if (jFileChooser.getFileFilter().getDescription().equals("Documento de texto (*.txt)")) {

                    extensao = ".txt";

                } else if (jFileChooser.getFileFilter().getDescription().equals("Documento do word (*.doc)")) {

                    extensao = ".doc";

                } else if (jFileChooser.getFileFilter().getDescription().equals("Pasta de Trabalho do Excel (*.xls)")) {

                    extensao = ".xls";

                }

                String nomeArquivo = jFileChooser.getSelectedFile().getAbsolutePath() + extensao;

                PresençaControl presençaControl = new PresençaControl();
                AlunoControl alunoControl = new AlunoControl();
                boolean arquivoExiste = alunoControl.verificarExistencia(nomeArquivo);

                if (arquivoExiste) {

                    confirmacao = JOptionPane.showConfirmDialog(null, jFileChooser.getSelectedFile().getName() + " já existe.\nDeseja substituí-lo?", "Confirmar Salvar Arquivo", JOptionPane.YES_NO_OPTION);
                }

                if (confirmacao == 0) {

                    presençaControl.gerarRelatorioAluno(nomeArquivo, raAluno);
                    JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!", "Gerar Relatório", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "Erro: " + ioe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException sqle) {

            JOptionPane.showMessageDialog(null, "Erro: " + sqle.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }  catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um aluno na tabela", "Relatório", JOptionPane.WARNING_MESSAGE);

        }  catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_bRelatorioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscaAlunoEventoControlePresençaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaAlunoEventoControlePresençaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaAlunoEventoControlePresençaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaAlunoEventoControlePresençaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscaAlunoEventoControlePresençaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdicionar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bEditar1;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bExcluir1;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bFechar1;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bNovo1;
    private javax.swing.JButton bRelatorio;
    private javax.swing.JButton bSorteio;
    private javax.swing.JTextField jBuscaNome;
    private javax.swing.JTextField jBuscaRa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem menuGerarRelatorio;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JTable tAlunos;
    private javax.swing.JTable tAlunos1;
    private javax.swing.JTable tEventos;
    private javax.swing.JTable tEventos1;
    private javax.swing.JLabel tRa;
    // End of variables declaration//GEN-END:variables
}


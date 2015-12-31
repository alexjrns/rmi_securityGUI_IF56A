package rmisecuritynm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import rmisecuritynm.model.RmiSecurityNM;

public class PrincipalView extends javax.swing.JFrame {
    public PrincipalView() {
        initComponents();
        atualizaTabela();
        listenerCombos();
        listenerCheckBox();
    }

    public void atualizaTela(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Arquivos de Segurança Java", "policy");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(rootPane);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            String caminho = chooser.getSelectedFile().getAbsolutePath();
            String policyValue = RmiSecurityNM.lerPolicy(caminho).toString();
            policyValue = policyValue.substring(6, policyValue.length() - 2);
            String[] newValue = policyValue.split("\n");            

            DefaultTableModel tbl = new DefaultTableModel(newValue.length, 4);
            String header[] = new String[] { "-", "Parâmetro 1", "Parâmetro 2",
            "Parâmetro 3" };
            tbl.setColumnIdentifiers(header);
            
            jTable1.setModel(tbl);
            for(int i = 0; i < newValue.length; i++){
                String[] newLine = newValue[i].split(" ");
                if(i > 0){
                    for(int k = 0; k < newLine.length; k++){
                        if(k <= newValue.length)
                            jTable1.setValueAt(newLine[k], (i - 1), k);
                    }
                }
            }
        }
    }

    public void gravaPalavra(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Arquivos de Segurança Java (policy)", "policy");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(rootPane);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            String caminho = chooser.getSelectedFile().getAbsolutePath() + ".policy";
            System.out.println("Caminho: " + caminho);
            if(chkTodasPermissoes.isSelected()){
                RmiSecurityNM.writePolicy(caminho, RmiSecurityNM.getValuesAll());
            }else{
                RmiSecurityNM.writePolicy(caminho, RmiSecurityNM.getValuesFromTable(jTable1));
            }
            JOptionPane.showMessageDialog(rootPane, "Arquivo salvo com sucesso!");
        }
    
        /*RmiSecurityNM.writePolicy("/home/hadoop/teste/arquivo.txt", cbbOpcao1.getSelectedItem().toString() + " "
                + cbbOpcao2.getSelectedItem().toString() + " " + cbbOpcao3.getSelectedItem().toString());
        JOptionPane.showMessageDialog(rootPane, "Texto inserido com sucesso!");*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLerArquivo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbbOpcao3 = new javax.swing.JComboBox();
        cbbOpcao1 = new javax.swing.JComboBox();
        txtPermission = new javax.swing.JLabel();
        cbbOpcao2 = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        txtOpcao1 = new javax.swing.JTextField();
        chkTodasPermissoes = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configurar Segurança RMI");
        setResizable(false);

        btnLerArquivo.setText("Abrir Arquivo de Configuração");
        btnLerArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLerArquivoActionPerformed(evt);
            }
        });

        cbbOpcao3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "\"read\"", "\"write\"", "\"execute\"", "\"delete\"" }));

        cbbOpcao1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "java.net.SocketPermission", "java.io.FilePermission", "java.lang.RuntimePermission", "java.util.PropertyPermission", "java.lang.reflect.ReflectPermission" }));
        cbbOpcao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbOpcao1ActionPerformed(evt);
            }
        });

        txtPermission.setText("permission");

        cbbOpcao2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "\"/-\"", "\"createClassLoader\"", "\"setContextClassLoader\"", "\"jboss.i18n.generate-proxies\"" }));

        btnAdd.setText("+ Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        chkTodasPermissoes.setText("Todas as permissões (grant all)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPermission)
                        .addGap(18, 18, 18)
                        .addComponent(cbbOpcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtOpcao1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbOpcao2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbOpcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd))
                    .addComponent(chkTodasPermissoes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkTodasPermissoes)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbOpcao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbOpcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPermission)
                    .addComponent(cbbOpcao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(txtOpcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "-", "Parâmetro 1", "Parâmetro 2", "Parâmetro 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnGravar.setText("Gravar Configurações em Arquivo");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLerArquivo)
                        .addGap(346, 346, 346))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(btnGravar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLerArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGravar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLerArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLerArquivoActionPerformed
        atualizaTela();       
    }//GEN-LAST:event_btnLerArquivoActionPerformed

    private void atualizaTabela(){
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Object selecionado = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
                if ((jTable1.getSelectedRow() > -1) && (selecionado != null)) {
                    cbbOpcao1.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 1));
                    cbbOpcao2.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 2));
                    txtOpcao1.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
                    cbbOpcao3.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 3));
                } else{
                    cbbOpcao1.setSelectedItem("-");
                    cbbOpcao2.setSelectedItem("-");
                    cbbOpcao3.setSelectedItem("-");
                }
            }
        });
    }
    
    /*private void novo(){
        DefaultTableModel tbl = new DefaultTableModel(0, 0);
        String header[] = new String[] { "-", "Parâmentro 1", "Parâmentro 2",
        "Parâmentro 3" };
        tbl.setColumnIdentifiers(header);
        jTable1.setModel(tbl);
        tbl.addRow(new Object[] { "permission", cbbOpcao1.getSelectedItem().toString(), 
            cbbOpcao2.getSelectedItem().toString(), cbbOpcao3.getSelectedItem().toString()});
        tbl.addRow(new Object[] { "", "", "", ""});
        novo = false;
    }*/
    
    private void listenerCombos(){
        txtOpcao1.setVisible(false);
        cbbOpcao1.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbbOpcao1.getSelectedItem() == "java.net.SocketPermission"){
                    cbbOpcao2.setVisible(false);
                    txtOpcao1.setVisible(true);
                }else{
                    cbbOpcao2.setVisible(true);
                    txtOpcao1.setVisible(false);                    
                }
            }
        });   
    }
    
    public void listenerCheckBox(){
        chkTodasPermissoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chkTodasPermissoes.isSelected()){
                    cbbOpcao1.setVisible(false);
                    cbbOpcao2.setVisible(false);
                    cbbOpcao3.setVisible(false);
                    txtOpcao1.setVisible(false);
                    btnAdd.setVisible(false);
                    txtPermission.setVisible(false);
                    
                    jTable1.setValueAt("permission", 0, 0);
                    jTable1.setValueAt("java.security.AllPermission;", 0, 1);
                    jTable1.setValueAt("", 0, 2);
                    jTable1.setValueAt("", 0, 3);
                    //Limpar demais linhas abaixo
                } else{
                    cbbOpcao1.setVisible(true);
                    cbbOpcao2.setVisible(true);
                    cbbOpcao3.setVisible(true);
                    btnAdd.setVisible(true);                    
                    txtPermission.setVisible(true);
                    jTable1.setValueAt("", 0, 0);
                    jTable1.setValueAt("", 0, 1);
                }
            }
        });
    }
    
    private void selecionaCombo(){
        if(cbbOpcao1.getSelectedItem() != "-"){
            int selectRow = jTable1.getSelectedRow();
            if(selectRow == -1)
                selectRow = jTable1.getRowCount() - 1;
            jTable1.setValueAt("permission", selectRow, 0);
            if(cbbOpcao1.getSelectedItem() == "java.net.SocketPermission"){
                jTable1.setValueAt(txtOpcao1.getText(), selectRow, 2);
                txtOpcao1.setText("");
            }else{
                jTable1.setValueAt(cbbOpcao2.getSelectedItem().toString(), selectRow, 2);
            }
            jTable1.setValueAt(cbbOpcao1.getSelectedItem().toString(), selectRow, 1);
            jTable1.setValueAt(cbbOpcao3.getSelectedItem().toString(), selectRow, 3);
            DefaultTableModel modl = (DefaultTableModel) jTable1.getModel();
            modl.addRow(new Object[] { "", "", "", ""});
        }
    }

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        gravaPalavra();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void cbbOpcao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbOpcao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbOpcao1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(cbbOpcao1.getSelectedItem() != "-")
            selecionaCombo();
    }//GEN-LAST:event_btnAddActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnLerArquivo;
    private javax.swing.JComboBox cbbOpcao1;
    private javax.swing.JComboBox cbbOpcao2;
    private javax.swing.JComboBox cbbOpcao3;
    private javax.swing.JCheckBox chkTodasPermissoes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtOpcao1;
    private javax.swing.JLabel txtPermission;
    // End of variables declaration//GEN-END:variables
}

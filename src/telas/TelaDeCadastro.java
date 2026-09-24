package telas;

import java.sql.*;
import dal.Mod_conexao;
import javax.swing.JOptionPane;

public class TelaDeCadastro extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaDeCadastro() {
        initComponents();
        conexao = Mod_conexao.conector();
    }
    
    private void consultar(){
     String sql = "SELECT * FROM TB_Clientes WHERE ID_Cliente = ?";

    try {

        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtId.getText());

        rs = pst.executeQuery();

        if (rs.next()) {

            txtNome.setText(rs.getString("Nome_Cliente"));
            txtEndereco.setText(rs.getString("Endereco_Cliente"));
            txtCidade.setText(rs.getString("Cidade_Cliente"));
            txtUF.setText(rs.getString("UF_Cliente"));
            txtDoc.setText(rs.getString("Documento_Cliente"));
            if (rs.getString("status").equals("PF")) {
    rdPF.setSelected(true);
} else if (rs.getString("status").equals("PJ")) {
    rdPJ.setSelected(true);
}
            txtTelefone.setText(rs.getString("Telefone_Cliente"));
            txtDataNasc.setText(rs.getString("Data_Nasc_Cliente"));
            if (rdPF.isSelected()) {
    pst.setString(8, "PF");
} else if (rdPJ.isSelected()) {
    pst.setString(8, "PJ");
} else {
    JOptionPane.showMessageDialog(null, "Selecione PF ou PJ.");
    return;
}
        } else {

            JOptionPane.showMessageDialog(null,
                    "Cliente não cadastrado.");

        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(null,
                "Erro ao consultar cliente: " + e.getMessage());
    }
}
   private void adicionar(){
  

   String sql = "INSERT INTO TB_Clientes "
        + "(Nome_Cliente, Endereco_Cliente, Cidade_Cliente, UF_Cliente, "
        + "documento_cliente, Telefone_Cliente, Data_Nasc_Cliente, status) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try {

        pst = conexao.prepareStatement(sql);

        pst.setString(1, txtNome.getText());
        pst.setString(2, txtEndereco.getText());
        pst.setString(3, txtCidade.getText());
        pst.setString(4, txtUF.getText());
        pst.setString(5, txtDoc.getText());
        pst.setString(6, txtTelefone.getText());
        pst.setString(7, txtDataNasc.getText());
        if (rdPF.isSelected()) {
    pst.setString(8, "PF");
} else if (rdPJ.isSelected()) {
    pst.setString(8, "PJ");
} else {
    JOptionPane.showMessageDialog(null, "Selecione PF ou PJ.");
    return;
}

        int adicionado = pst.executeUpdate();

        if (adicionado > 0) {

            JOptionPane.showMessageDialog(null,
                    "Cliente cadastrado com sucesso!");

            txtNome.setText(null);
            txtEndereco.setText(null);
            txtCidade.setText(null);
            txtUF.setText(null);
            txtDoc.setText(null);
            txtTelefone.setText(null);
            txtDataNasc.setText(null);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(null,
                "Erro ao adicionar cliente: " + e.getMessage());
    }
}
   
    private void alterar() {
       String sql = "UPDATE TB_Clientes SET "
            + "Nome_Cliente = ?, "
            + "Endereco_Cliente = ?, "
            + "Cidade_Cliente = ?, "
            + "UF_Cliente = ?, "
            + "documento_cliente = ?, "
            + "Telefone_Cliente = ?, "
            + "Data_Nasc_Cliente = ? "
            + "status = ? "
            + "WHERE ID_Cliente = ?";

    try {

        pst = conexao.prepareStatement(sql);

        pst.setString(1, txtNome.getText());
        pst.setString(2, txtEndereco.getText());
        pst.setString(3, txtCidade.getText());
        pst.setString(4, txtUF.getText());
       pst.setString(5, txtDoc.getText());
pst.setString(6, txtTelefone.getText());
pst.setString(7, txtDataNasc.getText());

if (rdPF.isSelected()) {
    pst.setString(8, "PF");
} else if (rdPJ.isSelected()) {
    pst.setString(8, "PJ");
} else {
    JOptionPane.showMessageDialog(null, "Selecione PF ou PJ.");
    return;
}

pst.setString(9, txtId.getText());

        int alterado = pst.executeUpdate();

        if (alterado > 0) {

            JOptionPane.showMessageDialog(null,
                    "Cliente alterado com sucesso!");

        } else {

            JOptionPane.showMessageDialog(null,
                    "Cliente não encontrado.");

        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(null,
                "Erro ao alterar cliente: " + e.getMessage());
    }
}
    private void apagar(){
        int confirma = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza que deseja excluir este cliente?",
            "ATENÇÃO",
            JOptionPane.YES_NO_OPTION
    );

    if (confirma == JOptionPane.YES_OPTION) {

        String sql = "DELETE FROM TB_Clientes WHERE ID_Cliente = ?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtId.getText());

            int apagado = pst.executeUpdate();

            if (apagado > 0) {

                JOptionPane.showMessageDialog(null,
                        "Cliente apagado com sucesso!");

                txtId.setText(null);
                txtNome.setText(null);
                txtEndereco.setText(null);
                txtCidade.setText(null);
                txtUF.setText(null);
                txtDoc.setText(null);
                rdPF.setSelected(false); 
                rdPJ.setSelected(false);  
                txtTelefone.setText(null);
                txtDataNasc.setText(null);
              


            } else {

                JOptionPane.showMessageDialog(null,
                        "Cliente não encontrado.");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar cliente: " + e.getMessage());
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        ID = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtUF = new javax.swing.JTextField();
        txtDoc = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtDataNasc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdPF = new javax.swing.JRadioButton();
        rdPJ = new javax.swing.JRadioButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        ID.setText("ID:");

        nome.setText("Endereco:");

        email.setText("Nome:");

        senha.setText("Cidade:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("TELA CADASTRO");

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUFActionPerformed(evt);
            }
        });

        jLabel2.setText("UF:");

        jLabel3.setText("Documento");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Data Nasc");

        buttonGroup1.add(rdPF);
        rdPF.setText("PF");

        buttonGroup1.add(rdPJ);
        rdPJ.setText("PJ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(nome)
                            .addComponent(senha)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(email))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rdPF)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdPJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVisualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtCidade)
                    .addComponent(txtEndereco)
                    .addComponent(txtNome)
                    .addComponent(txtId)
                    .addComponent(txtUF)
                    .addComponent(txtDoc)
                    .addComponent(txtTelefone)
                    .addComponent(txtDataNasc))
                .addGap(110, 110, 110))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisualizar)
                    .addComponent(btnApagar))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdPF)
                    .addComponent(rdPJ))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // TODO add your handling code here:
        apagar();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel email;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel nome;
    private javax.swing.JRadioButton rdPF;
    private javax.swing.JRadioButton rdPJ;
    private javax.swing.JLabel senha;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtDataNasc;
    private javax.swing.JTextField txtDoc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables
}

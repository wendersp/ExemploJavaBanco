/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Dimension;
import modelo.entidade.Usuario;

/**
 *
 * @author wender
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        //Maximizar a tela
        this.setExtendedState(MAXIMIZED_BOTH); 

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMnCadastro = new javax.swing.JMenu();
        jMnItEstado = new javax.swing.JMenuItem();
        jMnItCidade = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMnItBanco = new javax.swing.JMenuItem();
        jMnItAgencia = new javax.swing.JMenuItem();
        jMnItCliente = new javax.swing.JMenuItem();
        jMnItConta = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMnItSair = new javax.swing.JMenuItem();
        jMnMovimentacao = new javax.swing.JMenu();
        jMnItDeposito = new javax.swing.JMenuItem();
        jMnItSaque = new javax.swing.JMenuItem();
        jMnItSaldo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Bancario 1.0");

        jMnCadastro.setMnemonic('C');
        jMnCadastro.setText("Cadastro");

        jMnItEstado.setText("Estado");
        jMnItEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItEstadoActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnItEstado);

        jMnItCidade.setText("Cidade");
        jMnItCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItCidadeActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnItCidade);
        jMnCadastro.add(jSeparator2);

        jMnItBanco.setMnemonic('B');
        jMnItBanco.setText("Banco");
        jMnItBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItBancoActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnItBanco);

        jMnItAgencia.setText("Agencia");
        jMnItAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItAgenciaActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnItAgencia);

        jMnItCliente.setText("Cliente");
        jMnCadastro.add(jMnItCliente);

        jMnItConta.setText("Conta");
        jMnCadastro.add(jMnItConta);
        jMnCadastro.add(jSeparator1);

        jMnItSair.setText("Sair");
        jMnItSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItSairActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnItSair);

        jMenuBar1.add(jMnCadastro);

        jMnMovimentacao.setText("Movimentação");

        jMnItDeposito.setText("Deposito");
        jMnMovimentacao.add(jMnItDeposito);

        jMnItSaque.setText("Saque");
        jMnMovimentacao.add(jMnItSaque);

        jMnItSaldo.setText("Saldo");
        jMnMovimentacao.add(jMnItSaldo);

        jMenuBar1.add(jMnMovimentacao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnItSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnItSairActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMnItSairActionPerformed

    private void jMnItBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnItBancoActionPerformed
        BancoCons bancoCons = new BancoCons(this, true);
        bancoCons.setVisible(true);
    }//GEN-LAST:event_jMnItBancoActionPerformed

    private void jMnItAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnItAgenciaActionPerformed
         new AgenciaFrm(this,true ).setVisible(true);
    }//GEN-LAST:event_jMnItAgenciaActionPerformed

    private void jMnItEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnItEstadoActionPerformed
          new EstadoCons(this, true).setVisible(true);
    }//GEN-LAST:event_jMnItEstadoActionPerformed

    private void jMnItCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnItCidadeActionPerformed
          new CidadeCons(this, true).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMnItCidadeActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMnCadastro;
    private javax.swing.JMenuItem jMnItAgencia;
    private javax.swing.JMenuItem jMnItBanco;
    private javax.swing.JMenuItem jMnItCidade;
    private javax.swing.JMenuItem jMnItCliente;
    private javax.swing.JMenuItem jMnItConta;
    private javax.swing.JMenuItem jMnItDeposito;
    private javax.swing.JMenuItem jMnItEstado;
    private javax.swing.JMenuItem jMnItSair;
    private javax.swing.JMenuItem jMnItSaldo;
    private javax.swing.JMenuItem jMnItSaque;
    private javax.swing.JMenu jMnMovimentacao;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private Usuario usuarioLogado;
    
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        this.setTitle(this.getTitle() + " - " + this.usuarioLogado.getNome());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccineappdesktop;

import com.muslumyusuf.VaccineApp;
import com.muslumyusuf.VaccineApp_Service;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author muslumoncel
 */
public class DoctorMain extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();

	/**
	 * Creates new form DoctorMain
	 */
	public DoctorMain() {
		initComponents();
		setLocationRelativeTo(null);
		defaultTableModel = (DefaultTableModel) commentTable.getModel();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jComboBox1 = new javax.swing.JComboBox();
                getCommentButton = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                commentTable = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RVA", " " }));

                getCommentButton.setText("Get Comments");
                getCommentButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                getCommentButtonActionPerformed(evt);
                        }
                });

                commentTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "USERNAME", "VACCINE NAME", "COMMENT", "COMMENT DATE"
                        }
                ));
                jScrollPane1.setViewportView(commentTable);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(getCommentButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(getCommentButton))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void getCommentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCommentButtonActionPerformed
		// TODO add your handling code here:
		JSONObject jSONObject;
		try {
			VaccineApp_Service app_Service = new VaccineApp_Service();
			VaccineApp app = app_Service.getVaccineAppPort();
			jSONObject = new JSONObject(app.getComment(jComboBox1.getSelectedItem().toString(), 0, 10));
			JSONArray array = jSONObject.getJSONArray("COMMENTS");
			for (int i = 0; i < array.length(); i++) {
				JSONObject temp = array.getJSONObject(i);
				Lists.comments.add(new Comment(temp.getString(Tags.COMMENT), temp.getString(Tags.COMMENT_DATE), temp.getString(Tags.VACCINE_NAME), temp.getString(Tags.USERNAME)));
				defaultTableModel.addRow(new Object[]{temp.getString(Tags.USERNAME), temp.getString(Tags.VACCINE_NAME), temp.getString(Tags.COMMENT), temp.getString(Tags.COMMENT_DATE)});
			}
		} catch (Exception e) {
		}
        }//GEN-LAST:event_getCommentButtonActionPerformed

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
			java.util.logging.Logger.getLogger(DoctorMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DoctorMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DoctorMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DoctorMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> {
			new DoctorMain().setVisible(true);
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTable commentTable;
        private javax.swing.JButton getCommentButton;
        private javax.swing.JComboBox jComboBox1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author lasin
 */
public class MenuDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form MenuDangNhap
     */
    public MenuDangNhap() {
        initComponents();
        Image img = new ImageIcon(this.getClass().getResource("/Image/score.png")).getImage();
        this.setIconImage(img);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        myButton1 = new Form.MyButton();
        myButton2 = new Form.MyButton();
        myButton3 = new Form.MyButton();
        myButton4 = new Form.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cổng thông tin điển tử ");
        setBackground(new java.awt.Color(153, 204, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hệ thống quản lí điểm ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chào mừng bạn, vui lòng chọn mục đăng nhập");

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/student.png"))); // NOI18N
        myButton1.setText("Đăng nhập với vai trò sinh viên");
        myButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        myButton1.setRadius(50);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SinhvienActionPerformed(evt);
            }
        });

        myButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/school.png"))); // NOI18N
        myButton2.setText("Đăng nhập với vai trò Giáo Viên");
        myButton2.setBorderColor(new java.awt.Color(0, 0, 255));
        myButton2.setColorClick(new java.awt.Color(102, 102, 255));
        myButton2.setColorOver(new java.awt.Color(204, 204, 255));
        myButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        myButton2.setRadius(50);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GiaoVienActionPerformed(evt);
            }
        });

        myButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user.png"))); // NOI18N
        myButton3.setText("Đăng nhập với vai trò Admin");
        myButton3.setBorderColor(new java.awt.Color(255, 153, 0));
        myButton3.setBorderPainted(false);
        myButton3.setColorClick(new java.awt.Color(255, 153, 102));
        myButton3.setColorOver(new java.awt.Color(255, 204, 153));
        myButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        myButton3.setRadius(50);
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QuanLiActionPerformed(evt);
            }
        });

        myButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancels.png"))); // NOI18N
        myButton4.setText("Thoát");
        myButton4.setBorderColor(new java.awt.Color(255, 0, 0));
        myButton4.setColorClick(new java.awt.Color(255, 102, 102));
        myButton4.setColorOver(new java.awt.Color(255, 204, 204));
        myButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        myButton4.setRadius(50);
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_SinhvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SinhvienActionPerformed
        FormDangNhapSV svdn=new FormDangNhapSV();
        svdn.setLocation(400,200);
        svdn.setVisible(true);
    }//GEN-LAST:event_Btn_SinhvienActionPerformed

    private void Btn_GiaoVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GiaoVienActionPerformed
        FormDangNhapGV gvdn=new FormDangNhapGV();
        gvdn.setLocation(400,200);
        gvdn.setVisible(true);
    }//GEN-LAST:event_Btn_GiaoVienActionPerformed

    private void Btn_QuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QuanLiActionPerformed
        FormDangNhapAdmin loginaAdmin=new FormDangNhapAdmin();
        loginaAdmin.setLocation(400,200);
        loginaAdmin.setVisible(true);
    }//GEN-LAST:event_Btn_QuanLiActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_myButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private Form.MyButton myButton1;
    private Form.MyButton myButton2;
    private Form.MyButton myButton3;
    private Form.MyButton myButton4;
    // End of variables declaration//GEN-END:variables
}

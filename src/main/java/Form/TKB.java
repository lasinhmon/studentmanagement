/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;
import Repository.GiaoVien_Helper;
import Domain.Lop;
import Domain.LopHocPhan;
import Repository.JdbcLop;
import Repository.JdbcLopHocPhan;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
//tu ten giao vien tim ra tkb cua giao vien do (da lam)
//load khoa-> chon khoa ->load cac lop hoc phan theo khoa
//tu lop hoc phan load cac niem khoa + hoc ki co trong nhung lhp ay
//tu day chon ra lop
/**
 *
 * @author lasin
 */
public class TKB extends javax.swing.JFrame {
    GiaoVien_Helper load=new GiaoVien_Helper();
    JdbcLop listlop;
    List<Lop> list,listgv;
    List<String>mh,lop,khoa;
    String ten,tinhieu;
    String ms,hocki,nienkhoa;
    public TKB() {
        initComponents();   
    }
    public void loadTKB(){
        listgv=new ArrayList<>();    
        mh=load.LoadMonhoc();
        for(String mon :mh)
            cb_mon.addItem(mon);
        khoa=load.LoadKhoa();
        for(String k :khoa)
            cb_khoa.addItem(k);
        cb_mon.setSelectedIndex(0);
        lop=load.LoadLop();
        for(int i=1;i<=999;i++){
            boolean flag=true;
            for(String l:lop){
                if(i==Integer.parseInt(l.substring(1)))
                {
                    flag=false;    
                    break;
                }              
            } 
            if(flag){
                if(i<10)
                    cb_lop.addItem("L00"+Integer.toString(i));
                else if(i>=10 && i<100){
                    cb_lop.addItem("L0"+Integer.toString(i));
                }                    
                else
                    cb_lop.addItem("L"+Integer.toString(i));
            }
        }
        cb_lop.setSelectedIndex(0);
        
        list=listlop.loadTKB(ten,hocki);
        if(!list.isEmpty()){
            displaytable(list);
        }
        else{ 
            listgv=listlop.loadTKB_GV(ten,nienkhoa,hocki);
            displaytable(listgv);
        }
       
        cb_sotc.removeAllItems();
        for(int i=2;i<=6;i++)
            cb_sotc.addItem(Integer.toString(i));
        
    }

    
    void displaytable(List<Lop>tam){
        jTable1.getColumnModel().getColumn(1).setCellRenderer( new TextAreaRenderer2()); 
        DefaultTableModel modelb=(DefaultTableModel) jTable1.getModel();
        modelb.setRowCount(2);//de reset table
        if(!tam.isEmpty()){
            for(Lop lop :tam){
                jTable1.getColumnModel().getColumn(lop.getNgayHoc()-2).setCellRenderer( new TextAreaRenderer2()); 
                String chuoi=lop.getMaLHP()+"\n"+lop.getMaMH()+"\n"+lop.getMaGV();
                modelb.setValueAt(chuoi, lop.getCaHoc()-1,lop.getNgayHoc()-2);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Nhap sai ma", "Canh bao: ", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    public TKB(String check,String tam,String nk,String hk){
        listlop=new JdbcLop();
        ten=tam;
        nienkhoa=nk;
        hocki=hk;
        tinhieu=check;
        ms=listlop.findID(ten);    
        initComponents();
        Image img = new ImageIcon(this.getClass().getResource("/Image/schedule.png")).getImage();
        this.setIconImage(img);
        txt_hk.setText(hk);
        txt_nk.setText(nk);
        if(!tinhieu.equals("admin")){
            btn_them.setEnabled(false);
            btn_them.setVisible(false);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_ca = new javax.swing.JTextField();
        cb_lop = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_mon = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_khoa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_thu = new javax.swing.JTextField();
        cb_sotc = new javax.swing.JComboBox<>();
        txt_hk = new javax.swing.JTextField();
        txt_nk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_them = new Form.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thời Khóa Biểu");
        setBackground(new java.awt.Color(51, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thời khóa biểu ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7"
            }
        ));
        jTable1.setRowHeight(100);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng chức năng ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/online-conference.png"))); // NOI18N
        jLabel4.setText("Ca Học:");

        txt_ca.setEditable(false);
        txt_ca.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 255)));

        cb_lop.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        cb_lop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_lopActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lecture.png"))); // NOI18N
        jLabel1.setText("Mã Lớp HP:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plan.png"))); // NOI18N
        jLabel5.setText("Niên Khóa:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/semester.png"))); // NOI18N
        jLabel6.setText("Học Kì:");

        cb_mon.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reading-book.png"))); // NOI18N
        jLabel7.setText("Số Tín Chỉ:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/notes.png"))); // NOI18N
        jLabel2.setText("Môn Học:");

        cb_khoa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 102)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/7-days.png"))); // NOI18N
        jLabel3.setText("Thứ:");

        txt_thu.setEditable(false);
        txt_thu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 255)));

        cb_sotc.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));

        txt_hk.setEditable(false);
        txt_hk.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 255)));

        txt_nk.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 255)));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/books.png"))); // NOI18N
        jLabel8.setText("Khoa:");

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/new-file.png"))); // NOI18N
        btn_them.setText("Thêm môn học");
        btn_them.setToolTipText("");
        btn_them.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_them.setRadius(50);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_sotc, 0, 137, Short.MAX_VALUE)
                            .addComponent(txt_hk))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_lop, 0, 119, Short.MAX_VALUE)
                            .addComponent(txt_thu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_mon, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ca, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(txt_thu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_sotc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(cb_mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cb_lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(tinhieu.equals("admin")){
            txt_ca.setText(Integer.toString(jTable1.rowAtPoint(evt.getPoint())+1));
            txt_thu.setText(Integer.toString(jTable1.columnAtPoint(evt.getPoint())+2));
            GiaoVien_Helper help=new GiaoVien_Helper();
            if(help.kiemtralichtrong(jTable1.columnAtPoint(evt.getPoint())+2, jTable1.rowAtPoint(evt.getPoint())+1, Integer.parseInt(hocki))>0){
                JOptionPane.showMessageDialog(this,"Khong Xep duoc");
                btn_them.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(this,"Xep dc");
                btn_them.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        listlop=new JdbcLop();
        int soo=listlop.insertGiangDay(cb_lop.getSelectedItem().toString(), ms, cb_mon.getSelectedItem().toString().substring(0,4).trim(), Integer.parseInt(txt_hk.getText()),txt_nk.getText(),Integer.parseInt(cb_sotc.getSelectedItem().toString()), Integer.parseInt(txt_thu.getText()), Integer.parseInt(txt_ca.getText()));
        if(soo>0)
            JOptionPane.showMessageDialog(this,"insert thanh cong");
        loadTKB(); 
        btn_them.setEnabled(false);
       // }
       // else{
        //    JOptionPane.showMessageDialog(this,"luu that bai");

       //}
    }//GEN-LAST:event_btn_themActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadTKB(); 
        btn_them.setEnabled(false);
      //  JOptionPane.showMessageDialog(this,cb_khoa.getSelectedItem().toString());
    }//GEN-LAST:event_formWindowOpened

    private void cb_lopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_lopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_lopActionPerformed
    
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Form.MyButton btn_them;
    private javax.swing.JComboBox<String> cb_khoa;
    private javax.swing.JComboBox<String> cb_lop;
    private javax.swing.JComboBox<String> cb_mon;
    private javax.swing.JComboBox<String> cb_sotc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_ca;
    private javax.swing.JTextField txt_hk;
    private javax.swing.JTextField txt_nk;
    private javax.swing.JTextField txt_thu;
    // End of variables declaration//GEN-END:variables
}

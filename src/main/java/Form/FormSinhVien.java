/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import Domain.LopHocPhan;
import Repository.JdbcLopHocPhan;
import Repository.JdbcSinhVien;
import Repository.SinhVien_Helper;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormSinhVien extends javax.swing.JFrame {

    List<LopHocPhan>listhp;
    String ms;
    JdbcSinhVien listsv;
    JdbcLopHocPhan listlhp;
    public FormSinhVien() {
        initComponents();      
    }
    public FormSinhVien(String tam) {
        ms=tam;
        initComponents();
        Image img = new ImageIcon(this.getClass().getResource("/Image/student.png")).getImage();
        this.setIconImage(img);
        SetThongtinSV();
        Displaycombobox();
    }
     private void SetThongtinSV(){
        listsv=new JdbcSinhVien();
        Object otam[]=listsv.thongtinsinhvien(ms);
        txt_ten.setText(otam[0].toString());
        txt_mssv.setText(otam[1].toString());
        
        if((Integer.parseInt(otam[2].toString()))==1)
        {
            txt_gioitinh.setText("Nữ");
        }
        else
            txt_gioitinh.setText("Nam");
        txt_khoa.setText(otam[3].toString());
        txt_sdt.setText(otam[4].toString());   
    }
    private void Displaycombobox()
    {
        listlhp=new JdbcLopHocPhan();
        Cb_namhoc.removeAllItems();
        Cb_hocki.removeAllItems();
        Cb_hediem.removeAllItems();
        Cb_hediem.addItem("4");
        Cb_hediem.addItem("10");
        Cb_hediem.addItem("Hệ chữ");
        listhp=listlhp.select2(txt_mssv.getText());
        for(int i=1;i<=8;i++)
            Cb_hocki.addItem(Integer.toString(i));
        Cb_namhoc.addItem("All");
        String tam=" ";
        for(LopHocPhan l: listhp){
            if(!l.getNienKhoa().equals(tam)){
                Cb_namhoc.addItem(l.getNienKhoa());
                tam=l.getNienKhoa();
            }
        }   
    }
    int dem1=0,dem2=0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_Thongtin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_sdt = new java.awt.TextField();
        txt_khoa = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ten = new java.awt.TextField();
        txt_mssv = new java.awt.TextField();
        txt_gioitinh = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_dangxuat = new Form.MyButton();
        btn_lichhoc = new Form.MyButton();
        jP_Ketqua = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Cb_hediem = new javax.swing.JComboBox<>();
        Cb_hocki = new javax.swing.JComboBox<>();
        Cb_namhoc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_tb = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();
        txt_xl = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sinh Viên");

        jP_Thongtin.setBackground(new java.awt.Color(0, 153, 153));
        jP_Thongtin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Mã số sinh viên:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Họ tên sinh viên:");

        txt_sdt.setEditable(false);
        txt_sdt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txt_khoa.setEditable(false);
        txt_khoa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Giới tính:");

        txt_ten.setEditable(false);
        txt_ten.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txt_mssv.setEditable(false);
        txt_mssv.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txt_gioitinh.setEditable(false);
        txt_gioitinh.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Mã Khoa:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("SĐT:");

        btn_dangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancels.png"))); // NOI18N
        btn_dangxuat.setText("Đăng Xuất");
        btn_dangxuat.setBorderColor(new java.awt.Color(255, 0, 0));
        btn_dangxuat.setColorClick(new java.awt.Color(255, 102, 102));
        btn_dangxuat.setColorOver(new java.awt.Color(255, 204, 204));
        btn_dangxuat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_dangxuat.setRadius(50);
        btn_dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_dangxuatActionPerformed(evt);
            }
        });

        btn_lichhoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/schedule.png"))); // NOI18N
        btn_lichhoc.setText("Lịch Học");
        btn_lichhoc.setBorderColor(new java.awt.Color(0, 0, 255));
        btn_lichhoc.setColorClick(new java.awt.Color(102, 102, 255));
        btn_lichhoc.setColorOver(new java.awt.Color(204, 204, 255));
        btn_lichhoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_lichhoc.setRadius(50);
        btn_lichhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lichActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_ThongtinLayout = new javax.swing.GroupLayout(jP_Thongtin);
        jP_Thongtin.setLayout(jP_ThongtinLayout);
        jP_ThongtinLayout.setHorizontalGroup(
            jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ThongtinLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_mssv, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_ThongtinLayout.createSequentialGroup()
                        .addComponent(txt_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ThongtinLayout.createSequentialGroup()
                .addGap(545, 545, 545)
                .addComponent(btn_lichhoc, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jP_ThongtinLayout.setVerticalGroup(
            jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ThongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jP_ThongtinLayout.createSequentialGroup()
                        .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txt_mssv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jP_ThongtinLayout.createSequentialGroup()
                        .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_khoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jP_ThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lichhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jP_Ketqua.setBackground(new java.awt.Color(255, 255, 204));
        jP_Ketqua.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết quả học tập ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MHP", "Tên Môn Học", "Tín Chỉ", "Điểm giữa kì", "Điểm cuối kì", "Điểm TB"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plan.png"))); // NOI18N
        jLabel8.setText("Niên Khóa:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/semester.png"))); // NOI18N
        jLabel9.setText("Học Kỳ:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/numeric.png"))); // NOI18N
        jLabel10.setText("Hệ Điểm:");

        Cb_hediem.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        Cb_hediem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_hediemActionPerformed(evt);
            }
        });

        Cb_hocki.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        Cb_hocki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_hockiActionPerformed(evt);
            }
        });

        Cb_namhoc.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        Cb_namhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_namhocActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/review.png"))); // NOI18N
        jLabel7.setText("Điểm Trung Bình:");

        txt_tb.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/number-one.png"))); // NOI18N
        jLabel11.setText("Xếp Loại:");

        txt_xl.setEditable(false);

        javax.swing.GroupLayout jP_KetquaLayout = new javax.swing.GroupLayout(jP_Ketqua);
        jP_Ketqua.setLayout(jP_KetquaLayout);
        jP_KetquaLayout.setHorizontalGroup(
            jP_KetquaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_KetquaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_KetquaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_KetquaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cb_namhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cb_hocki, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cb_hediem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_KetquaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_KetquaLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_xl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_KetquaLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_tb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jP_KetquaLayout.setVerticalGroup(
            jP_KetquaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_KetquaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jP_KetquaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Cb_hocki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(Cb_hediem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cb_namhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jP_KetquaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txt_tb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_KetquaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txt_xl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Ketqua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jP_Thongtin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jP_Thongtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_Ketqua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_dangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_dangxuatActionPerformed
        FormDangNhapSV formDangNhapSV=new FormDangNhapSV();
        formDangNhapSV.setVisible(true);
        this.setVisible(false);
        formDangNhapSV.setLocation(400,400);

    }//GEN-LAST:event_Btn_dangxuatActionPerformed

    private void btn_lichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lichActionPerformed

        TKB tkb=new TKB("sinhvien",txt_mssv.getText(),Cb_namhoc.getSelectedItem().toString(),Cb_hocki.getSelectedItem().toString());
        tkb.setVisible(true);
        tkb.setLocation(400,100);
    }//GEN-LAST:event_btn_lichActionPerformed

    private void Cb_hockiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_hockiActionPerformed
        dem1++;
        if(dem1>1)
        xemDiem();
    }//GEN-LAST:event_Cb_hockiActionPerformed

    private void Cb_namhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_namhocActionPerformed
        dem2++;
        if(dem2>1)
        xemDiem();
    }//GEN-LAST:event_Cb_namhocActionPerformed

    private void Cb_hediemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_hediemActionPerformed
        if(dem1>1 || dem2>1){
            if(Cb_hediem.getSelectedIndex()==0){
                for(int i=0;i<jTable1.getRowCount();i++){
                    SinhVien_Helper help=new SinhVien_Helper();
                    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    model.setValueAt(help.ThaydoiCosoDiem(0, (float)jTable1.getValueAt(i, 6)), i, 6);
                }
            }
        }
    }//GEN-LAST:event_Cb_hediemActionPerformed
    private void xemDiem()
    {
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int so=1;
        float tong=0;
        int tc=0;
        for(LopHocPhan lhp :listhp){
            if(lhp.getHocKy()==Integer.parseInt(Cb_hocki.getSelectedItem().toString())&&lhp.getNienKhoa().equals(Cb_namhoc.getSelectedItem().toString())){
                SinhVien_Helper help=new SinhVien_Helper();
                model.addRow(help.DisplayTable(so,lhp));
                tong=tong+(lhp.getDiemTB()*lhp.getSoTC());
                tc=tc+lhp.getSoTC();
                so++;
            }
            else if(Cb_namhoc.getSelectedItem().toString().equals("All")){
                SinhVien_Helper help=new SinhVien_Helper();
                model.addRow(help.DisplayTable(so,lhp));
                so++;
            }
        }
        float tinh=(float)tong/tc;
        DecimalFormat df = new DecimalFormat("#.##");
        txt_tb.setText(df.format(tinh*100/100D));
        if(tinh==0)
            txt_xl.setText(Integer.toString(0));
        else
            if(tinh<4)
                txt_xl.setText("Rot mon");
            else if(tinh<5&&tinh>=4)
                txt_xl.setText("Yeu");
            else if(tinh<6.5&&tinh>=5)
                txt_xl.setText("Trung binh");
            else if(tinh<7&&tinh>=6.5)
                txt_xl.setText("Trung binh kha");
            else if(tinh<8.5&&tinh>=7)
                txt_xl.setText("Kha");
            else 
                txt_xl.setText("Gioi");
        
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cb_hediem;
    private javax.swing.JComboBox<String> Cb_hocki;
    private javax.swing.JComboBox<String> Cb_namhoc;
    private Form.MyButton btn_dangxuat;
    private Form.MyButton btn_lichhoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_Ketqua;
    private javax.swing.JPanel jP_Thongtin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.TextField txt_gioitinh;
    private java.awt.TextField txt_khoa;
    private java.awt.TextField txt_mssv;
    private java.awt.TextField txt_sdt;
    private java.awt.TextField txt_tb;
    private java.awt.TextField txt_ten;
    private java.awt.TextField txt_xl;
    // End of variables declaration//GEN-END:variables
}

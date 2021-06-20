/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.GUI;

import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import gymer.DAO.*;
import gymer.entities.*;
import gymer.utilities.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Linh
 */
public class QL_thietbi extends javax.swing.JInternalFrame {

    /**
     * Creates new form QL_thietbi
     */
    
    private Employee em = new Employee ();
    private EquipmentImp eqi = new EquipmentImp();
    private Equipment eq = new Equipment();
    private int count = 0;
    
    
    public void setEm (Employee input) {
        this.em = input;
    }
    
    public QL_thietbi() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        jComboBox1.setEnabled(true);
        showData(eqi.getAll());
    }
    
    
    private void setDatatoEnity (Equipment eq1){
        eq1.setMaTB(jTextField3.getText());
        eq1.setTen(jTextField2.getText());
        eq1.setNgayNhap(DateTime.convertDB(jTextField7.getText()));
        eq1.setSoLuong(Integer.parseInt(jTextField5.getText()));
        eq1.setTinhTrang(jComboBox1.getSelectedItem().toString());
        eq1.setGiaNhap(Integer.parseInt(jTextField8.getText()));
        eq1.setNSX(jTextField4.getText());
    }
    
    private void showData (List<Equipment> input) {
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        Object row[] = new Object[7];
        int countDead = 0;
        for (int i=0 ; i<input.size() ; i++){
            row[0] = input.get(i).getMaTB();
            row[1] = input.get(i).getTen();
            row[2] = input.get(i).getNSX();
            row[3] = input.get(i).getSoLuong();
            row[4] = input.get(i).getTinhTrang();
            if (input.get(i).getTinhTrang().equals("Hỏng")){
                countDead++;
            }
            row[5] = DateTime.convertReadable(input.get(i).getNgayNhap());
            row[6] = input.get(i).getGiaNhap();
            model.addRow(row);
            jTextField9.setText(Integer.toString(input.size()));
            jTextField10.setText(Integer.toString(input.size() - countDead));
            jTextField11.setText(Integer.toString(countDead));
        }
    }
    
    private void getSelectedRow () {
        jComboBox1.setEditable(true);
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        jTextField3.setText(model.getValueAt(selectedRow, 0).toString());
        jTextField2.setText(model.getValueAt(selectedRow, 1).toString());
        jTextField4.setText(model.getValueAt(selectedRow, 2).toString());
        jTextField5.setText(model.getValueAt(selectedRow, 3).toString());
        jComboBox1.getEditor().setItem(model.getValueAt(selectedRow, 4).toString());
        jTextField7.setText(model.getValueAt(selectedRow, 5).toString());
        jTextField8.setText(model.getValueAt(selectedRow, 6).toString());
        setDatatoEnity(this.eq);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField11 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 597));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("DANH SÁCH THIẾT BỊ");
        jLabel1.setAlignmentY(0.0F);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 23, -1, 59));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên", "NSX", "Số lượng", "Tình trạng", "Ngày nhập", "Giá nhập"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 620, 290));

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField11.setText("1000");
        jTextField11.setBorder(null);
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 93, 65, 47));

        jLabel35.setText("Hỏng");
        jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 143, 65, 26));

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField10.setText("1000");
        jTextField10.setBorder(null);
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 93, 65, 47));

        jLabel34.setText("Dùng tốt");
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 143, 65, 26));

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField9.setText("1000");
        jTextField9.setBorder(null);
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 93, 65, 47));

        jLabel33.setText("THiết bị");
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 143, 65, 26));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_button_add.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_button_fix.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_button_del.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_search.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(924, 93, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 93, 257, -1));

        jPanel7.setBackground(new java.awt.Color(234, 230, 230));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/GUI/icon_user_blue.png"))); // NOI18N

        jTextField2.setForeground(new java.awt.Color(102, 102, 102));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Tên thiết bị");
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel24.setText("Mã dịch vụ");

        jTextField3.setEditable(false);

        jLabel26.setText("NSX");

        jLabel27.setText("Số lượng");

        jLabel28.setText("Tình trạng");

        jLabel29.setText("Ngày nhập");

        jLabel30.setText("Giá nhập");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tốt", "Hỏng" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField7)
                                    .addComponent(jTextField8)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel25)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        getSelectedRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        String search = jTextField1.getText();
        if (jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập gì cả");
        }
        showData(eqi.findByString(search));
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Equipment temp = new Equipment();
        this.count++;
        if (this.count % 2 != 0) {
            jComboBox1.setEditable(true);
            jTextField2.setText("");
            jTextField3.setText(KeyDB.genKey());
            jTextField4.setText("");
            jTextField5.setText("");
            jComboBox1.getEditor().setItem("Tốt");
            jTextField7.setText(DateTime.getTimeFormat2());
            jTextField8.setText("");
        }
        else {
            if (
                jTextField2.getText().equals("") ||
                jTextField4.getText().equals("") ||
                jTextField5.getText().equals("") ||
                jTextField7.getText().equals("") ||
                jTextField8.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập gì cả xin hãy kiểm tra lại !");
            }
            else {
                setDatatoEnity(temp);
                if (eqi.insert(temp)){
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    showData(eqi.getAll());
                }
                else JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình thêm vui lòng thử lại");
            }
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        showData(eqi.getAll());
    }//GEN-LAST:event_formMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        Equipment temp = new Equipment();
        setDatatoEnity(temp);
        if (temp.getGiaNhap() == eq.getGiaNhap()
                && temp.getTinhTrang().equals(eq.getTinhTrang())
                && temp.getNSX().equals(eq.getNSX())
                && temp.getTen().equals(eq.getTen())
                && temp.getSoLuong() == eq.getSoLuong()
                && temp.getNgayNhap().equals(eq.getNgayNhap())
                ) {
            JOptionPane.showMessageDialog(null, "Bạn chưa thay đổi gì !");
        }
        else {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa ?");
            if(dialogButton == JOptionPane.YES_OPTION){
                if (eqi.update(temp)){
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    showData(eqi.getAll());
                }
                else JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình thêm vui lòng thử lại");
            }
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa ?");
        if (dialogButton == JOptionPane.YES_OPTION) {
            if (eqi.delete(this.eq.getMaTB())){
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                String Reason = JOptionPane.showInputDialog("Lý do xóa");
                LogFile.createDeleteLog(em.getMaNV(), em.getTen(), eq.getMaTB(), Reason, LogFile.THIETBI);
                showData(eqi.getAll());
            }
            else JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình xóa vui lòng thử lại");
        }
    }//GEN-LAST:event_jLabel7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}

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
import java.awt.Color;
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
        jTextField10 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
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
        jLabel31 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1230, 650));
        setPreferredSize(new java.awt.Dimension(1230, 650));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("DANH SÁCH THIẾT BỊ");
        jLabel1.setAlignmentY(0.0F);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, 59));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên", "NSX", "Số lượng", "Tình trạng", "Ngày nhập", "Giá nhập"
            }
        ));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 850, 320));

        jTextField11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("1000");
        jTextField11.setBorder(null);
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 65, 30));

        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("1000");
        jTextField10.setBorder(null);
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, 65, 30));

        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("1000");
        jTextField9.setBorder(null);
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 80, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/Thêm.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 540, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/Sửa .png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 540, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/Xóa.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 540, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_search.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 118, 460, -1));

        jPanel7.setBackground(new java.awt.Color(234, 230, 230));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/GUI/icon_user_blue.png"))); // NOI18N

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(102, 102, 102));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Mã dịch vụ");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("NSX");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Số lượng");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Tình trạng");

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Ngày nhập");

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Giá nhập");

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tốt", "Hỏng" }));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Tên thiết bị");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel25))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 209, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
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
                .addContainerGap(177, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 630));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/find.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 560, 60));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Hỏng");
        jLabel36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 580, 60, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Thiết bị");
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 60, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Dùng tốt");
        jLabel38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 60, -1));

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

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        if (!Regex.NumericCheck(jTextField5.getText())) {
            jTextField5.setForeground(Color.red);
            jLabel5.setVisible(false);
        }
        else {
            jTextField5.setForeground(Color.black);
            jLabel5.setVisible(true);
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
        if (!Regex.NumericCheck(jTextField8.getText())) {
            jTextField8.setForeground(Color.red);
            jLabel5.setVisible(false);
        }
        else {
            jTextField8.setForeground(Color.black);
            jLabel5.setVisible(true);
        }
    }//GEN-LAST:event_jTextField8KeyReleased


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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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

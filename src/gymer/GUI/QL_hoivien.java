/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.GUI;
import gymer.DAO.*;
import gymer.entities.*;
import gymer.utilities.*;
import java.awt.Color;
import gymer.utilities.*;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Linh
 */
public class QL_hoivien extends javax.swing.JInternalFrame {
    private Employee em = new Employee ();
    private CustomerImp eqi = new CustomerImp();
    private Customer eq = new Customer();
    private int count = 0;
    
    
    DefaultTableModel model;
    Color Color_table;
    /**
     * Creates new form QL_hoivien
     */
    
    public void setEm (Employee input) {
        this.em = input;
    }
    
    public QL_hoivien() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
       
        showData(eqi.getAll());
        jComboBox2.setEnabled(true);
        model = (DefaultTableModel)tb_hoivien.getModel();
        Color_table= new Color(62,120,202);
        tb_hoivien.setSelectionBackground(Color_table);
        tb_hoivien.setSelectionForeground(new Color(255,255,255));
        tb_hoivien.setColumnSelectionAllowed(false);
 
        
        
    }
    
    private void showData (List<Customer> input) {
        DefaultTableModel model = (DefaultTableModel)tb_hoivien.getModel();
        model.setRowCount(0);
        Object row[] = new Object[7];
        int countDead = 0;
        for (int i=0 ; i<input.size() ; i++){
            row[0] = input.get(i).getID();
            row[1] = input.get(i).getName();
            row[2] = input.get(i).getSDT();
            row[3] = input.get(i).getCMND();
            row[4] = input.get(i).getYearofBirh();
            if (input.get(i).getSex()){
                row[5] = "Nữ";
            }
            else{ row[5] = "Nam"; }
            row[6] = input.get(i).getAddress();
            model.addRow(row);
            jTextField9.setText(Integer.toString(input.size()));
        }
    }
    
    private void setDatatoEnity (Customer eq1){
        jComboBox2.setEditable(true);
        eq1.setID(jTextField2.getText());
        eq1.setCMND(jTextField5.getText());
        eq1.setName(jTextField1.getText());
        eq1.setYearofBirh(Integer.parseInt(jTextField7.getText()));
        eq1.setSDT(jTextField4.getText());
        if (jComboBox2.getSelectedItem().toString().equals("Nam")){
            eq1.setSex(false);
        }
        if (jComboBox2.getSelectedItem().toString().equals("Nữ")){
            eq1.setSex(true);
        }
        eq1.setAddress(jTextField3.getText());
    }
    
    private void getSelectedRow () {
        jComboBox2.setEditable(true);
        DefaultTableModel model = (DefaultTableModel)tb_hoivien.getModel();
        int selectedRow = tb_hoivien.getSelectedRow();
        jTextField2.setText(model.getValueAt(selectedRow, 0).toString());
        jTextField1.setText(model.getValueAt(selectedRow, 1).toString());
        jTextField3.setText(model.getValueAt(selectedRow, 6).toString());
        jTextField4.setText(model.getValueAt(selectedRow, 2).toString());
        jTextField5.setText(model.getValueAt(selectedRow, 3).toString());
        jTextField7.setText(model.getValueAt(selectedRow, 4).toString());
        jComboBox2.getEditor().setItem(model.getValueAt(selectedRow, 5).toString());
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

        pane2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hoivien = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttonFind = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBorder(null);
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(980, 570));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pane2.setBackground(new java.awt.Color(255, 255, 255));
        pane2.setAlignmentX(0.0F);
        pane2.setAlignmentY(0.0F);
        pane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane2MouseClicked(evt);
            }
        });
        pane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(62, 120, 202));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tên");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Địa chỉ");

        jTextField3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(51, 51, 51));

        jTextField4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(51, 51, 51));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("SĐT");

        jTextField5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(51, 51, 51));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("CMND");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Giới tính");

        jTextField7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(51, 51, 51));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Năm sinh");

        jComboBox2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nữ", "Nam" }));

        jPanel2.setBackground(new java.awt.Color(68, 155, 222));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/GUI/icon_user_blue.png"))); // NOI18N

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField7)
                            .addComponent(jTextField4))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pane2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Danh sách hội viên");
        pane2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jScrollPane1.setOpaque(false);

        tb_hoivien.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_hoivien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "HỌ VÀ TÊN", "SĐT", "CMND", "NĂM SINH", "GIỚI TÍNH", "ĐỊA CHỈ"
            }
        ));
        tb_hoivien.setAlignmentX(0.0F);
        tb_hoivien.setAlignmentY(0.0F);
        tb_hoivien.setEditingColumn(0);
        tb_hoivien.setEditingRow(0);
        tb_hoivien.setGridColor(new java.awt.Color(255, 255, 255));
        tb_hoivien.setInheritsPopupMenu(true);
        tb_hoivien.setOpaque(false);
        tb_hoivien.setRowHeight(35);
        tb_hoivien.setRowMargin(0);
        tb_hoivien.setShowHorizontalLines(false);
        tb_hoivien.setShowVerticalLines(false);
        tb_hoivien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoivienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hoivien);
        if (tb_hoivien.getColumnModel().getColumnCount() > 0) {
            tb_hoivien.getColumnModel().getColumn(0).setHeaderValue("ID");
            tb_hoivien.getColumnModel().getColumn(1).setHeaderValue("HỌ VÀ TÊN");
            tb_hoivien.getColumnModel().getColumn(2).setResizable(false);
            tb_hoivien.getColumnModel().getColumn(2).setHeaderValue("SĐT");
            tb_hoivien.getColumnModel().getColumn(3).setHeaderValue("CMND");
            tb_hoivien.getColumnModel().getColumn(4).setHeaderValue("NĂM SINH");
            tb_hoivien.getColumnModel().getColumn(5).setHeaderValue("GIỚI TÍNH");
            tb_hoivien.getColumnModel().getColumn(6).setHeaderValue("ĐỊA CHỈ");
        }

        pane2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 630, 320));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("Hội viên");
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pane2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, -1));

        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 0, 0));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");
        jTextField9.setBorder(null);
        pane2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 58, 32));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_button_fix.png"))); // NOI18N
        jLabel36.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        pane2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, -1, -1));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_button_add.png"))); // NOI18N
        jLabel38.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        pane2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, -1, -1));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_button_del.png"))); // NOI18N
        jLabel39.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        pane2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, -1, -1));

        jPanel1.setBackground(new java.awt.Color(219, 219, 219));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonFind.setBackground(new java.awt.Color(255, 255, 255));
        buttonFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/icon_search.png"))); // NOI18N
        buttonFind.setBorderPainted(false);
        buttonFind.setOpaque(false);
        buttonFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonFindMouseClicked(evt);
            }
        });
        jPanel1.add(buttonFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 50, 40));

        txtFind.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtFind.setForeground(new java.awt.Color(153, 153, 153));
        txtFind.setText("Tìm kiếm");
        txtFind.setBorder(null);
        txtFind.setOpaque(false);
        txtFind.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFindFocusGained(evt);
            }
        });
        jPanel1.add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 167, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymer/Image/Rectangle_s.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        pane2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 58, 650, 90));

        getContentPane().add(pane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void d(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d
        // TODO add your handling code here:
    }//GEN-LAST:event_d

    private void tb_hoivienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoivienMouseClicked
        // TODO add your handling code here:
        getSelectedRow();
    }//GEN-LAST:event_tb_hoivienMouseClicked

    private void pane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane2MouseClicked
        // TODO add your handling code here:
        showData(eqi.getAll());
    }//GEN-LAST:event_pane2MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa ?");
        if (dialogButton == JOptionPane.YES_OPTION) {
            if (eqi.delete(this.eq.getID())){
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                String Reason = JOptionPane.showInputDialog("Lý do xóa");
                LogFile.createDeleteLog(em.getMaNV(), em.getTen(), eq.getID(), Reason, LogFile.KHACHHANG);
                showData(eqi.getAll());
            }
            else JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình xóa vui lòng thử lại");
        }
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
        Customer temp = new Customer();
        setDatatoEnity(temp);
        if (temp.getCMND().equals(eq.getCMND())
                && temp.getName().equals(eq.getName())
                && temp.getYearofBirh()== eq.getYearofBirh()
                && temp.getSDT().equals(eq.getSDT())
                && temp.getAddress().equals(eq.getAddress())
                && temp.getSex() == eq.getSex()
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
    }//GEN-LAST:event_jLabel36MouseClicked

    private void buttonFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonFindMouseClicked
        // TODO add your handling code here:
        String search = txtFind.getText();
        if (txtFind.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập gì cả");
        }
        showData(eqi.findByString(search));
    }//GEN-LAST:event_buttonFindMouseClicked

    private void txtFindFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusGained
        // TODO add your handling code here:
        txtFind.setText("");
    }//GEN-LAST:event_txtFindFocusGained
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFind;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel pane2;
    private javax.swing.JTable tb_hoivien;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}

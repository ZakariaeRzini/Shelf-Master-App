/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jframe.DBConnection.con;


/**
 *
 * @author Oumaima_Rzini
 */
public final class ManageMembers extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    int member_id;
    String name,contact,address,card_id,date_of_birth;
    DefaultTableModel model;
    public ManageMembers() {
        initComponents();
        setMemberDetailsToTable();
        
    }
    
    
public void setMemberDetailsToTable(){
    
     try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select * from members_details");
            
            while(rs.next()){
                String memberId =rs.getString("member_id");
                String memberName =rs.getString("name");
                String address =rs.getString("address");
                String contact =rs.getString("contact");
                String date_of_birth=rs.getString("date_of_birth");
                String cardId =rs.getString("card_id");
                Object[] obj ={memberId,memberName,address,contact ,date_of_birth ,cardId };
                model =(DefaultTableModel) tbl_memberDetails.getModel();
                model.addRow(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    
    
}
//to add book to table
  public boolean addMember(){
       boolean isAdded = false;
       member_id= Integer.parseInt(txt_memberId.getText());
       name= txt_memberName.getText();
       address= txt_address.getText();
       contact =txt_contact.getText();
       
       Date birthDate= date_dob.getDatoFecha();
       long l1=birthDate.getTime();
       java.sql.Date datebirth = new java.sql.Date(l1);
     
       card_id =txt_cardID.getText();
       
       
        try{
            
            Connection con = DBConnection.getConnection();
            String sql = "insert into members_details values(?,?,?,?,?,?)";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setInt(1, member_id);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, contact);
            pst.setDate(5, datebirth);
            pst.setString(6, card_id);
            
           int rowCount = pst.executeUpdate();
           if(rowCount >0){
               isAdded = true;
           }else{
               isAdded = false;
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isAdded;
    
}
  
  //to update books details
  public boolean updateMember(){
  
       boolean isUpdated = false;
       member_id= Integer.parseInt(txt_memberId.getText());
       name= txt_memberName.getText();
       address= txt_address.getText();
       contact =txt_contact.getText();
       Date birthDate= date_dob.getDatoFecha();
       long l1=birthDate.getTime();
       java.sql.Date datebirth = new java.sql.Date(l1);
       card_id =txt_cardID.getText();
       try{
            Connection con = DBConnection.getConnection();
            String sql = "update members_details set name=?,address=?,contact=?,date_of_birth=?,card_id=? where member_id=?";
             PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, contact);
            pst.setString(4, date_of_birth);
            pst.setString(5, card_id);
            pst.setInt(6, member_id);
            
            int rowCount = pst.executeUpdate();
            if(rowCount >0 ){
               isUpdated = true;
           }else{
               isUpdated = false;
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isUpdated;
  
  }
  
 //to delete books details
  public boolean deleteMember(){
  
       boolean isDeleted = false;
       member_id= Integer.parseInt(txt_memberId.getText());
       
       try{
            Connection con = DBConnection.getConnection();
            String sql = "delete from members_details where member_id=?";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setInt(1, member_id);
            
            int rowCount = pst.executeUpdate();
            if(rowCount >0 ){
               isDeleted = true;
           }else{
               isDeleted = false;
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isDeleted;
  }
      
       
  
  //clear table
  
  public void clearTable(){
  DefaultTableModel model= (DefaultTableModel)tbl_memberDetails.getModel();
  model.setRowCount(0);
  
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_memberId = new app.bolivia.swing.JCTextField();
        txt_memberName = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_address = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_cardID = new app.bolivia.swing.JCTextField();
        date_dob = new rojeru_san.componentes.RSDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_memberDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 112, 192));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jLabel5.setBackground(new java.awt.Color(0, 102, 204));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel5.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 50, 60));

        jLabel16.setBackground(new java.awt.Color(0, 102, 204));
        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Member Id");
        jLabel16.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 190, 30));

        txt_memberId.setBackground(new java.awt.Color(255, 102, 102));
        txt_memberId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_memberId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_memberId.setPlaceholder("Enter Member Id");
        txt_memberId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_memberIdFocusLost(evt);
            }
        });
        txt_memberId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_memberIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_memberId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 290, -1));

        txt_memberName.setBackground(new java.awt.Color(255, 102, 102));
        txt_memberName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_memberName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_memberName.setPlaceholder("Enter Full Name");
        txt_memberName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_memberNameFocusLost(evt);
            }
        });
        txt_memberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_memberNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_memberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 290, -1));

        jLabel6.setBackground(new java.awt.Color(0, 102, 204));
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel6.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 50, 60));

        jLabel17.setBackground(new java.awt.Color(0, 102, 204));
        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Full Name");
        jLabel17.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 190, 30));

        txt_address.setBackground(new java.awt.Color(255, 102, 102));
        txt_address.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_address.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_address.setPlaceholder("Enter Address");
        txt_address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_addressFocusLost(evt);
            }
        });
        txt_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addressActionPerformed(evt);
            }
        });
        jPanel1.add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 290, -1));

        jLabel7.setBackground(new java.awt.Color(0, 102, 204));
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel7.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 50, 60));

        jLabel18.setBackground(new java.awt.Color(0, 102, 204));
        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Address");
        jLabel18.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 190, 30));

        txt_contact.setBackground(new java.awt.Color(255, 102, 102));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_contact.setPlaceholder("Enter Contact");
        txt_contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_contactFocusLost(evt);
            }
        });
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel1.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 290, -1));

        jLabel19.setBackground(new java.awt.Color(0, 102, 204));
        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Contact");
        jLabel19.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 190, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 102, 204));
        rSMaterialButtonCircle1.setText("Delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 680, 110, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 102, 204));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 110, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 102, 204));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 680, 110, 70));

        jLabel20.setBackground(new java.awt.Color(0, 102, 204));
        jLabel20.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Date of Birth");
        jLabel20.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 190, 30));

        jLabel21.setBackground(new java.awt.Color(0, 102, 204));
        jLabel21.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Library Card ID");
        jLabel21.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 190, 30));

        txt_cardID.setBackground(new java.awt.Color(255, 102, 102));
        txt_cardID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_cardID.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_cardID.setPlaceholder("Enter Card ID");
        txt_cardID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cardIDFocusLost(evt);
            }
        });
        txt_cardID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cardIDActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cardID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 290, -1));

        date_dob.setPlaceholder("Select date of birth");
        jPanel1.add(date_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 330, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 1000));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 112, 192));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 50, 50));

        jLabel3.setBackground(new java.awt.Color(0, 0, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_People_50px.png"))); // NOI18N
        jLabel3.setText("Manage Members");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 51, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 410, 5));

        tbl_memberDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", " Full Name", "Address", "Contact", "Date of Birth", "Library Card ID"
            }
        ));
        tbl_memberDetails.setAlignmentX(1.0F);
        tbl_memberDetails.setColorBackgoundHead(new java.awt.Color(0, 102, 204));
        tbl_memberDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_memberDetails.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        tbl_memberDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_memberDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        tbl_memberDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_memberDetails.setRowHeight(40);
        tbl_memberDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_memberDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_memberDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 880, 210));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 930, 1000));

        setSize(new java.awt.Dimension(1370, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
      HomePge home = new HomePge();
      home.setVisible(true);
      dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void txt_memberIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_memberIdFocusLost

    }//GEN-LAST:event_txt_memberIdFocusLost

    private void txt_memberIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_memberIdActionPerformed

    }//GEN-LAST:event_txt_memberIdActionPerformed

    private void txt_memberNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_memberNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_memberNameFocusLost

    private void txt_memberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_memberNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_memberNameActionPerformed

    private void txt_addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_addressFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addressFocusLost

    private void txt_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addressActionPerformed

    private void txt_contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_contactFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactFocusLost

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
      if (updateMember()== true){
           JOptionPane.showMessageDialog(this, "Member Updated");
           clearTable();
           setMemberDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Member Updation Failed");
       }
    
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
      if (deleteMember()== true){
           JOptionPane.showMessageDialog(this, "Member Deleted");
           clearTable();
           setMemberDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Member Deletion Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
   System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if (addMember()== true){
           JOptionPane.showMessageDialog(this, "Member Added");
           clearTable();
           setMemberDetailsToTable();
           
       }else{
           JOptionPane.showMessageDialog(this, "Member Addition Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txt_cardIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cardIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cardIDFocusLost

    private void txt_cardIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cardIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cardIDActionPerformed

    private void tbl_memberDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_memberDetailsMouseClicked
        int rowNo =tbl_memberDetails.getSelectedRow();
        TableModel model =tbl_memberDetails.getModel();
        txt_memberId.setText( model.getValueAt(rowNo, 0).toString());
        txt_memberName.setText( model.getValueAt(rowNo, 1).toString());
        txt_address.setText( model.getValueAt(rowNo, 2).toString());
        txt_contact.setText( model.getValueAt(rowNo, 3).toString());
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = sdf.parse(model.getValueAt(rowNo, 4).toString());
        java.sql.Date sqlDate = new java.sql.Date(dateOfBirth.getTime());
        date_dob.setDatoFecha(sqlDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }
        txt_cardID.setText( model.getValueAt(rowNo, 5).toString()); 
        
        
    }//GEN-LAST:event_tbl_memberDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(ManageMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageMembers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_memberDetails;
    private app.bolivia.swing.JCTextField txt_address;
    private app.bolivia.swing.JCTextField txt_cardID;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_memberId;
    private app.bolivia.swing.JCTextField txt_memberName;
    // End of variables declaration//GEN-END:variables
}

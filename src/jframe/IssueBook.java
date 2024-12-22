/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import static jframe.DBConnection.con;
import java.util.Date;

/**
 *
 * @author Oumaima_Rzini
 */
public final class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    public IssueBook() {
        initComponents();    
    }
    
 // To fetch the book details from the database and display it to book details panel   
public void getBookDetails(){
    
    int bookId= Integer.parseInt(txt_bookId.getText());
    
     try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from books_details where book_id=?");
            pst.setInt(1, bookId);
            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_title"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
                lbl_edition.setText(rs.getString("edition"));
                lbl_category.setText(rs.getString("category"));
            }else{
                lbl_bookError.setText("invalid book id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    
    
}
// To fetch the member details from the database and display it to member details panel
 public void getMemberDetails(){
    
    int memberId= Integer.parseInt(txt_memberId.getText());
    
     try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from members_details where member_id=?");
            pst.setInt(1, memberId);
            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                lbl_memberId.setText(rs.getString("member_id"));
                lbl_name.setText(rs.getString("name"));
                lbl_address.setText(rs.getString("address"));
                lbl_contact.setText(rs.getString("contact"));
                lbl_dob.setText(rs.getString("date_of_birth"));
                lbl_cardId.setText(rs.getString("card_id"));
            }else{
            lbl_memberError.setText("invalid member id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       
}
 
 // insert issue book details to database

public boolean issueBook(){
  
  boolean isIssued= false;
  int book_id= Integer.parseInt(txt_bookId.getText());
  int member_id = Integer.parseInt(lbl_memberId.getText());
  String bookName = lbl_bookName.getText();
  String memberName = lbl_name.getText();
  Date uIssueDate= date_issueDate.getDatoFecha();
  Date uDueDate = date_dueDate.getDatoFecha();
     long l1=uIssueDate.getTime();
     long l2=uDueDate.getTime();
     java.sql.Date sIssueDate = new java.sql.Date(l1);
     java.sql.Date sDueDate = new java.sql.Date(l2);
     
     
  
  try {

  Connection con= DBConnection.getConnection();

  String sql = "insert into issue_book_details(book_id, book_name,member_id,member_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
  PreparedStatement pst = con.prepareStatement(sql);
  pst.setInt(1, book_id);
  pst.setString(2, bookName);
  pst.setInt(3, member_id);
  pst.setString(4, memberName);
  pst.setDate(5, sIssueDate);
  pst.setDate(6, sDueDate);
  pst.setString(7, "pending");
  
  int rowCount = pst.executeUpdate();
  if(rowCount > 0){
      isIssued = true;
  }else{
      isIssued = false;
  }
  
  
  } catch (Exception e) {
      e.printStackTrace();
  }
  return isIssued;
}
// updating book count
public void updateBookCount(){
    int book_id= Integer.parseInt(txt_bookId.getText());
    
    try{
            Connection con = DBConnection.getConnection();
            String sql = "update books_details set quantity= quantity-1 where book_id=?"; 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
             JOptionPane.showMessageDialog(this, "book count updated");  
             int initialCount = Integer.parseInt(lbl_quantity.getText());
             lbl_quantity.setText(Integer.toString(initialCount -1));
            }else{
             JOptionPane.showMessageDialog(this, "can't update book count");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       
}

// checking whether book already allocated or not
public boolean isAlreadyIssued(){
    boolean isAlreadyIssued = false;
    int book_id= Integer.parseInt(txt_bookId.getText());
    int member_id = Integer.parseInt(lbl_memberId.getText());
    try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id=? and member_id=? and status=?"; 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            pst.setInt(2, member_id);
            pst.setString(3, "pending");
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
             isAlreadyIssued = true;
            }else{
             isAlreadyIssued = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }return isAlreadyIssued;
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_edition = new javax.swing.JLabel();
        lbl_category = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_memberId = new app.bolivia.swing.JCTextField();
        jLabel31 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl_cardId = new javax.swing.JLabel();
        lbl_memberId = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_address = new javax.swing.JLabel();
        lbl_contact = new javax.swing.JLabel();
        lbl_dob = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_memberError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 50, 50));

        jLabel3.setBackground(new java.awt.Color(0, 0, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1_1.png"))); // NOI18N
        jLabel3.setText("Issue Books");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 51, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 410, 5));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(0, 102, 204));
        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Book Id: ");
        jLabel16.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 30));

        jLabel17.setBackground(new java.awt.Color(0, 102, 204));
        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book Title:");
        jLabel17.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 100, 30));

        jLabel18.setBackground(new java.awt.Color(0, 102, 204));
        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Author Name:");
        jLabel18.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 130, 40));

        jLabel19.setBackground(new java.awt.Color(0, 102, 204));
        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Quantity:");
        jLabel19.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 90, 30));

        jLabel20.setBackground(new java.awt.Color(0, 102, 204));
        jLabel20.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText(" Edition:");
        jLabel20.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 110, 30));

        jLabel21.setBackground(new java.awt.Color(0, 102, 204));
        jLabel21.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Category:");
        jLabel21.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 100, 30));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 140, 30));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 220, 30));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 190, 40));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 150, 30));

        lbl_edition.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_edition.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 140, 30));

        lbl_category.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_category.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 210, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel5.setText(" Book Details");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 300, 110));

        lbl_bookError.setBackground(new java.awt.Color(0, 102, 204));
        lbl_bookError.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(51, 51, 51));
        lbl_bookError.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 310, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 400, 1000));

        jLabel29.setBackground(new java.awt.Color(0, 102, 204));
        jLabel29.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel29.setText("Member id");
        jLabel29.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 190, 30));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
        txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel3.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 290, -1));

        jLabel28.setBackground(new java.awt.Color(0, 102, 204));
        jLabel28.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel28.setText("Book id");
        jLabel28.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 190, 30));

        jLabel30.setBackground(new java.awt.Color(0, 102, 204));
        jLabel30.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel30.setText("Issue Date");
        jLabel30.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 190, 30));

        txt_memberId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
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
        jPanel3.add(txt_memberId, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 290, -1));

        jLabel31.setBackground(new java.awt.Color(0, 102, 204));
        jLabel31.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel31.setText("Due Date ");
        jLabel31.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 190, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 102, 204));
        rSMaterialButtonCircle1.setText("issue book");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 640, 380, 70));

        date_issueDate.setPlaceholder("Select issue date");
        jPanel3.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 290, -1));

        date_dueDate.setPlaceholder("Select due date");
        jPanel3.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, 290, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 1010, 1000));

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 112, 192));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(40, 40, 40))
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jLabel22.setBackground(new java.awt.Color(0, 102, 204));
        jLabel22.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Member Id:");
        jLabel22.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 110, 30));

        jLabel23.setBackground(new java.awt.Color(0, 102, 204));
        jLabel23.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Full Name:");
        jLabel23.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 100, 30));

        jLabel24.setBackground(new java.awt.Color(0, 102, 204));
        jLabel24.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Address:");
        jLabel24.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 90, 30));

        jLabel25.setBackground(new java.awt.Color(0, 102, 204));
        jLabel25.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Contact:");
        jLabel25.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 80, 30));

        jLabel26.setBackground(new java.awt.Color(0, 102, 204));
        jLabel26.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Date of Birth:");
        jLabel26.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 120, 30));

        lbl_cardId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_cardId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_cardId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 180, 30));

        lbl_memberId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_memberId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_memberId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 120, 30));

        lbl_name.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 190, 30));

        lbl_address.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_address.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 170, 30));

        lbl_contact.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_contact.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 180, 30));

        lbl_dob.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_dob.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 170, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel6.setText(" Member Details");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 340, 120));

        jLabel32.setBackground(new java.awt.Color(0, 102, 204));
        jLabel32.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Library Card ID:");
        jLabel32.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 140, 30));

        lbl_memberError.setBackground(new java.awt.Color(0, 102, 204));
        lbl_memberError.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lbl_memberError.setForeground(new java.awt.Color(51, 51, 51));
        lbl_memberError.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel6.add(lbl_memberError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 310, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 1000));

        setSize(new java.awt.Dimension(1370, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
   System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        HomePge home = new HomePge();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals("")){
            getBookDetails();
        }
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_memberIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_memberIdFocusLost
        if(!txt_memberId.getText().equals("")){
            getMemberDetails();
        }
    }//GEN-LAST:event_txt_memberIdFocusLost

    private void txt_memberIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_memberIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_memberIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if(lbl_quantity.getText().equals("0")){
           
            JOptionPane.showMessageDialog(this, "book is not available");
 
       }else{
         if(isAlreadyIssued() == false){
           if(issueBook() == true){
           JOptionPane.showMessageDialog(this, "book issued successfully");
           updateBookCount();
            }else{
            JOptionPane.showMessageDialog(this, "can't issue the book");
       }
       }else{
           JOptionPane.showMessageDialog(this, "this member already has this book");
       }  
       }
        
        
        
        
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        HomePge home= new HomePge();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_cardId;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JLabel lbl_contact;
    private javax.swing.JLabel lbl_dob;
    private javax.swing.JLabel lbl_edition;
    private javax.swing.JLabel lbl_memberError;
    private javax.swing.JLabel lbl_memberId;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_quantity;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_memberId;
    // End of variables declaration//GEN-END:variables
}

package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Harriii
 */
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    public ManageBooks() {
        initComponents();
        setBookDetailsToTable();
    }
    
    String bookName,author;
    int bookId,quantity;
    DefaultTableModel model;
    
    //seting book detials in table
    public void setBookDetailsToTable(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryms", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from book_details");
            
            while(rs.next())
            {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                
                Object[] obj ={bookId,bookName,author,quantity};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
           
    }
    //adding books to table
    public boolean addBook(){
        boolean isAdded = false;
        bookId = Integer.parseInt(txt_bookId.getText());
        bookName = txt_bookName.getText();
        author = txt_authorName.getText();
        quantity = Integer.parseInt(txt_quantity.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into book_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, author);
            pst.setInt(4, quantity);
            int rowCount = pst.executeUpdate();
            if (rowCount>0) {
                isAdded = true;
            }
            else{
                isAdded = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    //Updating Book details in table
    public boolean updateBook(){
        boolean isUpdated = false;
        bookId = Integer.parseInt(txt_bookId.getText());
        bookName = txt_bookName.getText();
        author = txt_authorName.getText();
        quantity = Integer.parseInt(txt_quantity.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set book_name=?,author=?,quantity=? where book_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookName);
            pst.setString(2, author);
            pst.setInt(3, quantity);
            pst.setInt(4, bookId);
            int rowCount = pst.executeUpdate();
            if(rowCount>0) {
                isUpdated = true;
            }
            else{
                isUpdated = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    
    //Deleting Book From Table
    public boolean deleteBook(){
        boolean isDeleted = false;
        bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from book_details where book_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();
            if (rowCount>0) {
                isDeleted = true;
            }
            else{
                isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    
    //method to clear table 
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
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
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_authorName = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Back.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        txt_bookId.setBackground(new java.awt.Color(0, 102, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_bookId.setPlaceholder("Book ID....");
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 250, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Book ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, 40));

        txt_bookName.setBackground(new java.awt.Color(0, 102, 255));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_bookName.setPlaceholder("Book Name");
        jPanel1.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 250, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Book Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 180, 50));

        txt_authorName.setBackground(new java.awt.Color(0, 102, 255));
        txt_authorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_authorName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_authorName.setPlaceholder("Author Name");
        jPanel1.add(txt_authorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 250, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Author Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 190, 30));

        txt_quantity.setBackground(new java.awt.Color(0, 102, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_quantity.setPlaceholder("Book Quantity");
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 250, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Quantity");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 130, 50));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle1.setText("Clear");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 190, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 190, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 190, 70));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle4.setText("Delete");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 190, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 740));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(251, 51, 51));
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setRowHeight(35);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Manage Books");
        jLabel2.setIconTextGap(10);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 700, 740));

        setSize(new java.awt.Dimension(1081, 740));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        int rowNo = tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();
        
        txt_bookId.setText(model.getValueAt(rowNo,0).toString());
        txt_bookName.setText(model.getValueAt(rowNo,1).toString());
        txt_authorName.setText(model.getValueAt(rowNo,2).toString());
        txt_quantity.setText(model.getValueAt(rowNo,3).toString());
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(addBook() == true){
            JOptionPane.showMessageDialog(this,"Book Added");
            clearTable();
            setBookDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this,"Book Addition Failed ");
        }        
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(updateBook() == true){
            JOptionPane.showMessageDialog(this,"Book Updated");
            clearTable();
            setBookDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this,"Book Updation Failed ");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        if(deleteBook() == true){
            JOptionPane.showMessageDialog(this,"Book Deleted");
            clearTable();
            setBookDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this,"Book Deletion Failed ");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        txt_bookId.setText("");
        txt_bookName.setText("");
        txt_authorName.setText("");
        txt_quantity.setText("");        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_authorName;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
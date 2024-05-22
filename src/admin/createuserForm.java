/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import registertration.regitrationform;
import static registertration.regitrationform.email;
import static registertration.regitrationform.usname;
import testappm.loginApp1;

/**
 *
 * @author JULIANNE
 */
public class createuserForm extends javax.swing.JFrame {

    /**
     * Creates new form createuserForm
     */
    public createuserForm() {
        initComponents();
    }
    public String destination = ""; 
    File selectedFile;
    public String oldpath;
    public String path;
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        Path filePath = Paths.get("src/usersImages", fileName);
        boolean fileExists = Files.exists(filePath);
        if (fileExists) {
            return 1;
        } else { 
            return 0;
      } 
    
}
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile); 
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
             int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
             return newHeight;
             } catch (IOException ex) {
           System.out.println("No image found!");
}
return -1;
}
  public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;    
  }
  public void ImageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    public boolean duplicateChecker(){
       dbConnector dbc = new dbConnector();
        try{
        String query = "SELECT * FROM tbl_property  WHERE u_username = '" + us.getText()+ "' OR u_email = '" + em.getText() + "'";
            ResultSet resultSet = dbc.getData(query);
            if(resultSet.next()){
               
               email = resultSet.getString("u_email");
                if(email.equals(em.getText())){
                JOptionPane.showMessageDialog(null, "Email is already used");
                em.setText("");
                }
               usname = resultSet.getString("u_username");
                if(usname.equals(us.getText())){
                JOptionPane.showMessageDialog(null, "The username is already applied");
                us.setText("");
                }
                      
               return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
         System.out.println(""+ex);
            
        return false;
        }
                 
    }
        public boolean udChecker(){
        dbConnector dbc = new dbConnector();
        try{
        String query = "SELECT * FROM tbl_property  WHERE (u_username = '" + us.getText()+ "' OR u_email = '" + em.getText() +"')AND u_id ='"+uid.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            if(resultSet.next()){
               
               email = resultSet.getString("u_email");
                if(email.equals(em.getText())){
                JOptionPane.showMessageDialog(null, "Email is already used");
                em.setText("");
                }
               usname = resultSet.getString("u_username");
                if(usname.equals(us.getText())){
                JOptionPane.showMessageDialog(null, "The username is already applied");
                us.setText("");
                }
                      
               return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
         System.out.println(""+ex);
            
        return false;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        us = new javax.swing.JTextField();
        ps = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        act = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        ustat = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        ud = new javax.swing.JButton();
        del = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        ref = new javax.swing.JButton();
        ref1 = new javax.swing.JButton();
        ot = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        ln = new javax.swing.JTextField();
        remove = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FIRST NAME:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("LAST NAME:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("USERNAME:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 80, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("PASSWORD:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 80, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("EMAIL:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ACCOUNT TYPE:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 30));
        getContentPane().add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 160, 30));
        getContentPane().add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 160, 30));
        getContentPane().add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 160, 30));
        getContentPane().add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 160, 30));

        act.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        act.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        getContentPane().add(act, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 160, 30));

        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 30));

        ustat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ustat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        getContentPane().add(ustat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 160, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("USER STATUS:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 90, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("USER ID:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        uid.setEnabled(false);
        getContentPane().add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 170, 30));

        ud.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ud.setText("UPDATE");
        ud.setEnabled(false);
        ud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udActionPerformed(evt);
            }
        });
        getContentPane().add(ud, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, 30));

        del.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        del.setText("DELETE");
        getContentPane().add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, 30));

        clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear.setText("CLEAR");
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 100, 30));

        cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 100, 30));

        ref.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ref.setText("REFRESH");
        getContentPane().add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 100, 30));

        ref1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ref1.setText("REFRESH");
        getContentPane().add(ref1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 100, 30));

        ot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout otLayout = new javax.swing.GroupLayout(ot);
        ot.setLayout(otLayout);
        otLayout.setHorizontalGroup(
            otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        otLayout.setVerticalGroup(
            otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(ot, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 300, 290));

        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        getContentPane().add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));
        getContentPane().add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 160, 30));

        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        getContentPane().add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, -1, -1));

        jPanel1.setBackground(new java.awt.Color(217, 154, 113));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       if(fn.getText().isEmpty()&&fn.getText().isEmpty()&&em.getText().isEmpty()
            &&us.getText().isEmpty()&&ps.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        }else if(ps.getText().length()<8){
            JOptionPane.showMessageDialog(null, "The max password character should be 8 above");
            ps.setText("");

        }else if(duplicateChecker()){

            System.out.println("Duplicate exist");

        }else{
            dbConnector dbc = new dbConnector();
            

  if(dbc.insertData("INSERT INTO tbl_property(u_firstname, u_lastname, u_username, u_email, u_password, u_type, u_status, u_image)"
          + "VALUES('"+fn.getText()+"','"+ln.getText()+"','"+us.getText()+"','"+em.getText()+"',"
                        + "'"+ps.getText()+"','"+act.getSelectedItem()+"','"+ustat.getSelectedItem()+"','"+destination+"')"))
                               
      {
          try{
          Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
          JOptionPane.showMessageDialog(null, " Create Successfully");
        usersForm uf = new usersForm();
        uf.setVisible(true);
        this.dispose();
      }catch(IOException ex){
              System.out.println("Insert Image Error : "+ex);
              }
      }else{
              JOptionPane.showMessageDialog(null,"Connnection Error");
      }                         
 }

          
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
  usersForm usf = new usersForm();
  usf.setVisible(true);
  this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void udActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udActionPerformed
 if(fn.getText().isEmpty()&&fn.getText().isEmpty()&&em.getText().isEmpty()
            &&us.getText().isEmpty()&&ps.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        }else if(ps.getText().length()<8){
            JOptionPane.showMessageDialog(null, "The max password character should be 8 above");
            ps.setText("");
        }else if(udChecker()){
            System.out.println("Duplicate exist");

        }else{ 
      dbConnector dbc = new dbConnector(); 
      dbc.updateData("UPDATE tbl_property SET u_firstname = '"+fn.getText()+"',u_lastname ='"+ln.getText()+"',"
        + "u_email= '"+em.getText()+"',u_username= '"+us.getText()+"',"
        + "u_password= '"+ps.getText()+"',u_type= '"+act.getSelectedItem()+"',"
        + "u_status= '"+ustat.getSelectedItem()+"',u_image = '"+destination+"'WHERE u_id ='"+uid.getText()+"'");
      
      
      if(destination.isEmpty()){
          File existingFile = new File(oldpath);
          if(existingFile.exists()){
              existingFile.delete();
          }
      }else{
          if(!(oldpath.equals(path))){
              ImageUpdater(oldpath,path);
          }
      }
      usersForm uf = new usersForm();
      uf.setVisible(true);
      this.dispose();
      
      
        }
    }//GEN-LAST:event_udActionPerformed
    
    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
      JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/usersImages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            remove.setEnabled(true);
                            select.setEnabled(false);
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed
    
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
            java.util.logging.Logger.getLogger(createuserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createuserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createuserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createuserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createuserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> act;
    public javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton clear;
    private javax.swing.JButton del;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField ln;
    private javax.swing.JPanel ot;
    public javax.swing.JTextField ps;
    private javax.swing.JButton ref;
    private javax.swing.JButton ref1;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JButton ud;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField us;
    public javax.swing.JComboBox<String> ustat;
    // End of variables declaration//GEN-END:variables
}

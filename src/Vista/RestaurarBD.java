/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RestaurarBD.java
 *
 * Created on 01-ene-2013, 22:16:52
 */
package Vista;

import Vista.Principal;
import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Controlador.Coneccion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tottus
 */
public class RestaurarBD extends javax.swing.JDialog {

    String user = "root";
    String password = "";
    String bd = "";
    String path = "";
    Principal p;

    public RestaurarBD(Principal parent, boolean modal) {
        super(parent, modal);
        p = parent;
        initComponents();
        this.setLocationRelativeTo(p);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnrestaurar = new javax.swing.JButton();
        btnexaminar = new javax.swing.JButton();
        txtruta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurar Base de Datos");
        setResizable(false);

        btnrestaurar.setText("Restaurar");
        btnrestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestaurarActionPerformed(evt);
            }
        });

        btnexaminar.setText("Examinar");
        btnexaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexaminarActionPerformed(evt);
            }
        });

        txtruta.setEditable(false);

        jLabel1.setText("Ruta :");

        jLabel2.setText("nombre BD :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBD, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 25, Short.MAX_VALUE)
                .addComponent(btnexaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnexaminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnrestaurar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexaminarActionPerformed
             JFileChooser se= new JFileChooser();
se.setFileSelectionMode(JFileChooser.FILES_ONLY);
 
int estado = se.showSaveDialog(null);
if(estado==JFileChooser.APPROVE_OPTION){
    String ruta= se.getSelectedFile().toString();
      
      txtruta.setText(ruta);
}
    }//GEN-LAST:event_btnexaminarActionPerformed

    private void btnrestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestaurarActionPerformed

        bd= txtBD.getText();
    
        RestaurarBD(txtruta.getText());
    
    
    }//GEN-LAST:event_btnrestaurarActionPerformed
    /**
     * @param args the command line arguments
     */
    
    
     
  
public void RestaurarBD(String ruta){
     
            try{
                crearBD(bd);
             
           String rutaMySql = "C:\\xampp\\mysql\\bin\\mysql.exe";
String cad = "\"" + rutaMySql + "\" --password= --user=root "+bd+" < \"" + ruta +"\"\n";


            File fcopi = new File("copia_seguridad.bat");
            FileWriter fw = new FileWriter(fcopi);
            fw.write(cad, 0, cad.length());
            fw.close();
            Runtime.getRuntime().exec("copia_Seguridad.bat");
             
            JOptionPane.showMessageDialog(null, "Restaurado Correctamente","Verificar",JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }
            
    }


public void crearBD(String bd){
    
        Connection cn; 
        PreparedStatement ps;
        Coneccion cc=new Coneccion(); 
        cn =  (Connection) cc.conexion();
        try {
           
                PreparedStatement st=cn.prepareStatement("drop database if exists "+bd+";");
           st.executeUpdate(); 
                    PreparedStatement swt=cn.prepareStatement("create database "+bd+";");
           swt.executeUpdate();
           
           PreparedStatement set=cn.prepareStatement("use "+bd+";");
           set.executeUpdate();
           JOptionPane.showMessageDialog(null,"creado satisfactoriamente");
                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error" +e.getLocalizedMessage());
        }
    
}    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexaminar;
    private javax.swing.JButton btnrestaurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtBD;
    private javax.swing.JTextField txtruta;
    // End of variables declaration//GEN-END:variables
}
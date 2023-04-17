/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class MessageData {
    public static void setData(String e_witnessId,String message,String CriminalImagePath, JFrame frame)
    {
    Connection con=null;
        
        try
        {
           con=ConnectionProvider.getCon();
           String mySqlQuery="insert into sendData(e_witnessId, message, c_Img) values (?,?,?)";
           PreparedStatement PRT=con.prepareStatement(mySqlQuery);
           PRT.setString(1,e_witnessId);
           PRT.setString(2, message);
           try
           {
               InputStream inputStream=new FileInputStream(new File(CriminalImagePath));
               PRT.setBlob(3, inputStream);
           }
           catch(Exception exception)
           {
               JOptionPane.showMessageDialog(frame,"Image Error: "+exception.getMessage());
               return;
           }
           try
           {
               PRT.execute();
               JOptionPane.showMessageDialog(frame,"Record has been Saved");
           }
           catch(Exception exception)
           {
               JOptionPane.showMessageDialog(frame,"Image Error: "+exception.getMessage());
               return;
           }
           
           
        }
        catch(Exception exception)
        {
                       JOptionPane.showMessageDialog(frame,"Data Error: "+exception.getMessage());
                       return;
        }
        
    }
    
}

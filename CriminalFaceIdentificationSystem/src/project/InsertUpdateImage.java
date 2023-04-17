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
public class InsertUpdateImage {
    public static void setData(String criminalId,String imageId,String CriminalImagePath1,String CriminalImagePath2,String CriminalImagePath3,String CriminalImagePath4,String CriminalImagePath5,String CriminalImagePath6, JFrame frame)
    {
    Connection con=null;
        
        try
        {
           con=ConnectionProvider.getCon();
           String mySqlQuery="insert into criminalImage(criminalId, imageId, c_Img, forehead, eyes, nose, lips, chin) values (?,?,?,?,?,?,?,?)";
           PreparedStatement PRT=con.prepareStatement(mySqlQuery);
           PRT.setString(1, criminalId);
           PRT.setString(2, imageId);
           try
           {
               InputStream inputStream1=new FileInputStream(new File(CriminalImagePath1));
               PRT.setBlob(3, inputStream1);
               
               InputStream inputStream2=new FileInputStream(new File(CriminalImagePath2));
               PRT.setBlob(4, inputStream2);
               
               InputStream inputStream3=new FileInputStream(new File(CriminalImagePath3));
               PRT.setBlob(5, inputStream3);
               
               InputStream inputStream4=new FileInputStream(new File(CriminalImagePath4));
               PRT.setBlob(6, inputStream4);
               
               InputStream inputStream5=new FileInputStream(new File(CriminalImagePath5));
               PRT.setBlob(7, inputStream5);
               
               InputStream inputStream6=new FileInputStream(new File(CriminalImagePath6));
               PRT.setBlob(8, inputStream6);
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

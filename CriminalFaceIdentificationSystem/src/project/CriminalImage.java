/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author user
 */
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CriminalImage {
    public static void main(String[]args)
    {
        Connection con=null;
        Statement st=null;
        try
        {
           con=ConnectionProvider.getCon();
           st=con.createStatement();
           st.executeUpdate("create table criminalImage(criminalId int(20) primary key,imageId varchar(20) unique key,c_Img MEDIUMBLOB,forehead MEDIUMBLOB,eyes MEDIUMBLOB,nose MEDIUMBLOB,lips MEDIUMBLOB,chin MEDIUMBLOB)");
           JOptionPane.showMessageDialog(null,"Table Created Successfully");
        }
        catch(Exception e)
        {
                       JOptionPane.showMessageDialog(null,e);
        }
        finally
        {
             try
        {
            con.close();
            st.close();
           
        }
        catch(Exception e)
        {
                      
        }
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class SendToAdmin {
     public static void main(String[]args)
    {
        Connection con=null;
        Statement st=null;
        try
        {
           con=ConnectionProvider.getCon();
           st=con.createStatement();
           st.executeUpdate("create table sendData(e_witnessId int(20),message varchar(500),c_Img MEDIUMBLOB)");
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

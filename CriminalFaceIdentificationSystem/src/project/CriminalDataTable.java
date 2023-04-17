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
public class CriminalDataTable {
    public static void main(String[]args)
    {
        Connection con=null;
        Statement st=null;
        try
        {
           con=ConnectionProvider.getCon();
           st=con.createStatement();
           st.executeUpdate("create table criminal_data(criminalId int(20) primary Key,fName varchar(200),lName varchar(200),dob date,gender varchar(10),age int(5),criminalAddress varchar(200),city varchar(200),state varchar(200),dateOfArrest date,crimeInvolved varchar(200),e_witnessId int(20),e_witnessName varchar(200),e_witnessAddress varchar(200),complaintId int(20)unique key)");
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

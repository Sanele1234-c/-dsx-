/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sihle
 */
public class Bank {
    private String bankCode;
    private String bankName;
    private String branchCode;
    private String branchName;
    private Boolean isBankAdded;
    private Boolean isBankDeleted;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    void setIsAdded(Boolean value)
    {
        this.isBankAdded= value;
    }

    Boolean getIsAdded()
    {
        return this.isBankAdded;
    }
    // get and set isCustomerDeleted
    void setIsCustomerDeleted(Boolean value)
    {
        this.isBankDeleted= value;
    }

    Boolean getIsCustomerDeleted()
    {

        return this.isBankDeleted;
    }
    
 void AddBankDetails(DbConnect db )
    {
        // insert into database
        db.connect();

        Boolean x;
        x=true;
        String query;
        query = "INSERT INTO bank VALUES('"+ this.bankCode+
                "','"+this.bankName+
                "','"+this.branchCode+
                 "','"+this.branchName+"')";

        Statement st = db.createStatement();

        try
        {

            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsAdded(true);
            {
                JOptionPane.showMessageDialog(null," customer added successfully","important",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null," you can not add this customer","warning",JOptionPane.INFORMATION_MESSAGE);
            this.setIsAdded(false);
        }
    }

    void deleteBank(DbConnect db )
    {

        db.connect();
        Boolean x;
        x=true;
        String query = "DELETE FROM bank WHERE bankCode='"+this.getBankCode()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsCustomerDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The bank is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the bank");
            this.setIsCustomerDeleted(false);
        }
    }

    ResultSet ViewIndividualBank(DbConnect db, String bankCode)
    {

        db.connect();
        String query ="SELECT * FROM bank WHERE bankCode='"+bankCode+"'";
        Statement st = db.createStatement();
        try
        {
            ResultSet res =  st.executeQuery(query);
            return res;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    void UpdateBank(DbConnect db, String bankCode)
    {

        db.connect();
        Boolean isCustomerUpdated = true;
        String query = "UPDATE bank SET bankCode='"+this.bankCode+
                "',bankName='"+this.bankName+
                "',branchCode='"+this.branchCode+
                "',branchCode='"+this.branchName+
                "' WHERE bankCode='"+bankCode+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
        }
        catch (SQLException ex)
        {
            isCustomerUpdated = false;
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (isCustomerUpdated)
        {
            JOptionPane.showMessageDialog(null, " bank record successfully updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null, " system could not  update bank record");
        }
    }



}
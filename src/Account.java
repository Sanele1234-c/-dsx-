

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Sihle
 */
public class Account {
    private String nationalId;
    private String bankCode;
    private String accountNumber;
    private String accountType;
    private String kycDocuments;
    private Boolean isAccountAdded;
    private Boolean isAccountDeleted;


    String getNationalId(){
        return nationalId;
    }
    void setNationalId(String value)
    {
        if (!(value.isEmpty()))
        {
            nationalId = value;
        }
    }
    String getBankCode(){
        return bankCode;
    }
    void setBankCode(String value)
    {
        if (!(value.isEmpty()))
        {
            bankCode = value;
        }
    }
    String getAccountNumber(){
        return accountNumber;
    }
    void setAccountNumber(String value)
    {
        if (!(value.isEmpty()))
        {
            accountNumber = value;
        }
    }
    String getAccountType(){
        return accountType;
    }
    void setAccountType(String value)
    {
        if (!(value.isEmpty()))
        {
            accountType = value;
        }
    }
    String getKycDocuments(){
        return kycDocuments;
    }
    void setKycDocuments(String value)
    {
        if (!(value.isEmpty()))
        {
            kycDocuments = value;
        }
    }
    
    void setIsAdded(Boolean value)
    {
        this.isAccountAdded= value;
    }

    Boolean getIsAdded()
    {
        return this.isAccountAdded;
    }
    // get and set isPatientDeleted
    void setIsDeleted(Boolean value)
    {
        this.isAccountDeleted= value;
    }

    Boolean getIsAccountDeleted()
    {

        return this.isAccountDeleted;
    }
    // add client detals
    void AddAccountDetails(DbConnect db)
    {
    // insert into database

        db.connect();

    Boolean x;
    x=true;
    String query;
    query = "INSERT INTO account VALUES('"+ this.nationalId  +
            "','"+this. bankCode+
            "','"+this. accountNumber+
            "','"+this.accountType+
            "','"+ this.kycDocuments+"')";

    Statement st = db.createStatement();

        try
    {

        st.executeUpdate(query);
        if (x.equals(true))
            this.setIsAdded(true);
        {
            JOptionPane.showMessageDialog(null," Account details added successfully","important",JOptionPane.INFORMATION_MESSAGE);
        }
    }
        catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null," you can not add this account details","warning",JOptionPane.INFORMATION_MESSAGE);
        this.setIsAdded(false);
    }
}
    void deleteAccount(DbConnect db)
    {

        Boolean x;
        x=true;
        String query = "DELETE FROM Account WHERE nationalId='"+this.getNationalId()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The Account is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the Account");
            this.setIsDeleted(false);
        }
    }

    ResultSet ViewIndividualAccount(String nationalId)
    {
        DbConnect db = new DbConnect();
        db.connect();
        String query ="SELECT * FROM account WHERE national='"+nationalId+"'";
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
    void UpdateAccount(DbConnect db, String nationalId)
    {

        Boolean isAccountUpdated = true;
        String query = "UPDATE account SET nationalId='"+this.nationalId+
                "','"+this.bankCode+
                "','"+this.accountNumber+
                "','"+this.accountType+
                "','"+ this.kycDocuments+
                "' WHERE nationalId='"+nationalId+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
        }
        catch (SQLException ex)
        {
            isAccountUpdated = false;
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (isAccountUpdated)
        {
            JOptionPane.showMessageDialog(null, " Account record successfully updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null, " system could not  update Account details record");
        }
    }
}

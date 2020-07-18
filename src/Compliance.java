
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sihle
 */
public class Compliance {
    private String nationalId;
    private String accountNumber;
    private String accountType;
    private String kycDocuments;
    private String compliance;
    private Boolean isComplianceAdded;
    private Boolean isComplianceDeleted;
    
    
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
    String getCompliance(){
        return compliance;
    }
    
    void setCompliance(String value)
    {
        if (!(value.isEmpty()))
        {
           compliance = value;
        }
    }
    void setIsAdded(Boolean value)
    {
        this.isComplianceAdded= value;
    }

    Boolean getIsAdded()
    {
        return this.isComplianceAdded;
    }
    // get and set isPatientDeleted
    void setIsDeleted(Boolean value)
    {
        this.isComplianceDeleted= value;
    }

    Boolean getIsComplianceDeleted()
    {

        return this.isComplianceDeleted;
    }
     // add client detals
    void AddComplianceDetails(DbConnect db)
    {
    // insert into database

        db.connect();

    Boolean x;
    x=true;
    String query;
    query = "INSERT INTO compliance VALUES('"+ this.nationalId  +          
            "','"+this. accountNumber+
             "','"+this. accountType+
            "','"+this. kycDocuments+
            "','"+ this.compliance+"')";

    Statement st = db.createStatement();

        try
     {

        st.executeUpdate(query);
        if (x.equals(true))
            this.setIsAdded(true);
        {
            JOptionPane.showMessageDialog(null," Compliance details added successfully","important",JOptionPane.INFORMATION_MESSAGE);
        }
    }
        catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null," you can not add this compliance details","warning",JOptionPane.INFORMATION_MESSAGE);
        this.setIsAdded(false);
    }
}
    void deleteCompliance(DbConnect db)
    {

        Boolean x;
        x=true;
        String query = "DELETE FROM Compliance WHERE nationalId='"+this.getNationalId()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The Compliance is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the Compliance");
            this.setIsDeleted(false);
        }
    }

    ResultSet ViewIndividualAccount(String nationalId)
    {
        DbConnect db = new DbConnect();
        db.connect();
        String query ="SELECT * FROM compliance WHERE nationalId='"+nationalId+"'";
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
                "','"+this.accountNumber+
                 "','"+this. accountType+
                "','"+this. kycDocuments+
                "','"+this.compliance+
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
            JOptionPane.showMessageDialog(null, "  Compliance record successfully updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null, " system could not  update compliance details record");
        }
    }

}

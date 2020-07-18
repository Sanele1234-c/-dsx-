

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
public class Customer {
    private String nationalId;
    private String name;
    private String surname;
    private String emailAddress;
    private String gender;
    private String dateOfBirth;
    private String cellphoneNumber;
    private String physicalAddress;
    private String nextOfKeen;
    private String relationship;
    private Boolean isCustomerAdded;
    private Boolean isCustomerDeleted;


    String getNationalId() {
        return nationalId;
    }

    void setNationalId(String value) {
        if (!(value.isEmpty())) {
            nationalId = value;
        }
    }

    String getName() {
        return name;
    }

    void setName(String value) {
        if (!(value.isEmpty())) {
            name = value;
        }
    }

    String getSurname() {
        return surname;
    }

    void setSurname(String value) {
        if (!(value.isEmpty())) {
            surname = value;
        }
    }

    String getEmailAddress() {
        return emailAddress;
    }

    void setEmailAddress(String value) {
        if (!(value.isEmpty())) {
            emailAddress = value;
        }
    }

    void setIsAdded(Boolean value) {
        this.isCustomerAdded = value;
    }

    Boolean getIsAdded() {
        return this.isCustomerAdded;
    }

    // get and set isCustomerDeleted
    void setIsCustomerDeleted(Boolean value) {
        this.isCustomerDeleted = value;
    }

    Boolean getIsCustomerDeleted() {

        return this.isCustomerDeleted;
    }

    String getGender() {

        return gender;
    }

    void setGender(String value) {
        if (value.isEmpty()) {
            gender = value;
        }
    }

    String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String value) {
        if (!(value.isEmpty())) {
            dateOfBirth = value;
        }
    }

    String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String value) {
        if (!(value.isEmpty())) {
            physicalAddress = value;
        }
    }

    String getNextOfKeen() {
        return nextOfKeen;
    }

    public void setNextOfKeen(String value) {
        if (!(value.isEmpty())) {
            nextOfKeen = value;
        }
    }

    String getRelationship() {
        return relationship;
    }

    void setRelationship(String value) {
        if (!(value.isEmpty())) {
            relationship = value;
        }
    }

    String getCellphoneNumber() {
        return cellphoneNumber;
    }

    void setCellphoneNumber(String value) {
        if (!(value.isEmpty())) {
            cellphoneNumber = value;
        }
    }

    Boolean checkNationalId(String nationalId) {

        if (nationalId.equalsIgnoreCase(getNationalId())) {
            return true;
        } else {
            return false;
        }
    }

    // add client detals
    void AddCustomerDetails(DbConnect db) {
        // insert into database
        db.connect();

        Boolean x;
        x = true;
        String query;
        query = "INSERT INTO Customer VALUES('" + this.nationalId +
                "','" + this.name +
                "','" + this.surname +
                "','" + this.gender +
                "','" + this.dateOfBirth +
                "','" + this.emailAddress +
                "','" + this.cellphoneNumber +
                "','" + this.physicalAddress +
                "','" + this.nextOfKeen +
                "','" + this.relationship + "')";

        Statement st = db.createStatement();

        try {

            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsAdded(true);
            {
                JOptionPane.showMessageDialog(null, " customer added successfully", "important", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " you can not add this customer", "warning", JOptionPane.INFORMATION_MESSAGE);
            this.setIsAdded(false);
        }
    }

    void deleteCustomer(DbConnect db) {
        db.connect();

        Boolean x;
        x = true;
        String query = "DELETE FROM customer WHERE nationalId='" + this.getNationalId() + "'";
        Statement st = db.createStatement();
        try {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsCustomerDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The customer is successfully deleted");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the customer");
            this.setIsCustomerDeleted(false);
        }
    }

    ResultSet ViewIndividualCustomer(DbConnect db, String nationalId) {

        db.connect();

        String query = "SELECT * FROM customer WHERE nationalId='" + nationalId + "'";
        Statement st = db.createStatement();
        try {
            ResultSet res = st.executeQuery(query);
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    void UpdateCustomer(DbConnect db, String nationalId) {
        db.connect();


        Boolean isCustomerUpdated = true;
        String query = "UPDATE customer SET nationalId='" + this.nationalId +
                "',name='" + this.name +
                "',surname='" + this.surname +
                "',dateOfBirth='" + this.dateOfBirth +
                "',gender='" + this.gender +
                "',nextOfKeen='" + this.nextOfKeen +
                "',relationship='" + this.relationship +
                "',emailAddress='" + this.emailAddress +
                "',physicalAddress='" + this.physicalAddress +
                "',cellphoneNumber='" + this.cellphoneNumber +
                "' WHERE nationalId='" + nationalId + "'";
        Statement st = db.createStatement();
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            isCustomerUpdated = false;
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (isCustomerUpdated) {
            JOptionPane.showMessageDialog(null, " customer record successfully updated");
        } else {
            JOptionPane.showMessageDialog(null, " system could not  update customer record");
        }
    }


    public void deleteCustomer() {
    }

    public void ViewIndividualCustomer() {
    }
}

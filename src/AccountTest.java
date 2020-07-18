import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.Mockito;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.sql.*;

// Include annotation
@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    @Mock
    DbConnect dbConnect;

    @Test
    public void testGetNationalId() {

        Account instance = new Account();
        String expResult = null;
        String result = instance.getNationalId();
        assertEquals(result, expResult);

    }
    @Test
    public void testSetNationalId() {
        Account instance = new Account();
        instance.setNationalId("B2001");
        String expResult = "B2001";
        String result = instance.getNationalId();
        assertEquals(result, expResult);

    }
    @Test
    public void testGetBankCode(){
        Account instance = new Account();
        String expResult = null;
        String result = instance.getBankCode();
        assertEquals(result, expResult);
    }

    @Test
    public void testSetBankCode() {
        Account instance = new Account();
        instance.setBankCode("B2001");
        String expResult = "B2001";
        String result = instance.getBankCode();
        assertEquals(result, expResult);
    }
    @Test
    public void testGetAccountNumber(){
        Account instance = new Account();
        String expResult = null;
        String result = instance.getAccountNumber();
        assertEquals(result, expResult);
    }

    @Test
    public void testSetAccountNumber() {
        Account instance = new Account();
        instance.setAccountNumber("B2001");
        String expResult = "B2001";
        String result = instance.getAccountNumber();
        assertEquals(result, expResult);
    }
    @Test
    public void testGetAccountType(){
        Account instance = new Account();
        String expResult = null;
        String result = instance.getAccountType();
        assertEquals(result, expResult);
    }

    @Test
    public void testSetAccountType() {
        Account instance = new Account();
        instance.setAccountType("B2001");
        String expResult = "B2001";
        String result = instance.getAccountType();
        assertEquals(result, expResult);
    }
    @Test
    public void testGetKycDocuments(){
        Account instance = new Account();
        String expResult = null;
        String result = instance.getKycDocuments();
        assertEquals(result, expResult);
    }
    @Test
    public void testSetKycDocuments(){
        Account instance = new Account();
        instance.setKycDocuments("ghfh");
        String expResult = "ghfh";
        String result = instance.getKycDocuments();
        assertEquals(result, expResult);
    }
    @Test
    public void testAddAccountDetails(){
        Account instance = new Account();
        instance.setNationalId("25000");
        when(dbConnect.createStatement()).thenReturn(new StatementForTest());
        instance.AddAccountDetails(dbConnect);

    }
    @Test
    public void testDeleteAccount(){
        Account instance = new Account();
        instance.setNationalId("85922");
        when(dbConnect.createStatement()).thenReturn(new StatementForTest());
        instance.deleteAccount(dbConnect);
    }
    @Test
    public void testUpdateAccount(){
        Account instance = new Account();
        instance.setNationalId("45212");
        when(dbConnect.createStatement()).thenReturn(new StatementForTest());
        instance.UpdateAccount(dbConnect, "45212" );
    }
}

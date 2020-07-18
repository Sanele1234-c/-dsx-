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
public class BankTest {
    @Mock
    DbConnect dbConnect;

    @Test
    public void testGetBankCode() {
        Bank instance = new Bank();
        String expResult = null;
        String result = instance.getBankCode();
        assertEquals(result, expResult);
    }
    @Test
    public void testSetBankCode(){
        Bank instance = new Bank();
        instance.setBankCode("B100");
        String expResult = "B100";
        String result = instance.getBankCode();
        assertEquals(result, expResult);

    }
    @Test
    public void testGetBankName() {
        Bank instance = new Bank();
        String expResult = null;
        String result = instance.getBankName();
        assertEquals(result, expResult);
    }
    @Test
    public void testSetBankName(){
        Bank instance = new Bank();
        instance.setBankName("Sanele");
        String expResult = "Sanele";
        String result = instance.getBankName();
        assertEquals(result, expResult);

    }
    @Test
    public void testGetBranchCode() {
        Bank instance = new Bank();
        String expResult = null;
        String result = instance.getBranchCode();
        assertEquals(result, expResult);
    }
    @Test
    public void testSetBranchCode(){
        Bank instance = new Bank();
        instance.setBranchCode("Sanele");
        String expResult = "Sanele";
        String result = instance.getBranchCode();
        assertEquals(result, expResult);

    }
    @Test
    public void testGetBranchName() {
        Bank instance = new Bank();
        String expResult = null;
        String result = instance.getBranchName();
        assertEquals(result, expResult);
    }
    @Test
    public void testSetBranchName(){
        Bank instance = new Bank();
        instance.setBranchName("Sanele");
        String expResult = "Sanele";
        String result = instance.getBranchName();
        assertEquals(result, expResult);

    }
    @Test
    public void testAddBankDetails(){
        Bank instance = new Bank();
        instance.setBankCode("25000");
        when(dbConnect.createStatement()).thenReturn(new StatementForTest());
        instance.AddBankDetails(dbConnect);

    }
    @Test
    public void testDeleteBank(){
        Bank instance = new Bank();
        instance.setBankCode("85922");
        when(dbConnect.createStatement()).thenReturn(new StatementForTest());
        instance.deleteBank(dbConnect);
    }
    @Test
    public void testViewIndividualBank(){
        Bank instance = new Bank();
        instance.setBankCode("45212");
        when(dbConnect.createStatement()).thenReturn(new StatementForTest());
        instance.ViewIndividualBank(dbConnect, "45212");
    }
    @Test
    public void testUpdateBank(){
        Bank instance = new Bank();
        instance.setBankCode("45212");
        when(dbConnect.createStatement()).thenReturn(new StatementForTest());
        instance.UpdateBank(dbConnect, "45212");
    }
}

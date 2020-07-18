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

import java.awt.event.ActionEvent;
import java.sql.*;

// Include annotation
@RunWith(MockitoJUnitRunner.class)
public class CustomerFormTest {
 @Mock DbConnect dbConnect;
 @Mock ActionEvent actionEvent;

 @Test
    public void testJButton1ActionPerformed(){
     CustomerForm instance = new CustomerForm(dbConnect);
     instance.jButton1ActionPerformed(actionEvent);
 }
 @Test
 public void testJButton2ActionPerformed(){
  CustomerForm instance = new CustomerForm(dbConnect);
  instance.jButton1ActionPerformed(actionEvent);
 }
 @Test
 public void testjButton6ActionPerformed(){
  CustomerForm instance = new CustomerForm(dbConnect);
  instance.jButton1ActionPerformed(actionEvent);
 }
}

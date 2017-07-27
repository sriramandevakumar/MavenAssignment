package Testcase;

import java.util.HashMap;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;
import StockMaintance.FileException;
import StockMaintance.MainReadFile; 

public class TestJunit {

   MainReadFile messageUtil = new MainReadFile(null);
   HashMap<Double,String> hash1=new HashMap<Double,String>();
   HashMap<Double,String> hash2=new HashMap<Double,String>();
   
   @Test(expected = FileException.class)
   public void WithoutExtention() throws FileException {	
      messageUtil.ReadFile("kjshd");     
   }
   
   @Test(expected = FileException.class)
   public void FileNotFound() throws FileException {	
      messageUtil.ReadFile("Text.txt");     
   }
   
   @Test(expected = FileException.class)
   public void FileNotFound1() throws FileException {	
      messageUtil.ReadFile("Test.xls"); 
   }

   @Test
   public void testFileCheck() throws FileException {
       hash2.put(1000000.0,"SGI-10000");
       hash2.put(12740.0,"GOOG - 100,AMZN - 90,MS - 80");
       hash2.put(5100.0,"GOOG - 20,SGI-20,GOOG -11");
       assertEquals(hash2,messageUtil.ReadFile("test.txt"));
   }
   
   @Test
   public void testFileCheck1() throws FileException {
	   hash1.put(12740.0,"GOOG - 100,AMZN - 90,MS - 80");
  	   hash1.put(2740.0, "AMZN - 90,MS - 80");
  	   hash1.put(900.0,"AMZN - 90" );
       assertEquals(hash1,messageUtil.ReadFile("test1.txt"));
   }
}
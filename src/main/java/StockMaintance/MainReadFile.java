/**
 * 
 */
/**
 * @author sriraman_d
 *
 */
package StockMaintance;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MainReadFile {
    private static Scanner InputFileName;
    public static HashMap<String, Double> hash=new HashMap<String, Double>();
	public MainReadFile(String message) {
		// TODO Auto-generated constructor stub
	}

	public static void  main(String[] args) throws FileException  {
	    	String File=System.getProperty("FileName");
	    	ReadFile(File);
	}
	
	public static HashMap<Double, String> ReadFile(String Filename) throws  FileException{
		HashMap< Double,String> versionString=null;
	   try{
	    	if(Filename.contains(".txt")){
		    	hash=ReadingRate();
		    	versionString = readingLinesfromFiles(Filename);
		    	Set<Entry<Double, String>> entrySet = versionString.entrySet();
		    	List<Double> list= new ArrayList<Double>();
		    	   for (Entry<Double, String> entry : entrySet){
		    	     list.add(entry.getKey());
		    	   }
		    	   Collections.sort(list, Collections.reverseOrder());
		    	   for(Double DoubleValue:list){
		    		  for (Entry<Double, String> entry : entrySet) 
			    	   {
		    			  if(DoubleValue==entry.getKey()){
		    				  System.out.println(entry.getValue());
		    				  versionString.put(entry.getKey(),entry.getValue());
		    			  }
			    	   }
		    		  
		    	  }
	    	}else{
	    		throw new FileException ("Given document is not in prescribed extention");
	    	}
		}catch(NullPointerException e){
			throw new FileException("Given document is not in prescribed fromat",e);
		}catch (FileNotFoundException e) {
			throw new FileException("Given document is not found in location",e);
		} catch (Exception e) {
			throw new FileException(e);
		}
		return versionString;
	}

	private static HashMap<String, Double> ReadingRate() throws  FileException {
		 try {
	            FileReader reader = new FileReader("rate.txt");
	            BufferedReader bufferedReader = new BufferedReader(reader);
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	            	if(line.contains("-")){
		            	List<String> LineSpliter = Arrays.asList(line.split("-"));
		            	if(LineSpliter.size()>=2){
			            	String Key=LineSpliter.get(0).trim();
			            	double Value=Double.parseDouble(LineSpliter.get(1).trim());
			            	hash.put(Key, Value);
		            	}
	            	}
	            }
	            reader.close();
	        }catch (NumberFormatException e) {
	            throw new FileException("Please fill correct rate in rate document",e);
	        }catch (Exception e) {
	            throw new FileException(e);
	        }
		 return hash;
	}

    public static  HashMap< Double,String> readingLinesfromFiles(String Filename) throws Exception {
    	   HashMap< Double,String> Valuehash=new HashMap< Double,String>();
		   try {	
		            FileReader reader = new FileReader(Filename);
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            double Value=0;
		            String variable=null;
		            while ((line = bufferedReader.readLine()) != null){
		            		double total=0;
			            	List<String> LineSpliter = Arrays.asList(line.split(","));
			                for(int i=0;i<LineSpliter.size();i++){
			                	String[] Key=LineSpliter.get(i).split("-");
			                	if(Key.length>=2){
				                	variable =Key[0].trim();
				                	Value=Double.parseDouble(Key[1].trim())*hash.get(variable);
				                	total=total+Value;
			                	}
			                }
		                	Valuehash.put(total, line);
		            }
		            reader.close();
	        	}catch(NullPointerException e) {
	        		    throw new FileException("Without correct rate we cant proceed further",e);
	        	}
	return Valuehash;
    }
}

package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DatabaseManager {
	
	public static void serialize(Database obj)
	{
		ObjectOutputStream out=null;
		FileOutputStream file=null;
		try
        {    
            //Saving of object in a file 
			File f = new File("database.txt");
		    FileWriter fw = new FileWriter(f, false);
		    fw.flush();
            file = new FileOutputStream(f); 
            out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(obj); 
            
            out.close(); 
            fw.close();
            file.close(); 
            
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
	}
	
	public static Database deserialize()
	{
		Database obj=null;
		ObjectInputStream in=null;
		FileInputStream file=null;
		try
        {    
            // Reading the object from a file 
			
			file = new FileInputStream("database.txt"); 
	        in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            obj = (Database)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been deserialized "); 
           
        } 
		catch(java.io.EOFException e)
		{
			return null;
		}
          
        catch(IOException ex) 
        { 
        	//System.out.println(new File(".").getAbsolutePath());
            System.out.println("IOException is caught"); 
            ex.printStackTrace();
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		
		
			return obj;
		
	}

}

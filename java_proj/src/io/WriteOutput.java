package io;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;
//imports 

public class WriteOutput {

	// initializing path and array of cases
	private String path;
	private ArrayList<String> arraylist;
	
	// constructor that receives array of cases and output file path
	public WriteOutput(String filePath, ArrayList<String> outputArray){
		path = filePath;
		arraylist = outputArray;
	}
	
	public void output() 
	{ 

		try 
		{

		// initializing print/file writter so we can create a file and write into the file
		FileWriter fw = new FileWriter (path);
		PrintWriter pw = new PrintWriter (fw);
		
		// a for loop that goves over every element in the array and prints it
		for(int i = 0; i< arraylist.size();i++)
		{
			pw.println(arraylist.get(i));
		}

		// closes file writer
		fw.close();
		}

		// I/O exception    
	    catch (IOException e) 
	    {
   			e.printStackTrace();
		}	
	}
}

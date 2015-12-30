package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import objects.airport;

public class FlightControl {

	private static int[] airportConfigArray = new int[3];
	private static String outputFilePath;
	private static String inputFilePath;
	
	public static void main(String[] args) {
		
		processArgs(args);
		processAirportConfigFile();
		airport anAirport = new airport(airportConfigArray[0], airportConfigArray[1]);
		
		//Once an airport has been created with the config file it along with the path of the output file is passed to
		//the simulation.
		AirplaneInputReader aReader = new AirplaneInputReader(anAirport, outputFilePath, airportConfigArray[2]);
		aReader.run();

	}
	

	/* This function processes the arguments given to the program when it is being run.
	 * The file path for the input file is stored as  inputFilePath
	 * The file path for the output file is stored as outputFilePath.
	 * If the first Input is -h a program help menu is called. 
	 * If the arguments are not -h or the appropriate file path input we throw an error
	 * if there was no arguments given we throw an exception.
	 */
	public static void processArgs(String[] inputArray){
		
		try{
			//check flags. If -f selected run the simulation, sends input txt file
			if(inputArray[0].equals("-f") && inputArray[2].equals("-o")){
			
				inputFilePath = inputArray[1];
				outputFilePath = inputArray[3];
				
			}
			//if -h selected display the description
			
			else if(inputArray[0].equals("-h")){
				programHelp();
			}
			
			//too many or too few arguments
			else{
				System.out.println("The number of arguments entered is incorrect.");
			}
		}
		//Check if arguments were given
		catch(ArrayIndexOutOfBoundsException en){
			System.out.println("No argument given.");
		}
	}

	/* This function takes the filename of the Airport configuration file. 
	 * It attempts to read the file specified and then process it.
	 * It makes airportConfigArray full with the values of P, R, T
	 */
	public static void processAirportConfigFile(){
		
		//Scanner Creation
		Scanner inputSteam = null;
		
		//Attempts to open the file
		try{	
			inputSteam = new Scanner(new File(inputFilePath));
		}
		
		// Throws an exception when the File is not found
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file: " + inputFilePath);
			System.exit(0);
		}
		
		// index for an array
		int i=0;
		
		// runs the loop until reaches the end of file
		while(inputSteam.hasNextLine())
		{
			// reads every single line, splits the string and  saves the input in  airportConfigArray
			String line = inputSteam.nextLine();
			String[] parts = line.split("="); 
			airportConfigArray[i]= Integer.parseInt(parts[1]);	
			i++;
			
		}
		// closing reading from file
		inputSteam.close();		
	}
	
	/* This function prints out a help menu for the program. It is called if the arguments when the program is called are "-h"
	 * 
	 */
	public static void programHelp(){
		
		
		System.out.println("\n\t� -h: should show a short description of what the program does and how to run it.Along with the name and email of the developers of the code.");
		System.out.println("\n\t� -f <input_file_name>: specifies the path to the input file which contains information about runaways, parkings, and time unit (time unit is an integer showing how long a unit of time is in seconds).");
		System.out.println("\n\t� -o <output_file_name>: specifies the path to the output file.");
		System.out.println("\n\nTherefore, there are \"only\" two valid ways of running the program: \n\t1. <program_name> -h");
		System.out.println("\n\t2. <program_name> -f <input_file_name> -o <output_file_name>\n");
	}
	
}

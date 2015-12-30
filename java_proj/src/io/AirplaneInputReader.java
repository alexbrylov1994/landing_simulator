package io;

//package com.assignment1;
import java.util.ArrayList;
import java.util.Scanner;

import logic.CommandTower;
import objects.airplane;
import objects.airport;

import java.io.*;

public class AirplaneInputReader extends Thread{
    
    private CommandTower aTower; 
    private String outputFilepath;
    private airport anAirport;
    private String case_number;
    private int timeUnit;
    
    /*Constructor requires an airport and a file path for the output file.
     * The constructor then creates a command tower with the 
     */
    public AirplaneInputReader(airport inputAirPort, String filePath, int timeU){
        anAirport = inputAirPort;
        aTower = new CommandTower(anAirport);
        outputFilepath = filePath;
        timeUnit = timeU;
        
    }
    
    /*function for clarity calls userInput function
     * 
     * 
     */
    @Override
    public void run(){
        userInput();
        
    }
    /*The function reads the command line input and processes it.
     *To deal with the first instance the first if is done to see if the user is inputting a "CASE"
     *The second if checks whether the input of the user was end which triggers the writing of the output file and
     *ending the program.
     *the third if checks if the user has pressed enter signaling the start of a new case. 
     *The else happens when the user is ready to input airplane input. It then add the airport to the command tower and 
     *write the appropriate output. 
     */
    public void userInput(){
        ArrayList<String> outputArray = new ArrayList<String>();
        String input;
        int[] airplane_Tuple= new int[6];
        @SuppressWarnings("resource")
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        // runs the program until user types "END"
        while(true){
            //takes user input, if there is a C, it will do initialization and add Case to the array
        	input = (in.nextLine()).trim();
        	if (input.contains("C")){
        		case_number = input;
        		outputArray.add(case_number);
        	}

            // Checks if input Equals to "END", sends output array with output file 
            // to WriteOutput and ends running the program
        	else if(input.equals("END")){
        		WriteOutput writenFile = new WriteOutput(outputFilepath, outputArray); //flightcontrol.getOutputFile()
        		writenFile.output();
        		System.exit(0);
        	}

            // if enter is pressed, prompt to enter a new Case name 
            // and send it to the array
        	else if(input.length()==0){
//        		input = in.nextLine();
        		case_number = input;
        		outputArray.add(case_number);
        	}
        	
        	else{
                //gets right of () around input and divides the string using comma and saves it into the array
                String u_input= input.substring(1, input.length()-1);
                String[] user_input = u_input.split(",");
                
                //converts string into integer and saves all 6 numbers into the array.
                for (int i = 0; i< user_input.length; i++){
                	
                    airplane_Tuple[i]= Integer.parseInt(user_input[i]);
                }
                airplane anAirplane = new airplane(airplane_Tuple, timeUnit);
                outputArray.add(aTower.addPlane(anAirplane));
        	}
        }
    }
}

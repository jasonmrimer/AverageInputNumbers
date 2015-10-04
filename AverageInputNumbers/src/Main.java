//JasonRimerP2
//CMIS141 Project 2
//Programmer: Jason M. Rimer
//Date: 04MAR2012
//The purpose of this program is to calculate the sum
//	of a numbers input by the user up to 100.

import java.util.*;
import javax.swing.*;

public class Main {//startClass
	
	//Sum and Average print method
	public static JOptionPane printSum(int option, int numCounter, float sum, float average) {
		
		if (option == JOptionPane.YES_OPTION) {//startCloseIf - check if user confirmed information
			
			JOptionPane.showMessageDialog(null,
			"You entered " + numCounter + " numbers and the sum " +
			"of those numbers is " + sum + ".\n" + 
			"The average of those numbers is: " + average + "\n\n" +
			"(This program will exit upon clicking \"OK\")",
			"What's Your Number?",
			JOptionPane.INFORMATION_MESSAGE);
			
		}//endCloseIf
		
		return null;
		
	}
	
	public static void main(String[] args) {//startMain
		
		//1. Introduction
		
		int numCounter = 1;//Declare and start numCounter at 1
		int option = JOptionPane.NO_OPTION;
		int greaterThanCounter = 0;
		float sum = 0;
		float average = 0;
		float []inputNumberArrayPermanent = new float [1];//Declare array to keep inputs
		
		while (option == JOptionPane.NO_OPTION) {//startWhile
		
		float []inputNumberArrayTemporary = new float [numCounter];//Declare array for number confirmation later
		
		String inputNumberString = 
			JOptionPane.showInputDialog(null,
			"This program will calculate the sum of numbers input by the user.\n" + 
			"If the sum reaches 100, a warning will be displayed.\n" + 
			"At any time, the user may:\n" +
			"Enter \"=\" to calculate sum\n" +
			"Enter \"x\" or \"X\" to exit or restart the program\n\n" +
			"Upon completion, all numbers will be displayed for accuracy confirmation.\n\n" +
			"What is your Number " + numCounter + ": ",
			"What's Your Number?",
			JOptionPane.QUESTION_MESSAGE);
		
			//Check whether the user wants to exit the program after entering x, X, or nothing
			if (inputNumberString.equals("x") || inputNumberString.equals("X") || inputNumberString.equals("")) {//startIf
				
				option = 
					JOptionPane.showConfirmDialog(null, 
					"Are you sure you want to exit this program?\n" +
					"(\"Yes\" exits the program & \"No\" restarts the program)",//Prompt User 
					"What's Your Number?",//Title
					JOptionPane.YES_NO_OPTION);//Get yes/no
				
				//Invoke calculation print method
				printSum(option, numCounter, sum, average);
				
				if (option == JOptionPane.NO_OPTION) {//startIf - Reset the variables to restart the program
					
					numCounter = 1;
					sum = 0;
					average = 0;
				
				}//endIf
				
			}//endIf
			
			//Input is "="
			else if (inputNumberString.equals("=")) {//startCalculateIf
				 
				String inputNumberArrayString = Arrays.toString(inputNumberArrayPermanent);//Convert array to printable string
				
				option =//User accuracy confirmation
					JOptionPane.showConfirmDialog(null, 
					"The numbers entered were:\n" +
					inputNumberArrayString + "\n" +
					"Are these correct and would the user like to calculate the sum and average?\n\n" +
					"(\"Yes\" will calculate sum and \"No\" will restart the program)",
					"What's Your Number? - Accuracy Check",
					JOptionPane.YES_NO_OPTION);
				
				//Invoke calculation print method
				printSum(option, numCounter, sum, average);
				
				if (option == JOptionPane.NO_OPTION) {//startIf - Reset the variables to restart the program
					
					numCounter = 1;
					sum = 0;
					average = 0;
				
				}//endIf
						
			}//endCalculateIf
			
			//Input is a float
			else {//startElse
				
				//The following code creates an array that changes each time a new number is input to allow
				//	printing and confirmation by the user.
				float inputNumberFloat = Float.parseFloat(inputNumberString);//Convert String to Float
				inputNumberArrayTemporary[numCounter-1] = inputNumberFloat;
				
				for (int i = 0; i < (numCounter - 1); i++) {//startFor - Write Old Array to New (empty) array
					inputNumberArrayTemporary[i] = inputNumberArrayPermanent[i];
				}//endFor
				
				inputNumberArrayPermanent = inputNumberArrayTemporary;//Increase the size of the permanent array
				
				sum += inputNumberFloat;
				average = sum / numCounter;
				numCounter++;//Increase counter
				
				//Input creates a sum greater than 100
				if (sum >= 100 && greaterThanCounter == 0){//startIf
					
					String inputNumberArrayString = Arrays.toString(inputNumberArrayPermanent);//Convert array to printable string
					
					option =//Greater than 100 warning
						JOptionPane.showConfirmDialog(null,
						"The sum of the numbers entered so far:\n" +
						inputNumberArrayString + "\n" +
						"are greater than 100.\n" + 
						"Would the user like to calculate the sum and average now?\n" +
						"(\"No\" will continue the program and \"Yes\" will restart the program)",
						"What's Your Number? - Accuracy Check",
						JOptionPane.YES_NO_OPTION);
				
					greaterThanCounter++;
				}//endIf
				
			}//endElse
		
		}//endWhile
	
	}//endMain
	
}//endClass

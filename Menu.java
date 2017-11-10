/*//////////////////////////////////////////////////////////////////////
Authors: Dozier Atwell, Ernesto Contreras, Josh Boros, Surya Chigurupati
Class: Software Components Fall 2017
Description: Main menu of Database Management Team term project.
Last Modified: 10/14/2017 3:37 P.M. on Java 9
*///////////////////////////////////////////////////////////////////////

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Menu
{
public static void main(String args[])
throws IOException
{

//Scanner to get user input
BufferedReader in = new  BufferedReader
(new InputStreamReader(System.in));

Scanner scan = new Scanner(System.in);

int choice;

do
{
    
//Menu
System.out.println("\n****************Main Menu****************");
System.out.println("\n1) Look At Questions In Question Bank.");
System.out.println("2) Random Test Generation");
System.out.println("3) Create Your Own Test");
System.out.println("4) EXIT");
System.out.println("\n*****************************************");
System.out.println("Enter the index for the task you want to perform:");

//get user input
choice = Integer.parseInt(in.readLine());

//Look into database
if (choice == 1)
{
    System.out.println("\nSorry, there are  no questions in the database right now." 
                        + "\nPlease try again later!");
}

//Create random test
else if (choice == 2)
{
    System.out.println("\nRandom Test Generation");
    System.out.println("*****************************************");
    System.out.println("Enter Chapter Title(s): ");
    String subject = scan.nextLine();
    System.out.println("Enter Section(s): ");
    Double section = scan.nextDouble();
    System.out.println("Enter level of difficulty of questions: ");
    int difficulty = scan.nextInt();
    System.out.println("How many questiosn would you like to print?");
    int number = scan.nextInt();
    /*System.out.println("Would you like the answers to the questions as well?");
    String answer = scan.nextLine();*/    
}

//Create own test
else if (choice == 3)
{
    System.out.println("\nCreate Your Own Test");
    System.out.println("*****************************************");
    System.out.println("From the given PDF document, "
                    + "\npleae select the number associated with"
                     + "\nthe question you would like in your test.");

}

//Exit
else if (choice == 4)
{
    System.out.println("\nExiting...have a nice day!");
    break;
}

//Error
else 
{
    System.out.println("\n");
    System.out.println("Sorry, that option does not exist! PLease try again!");
} 

} while (choice != 5);

} 
}




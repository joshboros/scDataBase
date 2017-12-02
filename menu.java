//SC


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

public class menu 
{
	//Print ReadXMLFile.java to terminal
    private static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
      }

	//Runtime process to execute ReadXMLFile.java
    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines("", pro.getInputStream());
        pro.waitFor();
      }
	
	public static void main(String args[]) 
	throws IOException, InterruptedException 
	{
    
        BufferedReader in = new  BufferedReader
        (new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int choice;

        System.out.println("Enter database name:");
        String file = scan.nextLine();

        System.out.println("Select type of test to create:");
        System.out.println("A. LaTeX/PDF");
        System.out.println("B. Web");
        String test = scan.nextLine();

        System.out.println("Enter test name (alphanumeric characters and spaces only)");
        String testname = scan.nextLine();
        String useablename = testname;
        testname = testname.replaceAll(" ", "_");
                
        LatexFile database1 = null;
        htmlFile database2 = new htmlFile(file);
        boolean lbase = false; //true = Latex, false = HTML
        boolean hbase = false; //true = HTML, false = Latex
        if (test.charAt(0) == 'A' || test.charAt(0) == 'a') 
        {
            lbase = true;
            hbase = false;
        }
        else if(test.charAt(0) == 'B' || test.charAt(0) == 'b') 
        {
            hbase = true;
            lbase = false;
        }
        
        if(lbase==true)
        {
            database1 = new LatexFile(testname + ".tex",file);
            database1.WriteLatexHead(useablename);
        }
        

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
        
        choice = Integer.parseInt(in.readLine());

        //See Question Bank
        if (choice == 1)
        {
            System.out.println("\nLOOK AT ALL QUESTIONS");
            System.out.println("************************");

            try {
                runProcess("javac ReadXMLFile.java");
                runProcess("java ReadXMLFile");
              } catch (Exception e) {
                e.printStackTrace();
              }

        }

        //Random Test
        else if (choice == 2)
        {
            System.out.println("\nCREATE RANDOM TEST");
            System.out.println("*********************");
        }

        //Create Your Own Test
        else if (choice == 3)
        {
            System.out.println("\nCREATE YOUR OWN TEST (Unstable)");
            System.out.println("**********************************");

			    System.out.println("Enter question difficulties to print");
                int difficulty = scan.nextInt();
            
                System.out.println("Enter max number of questions to print");
                int questionQuantity = scan.nextInt();
            
                if(lbase)
                database1.WriteLatexQuestions(sectionTopic,section,difficulty,questionQuantity);
                if (hbase)
                database2.WritehtmlQuestions(sectionTopic,section,difficulty,questionQuantity);
            
                System.out.println("Do you want to continue adding questions? Y = yes, N = no");
                String resp = scan.next();
            
                if (resp.charAt(0) == ('Y' | 'y'))
                continues = true;
                else
                continues = false;
            
            
            System.out.println("Enter subject covered");
            String sectionTopic = scan.nextLine();
            
            boolean continues = true;
            while (continues)
            {
                System.out.println("Enter sections to print");
                int section = scan.nextInt();
            
                System.out.println("Enter question difficulties to print");
                int difficulty = scan.nextInt();
            
                System.out.println("Enter max number of questions to print");
                int questionQuantity = scan.nextInt();
            
                if(lbase)
                database1.WriteLatexQuestions(sectionTopic,section,difficulty,questionQuantity);
                if (hbase)
                database2.WritehtmlQuestions(sectionTopic,section,difficulty,questionQuantity);
            
                System.out.println("Do you want to continue adding questions? Y = yes, N = no");
                String resp = scan.next();
            
                if (resp.charAt(0) == ('Y' | 'y'))
                continues = true;
                else
                continues = false;
            } 
            
            System.out.println("Test file generated. Goodbye");
            
            if(lbase==true) 
            {
                database1.WriteLatexFoot();
                Runtime run = Runtime.getRuntime();
                Process pr = run.exec("pdflatex " + testname + ".tex");
                pr.waitFor();
            }
            
            if(hbase==true)
            database2.GeneratehtmlTest(useablename);
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

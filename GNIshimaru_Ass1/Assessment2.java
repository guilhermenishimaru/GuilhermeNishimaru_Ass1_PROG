import java.io.*; //import library package
import java.io.FileNotFoundException;
import java.util.Scanner;//to be able to scan waht is inputed by the user

public class Assessment2 {
   public static void main(String[] args) {
       Scanner consoleScanner = new Scanner(System.in);
       
       System.out.print("Enter the path to the file: ");
       String filePath = consoleScanner.nextLine(); //read the path inputed
       
       final int maxStudents = 100; //define the maximun size of the array
       String[] studentDetails = new String[maxStudents]; //array to store student details
       double[] totalMarks = new double[maxStudents]; //array to store ttal marks
       int numberOfStudents = 0; //create the variable to count the number of students
       
   try {
        File file = new File(filePath);   //show the path to the file
        Scanner myScanner = new Scanner(file);  //create scanner object to read the file
        
        //print header; unit name;
        StringBuilder header = new StringBuilder();
        for (int i = 0; i < 3 && myScanner.hasNextLine(); i++) { //hasNextLine continue as long as the scanner has another line to read
            String headerLine = myScanner.nextLine();
            header.append(headerLine).append("\n"); //"\n" moves to the next line
            System.out.println(headerLine);
        }  
        StringBuilder finalLines = new StringBuilder();

        //Reads, calculates and print the marks with the total marks included
        while (myScanner.hasNextLine()) {              //read the file line by line
            String line = myScanner.nextLine();
            
            //Remove all the comments
            String[] parts = line.split("//");         //separate the cooments after "//" 
            StringBuilder cleanedLine = new StringBuilder(parts[0].trim());  //stringbuilder allows to modify the same object without creating new ones and trim removes any write spaces
            
            //Calculating total marks
            String[] Parts = cleanedLine.toString().split("\\s+");
            double totalMark = 0;
            if (Parts.length >= 3) {
                try {
                    for (int i = Parts.length - 3; i < Parts.length; i++) {
                        totalMark += Double.parseDouble(Parts[i].trim()); //parseDouble is converting from string to double
                    }
                } catch (NumberFormatException e) { //numberformatexception incase the convertion to double does not work
                  System.out.println("Error in " + line);
                }
            } else {
            //show when there are no sufficient marks written
            System.out.println("Not enough marks available" + line);
            cleanedLine.append("Error");
            }
        
            //adding the total marks at the end of each line
            cleanedLine.append("      Total Mark: ").append(totalMark);
            finalLines.append(cleanedLine.toString().trim()).append("\n");
            studentDetails[numberOfStudents] = cleanedLine.toString().trim(); //store the total mark to use later
            totalMarks[numberOfStudents] = totalMark; //store the total mark
            numberOfStudents++;
        }
        
        System.out.println(finalLines.toString());
        
        //creating the menu
        while (true) {
            System.out.println("\nMenu:");
            System.out.println( "1. Input cut-off mark");
            System.out.println("2. Print top 5 highest marks");
            System.out.println("3. Print top 5 lowest marks");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = consoleScanner.nextInt();
            
            switch (choice) {  //switch execute according to the choice scanned from the inpu
                case 1:
                    //Input cut-off mark
                    System.out.print("Enter the cut-off mark: ");
                    double cutOffMark = consoleScanner.nextInt();
        
                    System.out.println("\nStudents with total marks below the cut-off mark:");
                    for (int i = 0; i < numberOfStudents; i++) {
                        double totalMark = totalMarks[i];
                        if (totalMark < cutOffMark) {
                            System.out.println(studentDetails[i]);
                        }
                    }
                    break;
                case 2:
                    //Print top 5 highest marks
                    System.out.println("\nTop 5 students with the highest marks:");
                    printTop5Marks(studentDetails, totalMarks, numberOfStudents, true);
                    break;
                case 3:
                    //Print the students with the lowest marks
                    System.out.println ("\nTop 5 students with the lowest marks:");
                    printTop5Marks(studentDetails, totalMarks, numberOfStudents, false);
                    break;
                case 4:
                    //exit
                    consoleScanner.close();
                    myScanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }                 
    } catch (FileNotFoundException e) {
       System.out.println("An error has occured: File not found.");
       e.printStackTrace();
    }
    }               
    //void performs an action and boolean to determine true for highest marks and false for the smallest
    public static void printTop5Marks(String[] studentDetails, double[] totalMarks, int numberOfStudents, boolean highest) { 
        String[] sortedStudentDetails = studentDetails.clone();  //clone the arrays to avoid modifying the orginial ones causing permanent damage                                                   
        double[] sortedTotalMarks = totalMarks.clone();
        
        for (int i = 0; i < numberOfStudents -1; i++) {
            for (int j = i + 1; j < numberOfStudents; j++) {
                if ((highest && sortedTotalMarks[i] < sortedTotalMarks[j]) || (!highest && sortedTotalMarks[i] > sortedTotalMarks[j])) {
                    double tempMark = sortedTotalMarks[i]; //temporarily stores the value to swap
                    sortedTotalMarks[i] = sortedTotalMarks[j]; //swap the value of the index j to the value at index i if bigger or smaller number to keep on the sequence of comparisson 
                    sortedTotalMarks[j] = tempMark;             // assign the value to tempMark to keep comparing to the next number of the array
                    
                    String tempDetails = sortedStudentDetails[i];  //the same happens here
                    sortedStudentDetails[i] = sortedStudentDetails[j]; //ensures that the comparisson goes and the marks and details keep together
                    sortedStudentDetails[j] = tempDetails;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
                        System.out.println(sortedStudentDetails[i]);
        }
    }
}



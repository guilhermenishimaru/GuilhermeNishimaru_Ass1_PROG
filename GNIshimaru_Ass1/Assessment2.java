import java.io.*; //import library package
import java.io.FileNotFoundException;
import java.util.Scanner;//to be able to scan waht is inputed by the user

public class Assessment2
{
   public static void main(String[] args) {
       Scanner consoleScanner = new Scanner(System.in);
       
       System.out.print("Enter the path to the file: ");
       String filePath = consoleScanner.nextLine(); //read the path inputed
       
       int NumberOfStudents = 0; //create the variable to count the number of students
       
   try {
        File file = new File("C:\\students_grade.txt");   //show the path to the file
        Scanner myScanner = new Scanner(file);  //create scanner object to read the file
        
        //print header; unit name;
        StringBuilder header = new StringBuilder();
        for (int i = 0; i < 3 && myScanner.hasNextLine(); i++) {
            String headerLine = myScanner.nextLine();
            header.append(headerLine).append("\n");
            System.out.println(headerLine);
            }
            
        StringBuilder finalLines = new StringBuilder();
        
        //Reads, calculates and print the marks with the total marks included
        while (myScanner.hasNextLine()) {              //read the file line by line
            String line = myScanner.nextLine();
            NumberOfStudents++;  //count by adding one unit for each line scanned
            
            //Remove all the comments
            String[] parts = line.split("//");         //separate the cooments after "//" 
            StringBuilder cleanedLine = new StringBuilder(parts[0].trim());  //stringbuilder allows to modify the same object without creating new ones and trim removes any write spaces
            
            //Calculating total marks
            String[] Parts = cleanedLine.toString().split("\\s+");
            int totalMark = 0;
            if (Parts.length >= 3) {
                try {
                    for (int i = Parts.length - 3; i < Parts.length; i++) {
                        totalMark += Double.parseDouble(Parts[i].trim());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error in " + line);
                }
            } else {
            //show when there are no sufficient marks written
            System.out.println("Not enough marks available" + line);
            cleanedLine.append("Error");
            }
        
            //adding the total marks at the end of each line
            cleanedLine.append(" Total Mark: ").append(totalMark);
            finalLines.append(cleanedLine.toString().trim()).append("\n");
        }
        
        System.out.println(finalLines.toString());
    
        //Separate the students grades
        myScanner.close();                       //close the scanner
   } catch (FileNotFoundException e) {
       System.out.println("An error has occured: File not found.");
       e.printStackTrace();
   }
   consoleScanner.close();
}
}



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
        
        //print header: unit name
        if (myScanner.hasNextLine()) {
            String header = myScanner .nextLine();
            System.out.println(header);
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
            String[] Parts = cleanedLine.toString().split(",");
            int totalMark = 0;
            for (int i = Parts.length - 3; i < Parts.length; i++) {
                totalMark += Integer.parseInt(Parts[i].trim());
            }
            
            //adding the total marks at the end of each line
            cleanedLine.append("Total Mark: ").append(totalMark);
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



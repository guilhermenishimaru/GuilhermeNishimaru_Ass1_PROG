import java.io.*; //import library package
import java.io.FileNotFoundException;
import java.util.Scanner;//to be able to scan waht is inputed by the user

public class Assessment2
{
   public static void main(String[] args) {
       Scanner consoleScanner = new Scanner(System.in);
       
       System.out.print("Enter the path to the file: ");
       String filePath = consoleScanner.nextLine(); //read the path inputed
       
   try {
        File file = new File("C:\\students_grade.txt");   //show the path to the file
        Scanner myScanner = new Scanner(file);  //create scanner object to read the file
        
        //print header: unit name
        if (myScanner.hasNextLine()) {
            String header = myScanner .nextLine();
            System.out.println(header);
        }
        
        //Read and print the rest
        while (myScanner.hasNextLine()) {              //read the file line by line
            String line = myScanner.nextLine();
            String[] parts = line.split("//");         //separate the cooments after "//" 
            StringBuilder cleanedLine = new StringBuilder(parts[0].trim());  //stringbuilder allows to modify the same object without creating new ones and trim removes any write spaces
            System.out.println(line);
        }
        myScanner.close();                       //close the scanner
   }
   catch (FileNotFoundException e) {
       System.out.println("An error has occured: File not found.");
       e.printStackTrace();
   }
}
}

import java.io.*; //import library package
import java.io.FileNotFoundException;
import java.util.Scanner;//to be able to scan waht is inputed by the user

public class Assessment2
{
   public static void main(String[] args) {
   try {
        File file = new File("C:\\students_grade.txt");   //show the path to the file
        Scanner myScanner = new Scanner(file);  //create scanner object to read the file
        while (myScanner.hasNextLine()) {              //read the file line by line
            String line = myScanner.nextLine();
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

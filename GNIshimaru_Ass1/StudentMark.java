
import java.awt.Paint;

/**
 * Escreva uma descrição da classe StudentMark_Gnishi aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentMark
{
    
    public static void main(String[] args) {
        
       int numberOfStudents = 30;
       float[] marks = new float[numberOfStudents]; //it is necessary to create the array and the number of values inside it
       Scanner scanner = new Scanner(System.in); // it is necessary to create an object to allocate memory to the class, in this case it will read the data being written
       
        System.out.println("Input assignment name");
        //String name = scanner.nextLine(); //reads the name inputed and assign the value to "name" in string
        
        //block and warn about wrong inpputs in name
        String name = ""; //assign the valune name in string
        while (true) {
            name = scanner.nextLine();
            if (!name.matches("[a-zA-Z ]+")) { //check if the input has only uppercase and lowercase letters
            System.out.println("Invalid name, please enter a name containing only letters");
            } else {
                System.out.println("Valid name: "+ name); //address the valid name
                break;
            }
        }
        System.out.println("Input 30 student marks");
        
        for(int i=0; i< numberOfStudents; i++) {
            try{ //try and catch to detect problems according to the specification needed
            float mark = scanner.nextFloat(); //reads the data introduced
            
            if (mark < 0 || mark > 30){
                System.out.println("Invalid marks, 0 < mark < 30, please enter again");
                i--; //decrease 1 to go back to the same mark and allow to enter again the mark
            } else {
                marks[i] = mark; //store the marks that is correct
            }
        } catch (InputMismatchException e) { //catch shows the specification, in this case, not being an numeric value
            //InputMismatchException returns an error when it detects an input of a different type than expected
            System.out.println("Invalid input, please enter a numeric input"); 
            scanner.next(); //get over with the invalid input
            i--;
        }
        }
        
        //creating the variables to compare
        float largest = marks[0];
        float smallest = marks[0];
        // interate to compare all the marks 
        for (int i = 1; i < numberOfStudents; i++){
            if (marks[i] > largest){
                largest = marks[i];
            }
            if (marks[i] < smallest){
                smallest = marks[i];
            }
        }
        //output the assignment name and entered marks
        System.out.println("Assignment name: " + name);
        System.out.println("Entered marks: ");
        
        for (int j = 0; j < numberOfStudents; j++) {
            System.out.println(marks[j]);
        }
        
        //Output the largest and smallest marks
        System.out.println("Largest mark: " + largest);
        System.out.println("Smallest mark: " + smallest);
        
        //Calculate the mean of the marks
        //mean = sum of all marks / total number of marks
         float total = 0 ;
         
         for (int i=0; i<numberOfStudents; i++){
             total += marks[i];
        }
        //using double instead of float to allow more decimal numbers
        double mean = total / numberOfStudents;
    
        double variance = 0;
        
        for (int i=0; i < numberOfStudents; i++) {
            //substracting the mean from each score, square each deviation and adding the squared deviations
            variance += (marks[i] - mean)*(marks[i] - mean); 
        }
        //divide sum by he number of scores to find the variance
        variance = variance / numberOfStudents;
        
        //taking the square root of summedDiff to find the standard deviation considering that it is allowed to use methods and functions
        double standardDeviation = (double) Math.sqrt(variance);
        
        System.out.println(" Mean:" + mean);
        System.out.println(" Standard Deviation:" + standardDeviation);
        
        
        //do encapsulation in the largest and smallest
        //block strings inputs in marks
        //data validation
        //show marks index
    
    }
}
        
       
        


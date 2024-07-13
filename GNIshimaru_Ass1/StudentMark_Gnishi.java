import java.awt.Paint;

/**
 * Escreva uma descrição da classe StudentMark_Gnishi aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

import java.util.Scanner;

public class StudentMark_Gnishi
{
    
    public static void main(String[] args) {
        
       int numberOfStudents = 30;
       float[] marks = new float[numberOfStudents]; //it is necessary to create the array and the number of values inside it
       Scanner scanner = new Scanner(System.in); // it is necessary to create an object to allocate memory to the class, in this case it will read the data being written
       
        System.out.println("Input assignment name");
        
        String name = scanner.nextLine(); //reads the name inputed and assign the value to "name" in string
        
        System.out.println("Input 30 student marks");
        
        for(int i=0; i< numberOfStudents; i++) {
            float mark = scanner.nextFloat(); //reads the data introduced
            
            if (mark < 0 || mark > 30){
                System.out.println("Invalid marks, 0 < mark < 30, please enter again");
                i--; //decrease 1 to go back to the same mark and allow to enter again the mark
            } else {
                marks[i] = mark; //store the marks that is correct
            }
        }
        
        //starting the variables to compare
        float largest = marks[0];
        float smallest = marks [0];
        // interate to compare all the marks 
        for (int i = 1; 1 < numberOfStudents; i++){
            if (marks[i] > largest){
                largest = marks[i];
            }
            if (marks[i] < smallest){
                smallest = marks[i];
            }
        }
        
        System.out.println("Assignment name: " + name);
        System.out.println("Entered marks: ");
        System.out.println("Largest mark: " + largest);
        System.out.println("Smallest mark: " + smallest);
        for(int j=0; j<numberOfStudents; j++ ) {
            System.out.println(marks[j]);
        }
    
         //mean = sum of all marks / total number of marks
         float total = 0 ;
         
         for (int i=0; 1>numberOfStudents; 1++){
             total = total + mark[i];
        }
    
        float mean = total / numberOfStudents;
    
    
    
    
    
    }}
        
       
        


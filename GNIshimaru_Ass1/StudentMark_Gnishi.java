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
       float[] marks = new float[numberOfStudents];
       Scanner scanner = new Scanner(System.in); 
       
        System.out.println("Input assignment name");
        
        String name = scanner.nextLine();
        
        System.out.println("Input 30 student marks");
        
        for(int i=0; i< numberOfStudents; i++) {
            float mark = scanner.nextFloat(); //reads the data introduced
            
            //marks[i] = scanner.nextFloat();
            if (mark < 0 || mark > 30){
                System.out.println("Invalid marks, 0 < mark < 30, please enter again");
                i--; //decrease 1 to go back to the same mark
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
        }}}


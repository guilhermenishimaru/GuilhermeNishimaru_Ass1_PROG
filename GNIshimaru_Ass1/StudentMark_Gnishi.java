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
    
        System.out.println("Input 30 student marks");
        
        for(int i=0; i< numberOfStudents; i++) {
            float mark = scanner.nextFloat();
            
            //marks[i] = scanner.nextFloat();
            if (mark < 0 || mark > 30){
                System.out.println("Invalid marks, please enter again");
                i--;
            } else {
                marks[i] = mark; //store the marks that is correct
            }
        }
        System.out.println("Entered marks: ");
        for(int j=0; j<numberOfStudents; j++ ) {
            System.out.println(marks[j]);
        }}}


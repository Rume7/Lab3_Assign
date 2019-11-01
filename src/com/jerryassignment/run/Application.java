package com.jerryassignment.run;

import com.jerryassignment.model.ComplexNumber;
import java.util.Scanner;

/**
 *
 * @author Jerry Momodu
 */
public class Application {
    
    private static ComplexNumber accumulator = new ComplexNumber(0, 0);
    private static ComplexNumber result;
    
    public static void main(String[] args) {

        //accumulator = new ComplexNumber(2, -3);
        
        Scanner input = new Scanner(System.in);
        String console = input.nextLine();

        String[] splitted = console.split(" ");
        String operation = splitted[1];

        switch (operation) {
            case "add":
            case "+":
                result = accumulator.add(new ComplexNumber(splitted[2]));
                break;
            case "subtract":
            case "-":
                result = accumulator.subtract(new ComplexNumber(splitted[2]));
                break;
            case "multiply":
            case "*":
                accumulator.multiply(new ComplexNumber(splitted[2]));
                break;
            case "divide":
            case "/":
                result = accumulator.divide(new ComplexNumber(splitted[2]));
                break;
            case "mag":
                if (splitted.length == 2) {
                    double answer = accumulator.magnitude();
                    System.out.println(answer);
                } else if (splitted.length > 2) {
                    double answer = new ComplexNumber(splitted[splitted.length-1]).magnitude();
                    System.out.println(answer);
                }
                return ;
                //break;
            case "cnj":
                 if (splitted.length == 2) {
                    result = accumulator.conjugate();
                } else if (splitted.length > 2) {
                    result = new ComplexNumber(splitted[2]).conjugate();
                }
                break;
            case "ang":
                double answer = 0;
                if (splitted.length == 2) {
                    answer = accumulator.getAngle();
                } else if (splitted.length > 2) {
                    answer = new ComplexNumber(splitted[2]).getAngle();
                }
                System.out.println(answer);
                return ;
                //break;
            // Contain a Complex number
            case "A Complex number":
                break;
            case "end":
                break;
        }
        System.out.println(result.toString());
    }
}

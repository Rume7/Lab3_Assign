package com.jerryassignment.run;

import com.jerryassignment.model.ComplexNumber;
import java.util.Scanner;

/**
 *
 * @author Jerry Momodu
 */
public class Application {
    
    public static void main(String[] args) {

        ComplexNumber accumulator;                    // To store result on console

        accumulator = new ComplexNumber(0, 0);

        Scanner input = new Scanner(System.in);
        String console = input.nextLine();

        String[] splitted = console.split(" ");
        String operation = splitted[1];

        switch (operation) {
            case "add":
            case "+":
                break;
            case "subtract":
            case "-":
                break;
            case "multiply":
            case "*":
                break;
            case "divide":
            case "/":
                break;
            case "mag":
                if (splitted.length == 2) {
                    double answer = ComplexNumber.magnitude();
                    System.out.println(answer);
                } else if (splitted.length > 2) {
                    double answer = ComplexNumber.magnitude(splitted[2]);
                    System.out.println(answer);
                }

                break;
            case "cnj":
                break;
            case "ang":
                break;
            // Contain a Complex number
            case "A Complex number":
                break;
            case "end":
                break;
            default:
                break;
        }

        ComplexNumber complex1 = new ComplexNumber(2, -3);

        System.out.println(complex1);
        System.out.println(complex1.conjugate());
    }    
}

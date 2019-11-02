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

        Scanner input = new Scanner(System.in);
        String console = input.nextLine();

        String[] splitted = console.split(" ");
        String operation = splitted[1].trim();

        if (splitted.length <= 3) {
            ComplexNumber complex = new ComplexNumber(splitted[2].trim());
            switch (operation) {
                case "add":
                case "+":
                    result = accumulator.add(complex);
                    break;
                case "subtract":
                case "-":
                    result = accumulator.subtract(complex);
                    break;
                case "multiply":
                case "*":
                    accumulator.multiply(complex);
                    break;
                case "divide":
                case "/":
                    result = accumulator.divide(complex);
                    break;
                case "mag":
                    if (splitted.length == 2) {
                        double answer = accumulator.magnitude();
                        System.out.println(answer);
                    } else if (splitted.length > 2) {
                        double answer = new ComplexNumber(splitted[splitted.length - 1].trim()).magnitude();
                        System.out.println(answer);
                    }
                    return;
                case "cnj":
                    if (splitted.length == 2) {
                        result = accumulator.conjugate();
                    } else if (splitted.length > 2) {
                        result = new ComplexNumber(splitted[2].trim()).conjugate();
                    }
                    break;
                case "ang":
                    double answer = 0;
                    if (splitted.length == 2) {
                        answer = accumulator.getAngle();
                    } else if (splitted.length > 2) {
                        answer = new ComplexNumber(splitted[2].trim()).getAngle();
                    }
                    System.out.println(answer);
                    return;
                case "end":
                    System.out.println("End test session.");
                    return;
            }
            System.out.println(result.toString());
        }
        
        if (splitted.length == 4) {
            ComplexNumber c1 = new ComplexNumber(splitted[1].trim());
            String operator = splitted[2];
            ComplexNumber c2 = new ComplexNumber(splitted[3].trim());
            
            switch(operator) {
                case "+":
                case "add":
                    result = c1.add(c2);
                    break;
                case "-":
                case "subtract":
                    result = c1.subtract(c2);
                    break;
                case "/":
                case "divide":
                    result = c1.divide(c2);
                    break;
                case "*":
                case "multiply":
                    result = c1.multiply(c2);
                    break;
            }
            System.out.println(result.toString());
        }        
    }
}

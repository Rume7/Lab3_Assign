package com.jerryassignment.model;

/**
 *
 * @author Jerry Momodu
 */
public class ComplexNumber {
    
    private final double realPart;
    private final double imaginaryPart;
    private static double angleOfNumber;                
    private static double magnitudeOfNumber;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
        angleOfNumber = Math.atan2(this.imaginaryPart, this.realPart);
        double sumOfSquares = Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2);
        magnitudeOfNumber = Math.sqrt(sumOfSquares);
    }

    /**
     * @return angle in radians 
     */
    public static double angle() {
        return angleOfNumber;
    }

    public static double magnitude() {
        return magnitudeOfNumber;
    }

    public static double magnitude(ComplexNumber complex) {
        double result = Math.sqrt(Math.pow(complex.realPart, 2) + Math.pow(complex.imaginaryPart, 2));
        return result;
    }

    /**
     *  Computes the magnitude of a complex number
     * @param stringComplex
     * @return a scalar quantity of magnitude
     */
    public static double magnitude(String stringComplex) {
        int index1 = stringComplex.indexOf("+");
        int index2 = stringComplex.indexOf("-");

        double num1 = 0, num2 = 0;
        if (index1 > 0 && index2 != -1) {
            num1 = Double.parseDouble(stringComplex.substring(0, index1).trim());
            num2 = Double.parseDouble(stringComplex.substring(index1 + 1).trim());
        } else if (index2 > 0 && index1 != -1) {
            num1 = Double.parseDouble(stringComplex.substring(0, index2).trim());
            num2 = Double.parseDouble(stringComplex.substring(index2 + 1).trim());
        }

        // Create a new complex number
        ComplexNumber complex = new ComplexNumber(num1, num2);
        double answer = ComplexNumber.magnitude(complex);
        return answer;
    }

    /**
     *  Computes the conjugate of the complex number object.
     * @return the conjugate in Complex number format 
     */
    public ComplexNumber conjugate() {
        return new ComplexNumber(this.realPart, (-1 * this.imaginaryPart));
    }

    /**
     *  Computes the conjugate of the complex number object passed as parameter.
     * @param complexNumber
     * @return the conjugate in Complex number format 
     */
    public ComplexNumber conjugate(ComplexNumber complexNumber) {
        return new ComplexNumber(this.realPart, (-1 * this.imaginaryPart));
    }

    /**
     * Sums up a passed complex number object with the complex number
     * @param otherComplex
     * @return the sum in Complex Number
     */
    public ComplexNumber add(ComplexNumber otherComplex) {
        double newRealPart = this.realPart + otherComplex.realPart;
        double newImaginary = this.imaginaryPart + otherComplex.imaginaryPart;
        return new ComplexNumber(newRealPart, newImaginary);
    }

    /**
     *  Subtracts a passed complex number object from the complex number
     * @param otherComplex
     * @return the answer in Complex Number
     */
    public ComplexNumber subtract(ComplexNumber otherComplex) {
        double newRealPart = this.realPart - otherComplex.realPart;
        double newImaginary = this.imaginaryPart - otherComplex.imaginaryPart;
        return new ComplexNumber(newRealPart, newImaginary);
    }
    
    /**
     *  Computes the multiplication of a passed complex number object with the complex number
     * @param otherComplexNumber
     * @return the answer in Complex Number
     */
    public ComplexNumber multiply(ComplexNumber otherComplexNumber) {
        double real1 = this.realPart * otherComplexNumber.realPart;
        double real2 = this.imaginaryPart * otherComplexNumber.imaginaryPart * -1;
        double totalReal = real1 + real2;
        double imaginary1 = this.realPart * otherComplexNumber.imaginaryPart;
        double imaginary2 = this.imaginaryPart * otherComplexNumber.realPart;
        double totalImaginary = imaginary1 + imaginary2;
        return new ComplexNumber(totalReal, totalImaginary);
    }

        /**
     *  Computes the multiplication of a complex number by multiplying it magnitude and adding its angles.
     * @param angle
     * @param magnitude
     * @return the answer in Complex Number
     */
    public ComplexNumber multiply(double angle, double magnitude) {
        double totalMag = ComplexNumber.magnitude() * magnitude;
        double totalAngle = ComplexNumber.angle() + angle;

        double realPart1 = totalMag * Math.sin(totalAngle);            // Endeavour to set angle in radians
        double imgPart1 = totalMag * Math.cos(totalAngle);          // Endeavour to set angle in radians

        ComplexNumber complexNum = new ComplexNumber(realPart1, imgPart1);
        return complexNum;
    }
    
    /**
     *  Computes the division of a  complex number by multiplying it magnitude and adding its angles.
     * @param angle,
     * @param magnitude
     * @return the answer in Complex Number
     */
    public ComplexNumber divide(double angle, double magnitude) {
        double totalMag = ComplexNumber.magnitude() / magnitude;
        double totalAngle = ComplexNumber.angle() - angle;

        double realPart1 = totalMag * Math.sin(totalAngle);             // Endeavour to set angle in radians
        double imgPart1 = totalMag * Math.cos(totalAngle);           // Endeavour to set angle in radians

        ComplexNumber complexNum = new ComplexNumber(realPart1, imgPart1);
        return complexNum;
    }

    /**
     *  Computes the division of a passed complex number object with the complex number
     * @param complexNumber
     * @return the answer in Complex Number
     */
    public ComplexNumber divide(ComplexNumber complexNumber) {
        double denominator = (this.realPart * complexNumber.realPart) - (this.imaginaryPart * complexNumber.imaginaryPart);
        ComplexNumber complexResult = this.multiply(complexNumber);
        double real2 = complexResult.realPart / denominator;
        double imag2 = complexResult.imaginaryPart / denominator;
        return new ComplexNumber(real2, imag2);
    }

    @Override
    public String toString() {
        if (this.imaginaryPart < 0) {
            return "(" + this.realPart + " - " + "j" + (this.imaginaryPart * -1) + ")";
        }
        return "(" + this.realPart + " + " + "j" + this.imaginaryPart + ")";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadesk_p0011;

/**
 *
 * @author tuans
 */
public class CalculatorLogic {
    //return sum of 2 number
    static double add(double number1, double number2){
        return number1+number2;
    }
    //return subtract of number 1 and number 2
    static double sub(double number1, double number2){
        return number1-number2;
    }
    //return multiply of 2 number
    static double mul(double number1, double number2){
        return number1*number2;
    }
    //return division of 2 number
    static double div(double number1, double number2){
        return number1/number2;
    }
    //return division square root of a number
    static double divSquareRoot(double number){
        return Math.sqrt(number);
    }
    //return inverse of a number
    static double inverse(double number){
        return 1/number;
    }
}

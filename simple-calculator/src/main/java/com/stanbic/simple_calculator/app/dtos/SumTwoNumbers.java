package com.stanbic.simple_calculator.app.dtos;

import java.util.ArrayList;

public class SumTwoNumbers {
    private Integer firstNumber;
    private Integer secondNumber;

    public SumTwoNumbers(Integer a, Integer b){
        this.firstNumber = a;
        this.secondNumber = b;
    }

    public Integer getFirstNumber(){
        return firstNumber;
    }

    public Integer getSecondNumber(){
        return secondNumber;
    }
}

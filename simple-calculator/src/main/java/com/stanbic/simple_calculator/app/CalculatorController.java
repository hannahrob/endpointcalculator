package com.stanbic.simple_calculator.app;

import com.stanbic.simple_calculator.app.dtos.FxCurrency;
import com.stanbic.simple_calculator.app.dtos.SumTwoNumbers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Currency;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @PostMapping("/sum-numbers")
    public String addTwoNumbers(@RequestBody SumTwoNumbers request) {
        int sum = request.getFirstNumber() + request.getSecondNumber();
        return ("The sum is: " + sum);
    }

    @PostMapping("/get-largest")
    public Integer biggestNumber(@RequestBody ArrayList<Integer> list) {
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    @GetMapping ("/factorial/{number}")
    public Integer factorial(@PathVariable Integer number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++){
            factorial *= i;
        }
        return factorial;
    }

    @PostMapping("/fx-currency")
    public String convertCurrency(@RequestBody FxCurrency fx) {
        switch (fx.getBaseCurrency()) {
            case "USD":
                if (fx.getFxCurrency().equals("NGN")) {
                    double nairaAmount = fx.getAmount() * 410.0;
                    return ("The amount in Naira is " + nairaAmount + " NGN");
                } else if (fx.getFxCurrency().equals("EUR")) {
                    double euroAmount = fx.getAmount() * 0.92;
                    return ("The amount in Naira is " + euroAmount + " EUR");
                } else if (fx.getFxCurrency().equals("ZAR")) {
                    double zarAmount = fx.getAmount() * 18.48;
                    return ("The amount in Naira is " + zarAmount + " ZAR");
                } else if (fx.getFxCurrency().equals("CAD")) {
                    double cadAmount = fx.getAmount() * 1.34;
                    return ("The amount in Naira is " + cadAmount + " CAD");
                } else if (fx.getFxCurrency().equals("JPY")) {
                    double jpyAmount = fx.getAmount() * 134.0;
                    return ("The amount in Naira is " + jpyAmount + " JPY");
                }

            case "NGN":
                if (fx.getFxCurrency().equals("USD")) {
                    double usdAmount = fx.getAmount() / 415.0;
                    return ("The amount in Naira is " + usdAmount + " USD");
                } else if (fx.getFxCurrency().equals("EUR")) {
                    double euroAmount = fx.getAmount() / 450.0;
                    return ("The amount in Naira is " + euroAmount + " EUR");
                } else if (fx.getFxCurrency().equals("ZAR")) {
                    double zarAmount = fx.getAmount() / 30.0;
                    return ("The amount in Naira is " + zarAmount + " ZAR");
                } else if (fx.getFxCurrency().equals("CAD")) {
                    double cadAmount = fx.getAmount() / 350.0;
                    return ("The amount in Naira is " + cadAmount + " CAD");
                } else if (fx.getFxCurrency().equals("JPY")) {
                    double jpyAmount = fx.getAmount() / 3.5;
                    return ("The amount in Naira is " + jpyAmount + " JPY");
                }
        }
        return "";
    }

    @PostMapping("/palindrome")
    public static boolean isPalindrome(@RequestBody String input){
        input = input.toLowerCase();
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev = rev + input.charAt(i);
        }
    }
    }



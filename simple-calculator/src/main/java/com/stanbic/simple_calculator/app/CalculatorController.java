package com.stanbic.simple_calculator.app;

import com.stanbic.simple_calculator.app.dtos.Characters;
import com.stanbic.simple_calculator.app.dtos.FxCurrency;
import com.stanbic.simple_calculator.app.dtos.SumTwoNumbers;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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

    @GetMapping("/factorial/{number}")
    public Integer factorial(@PathVariable Integer number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
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
    public static String isPalindrome(@RequestBody String input) {
        input = input.toLowerCase();
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev = rev + input.charAt(i);
        }
        boolean res = rev.equalsIgnoreCase(input);
        if (res) {
            return (input + " is a palindrome");
        } else {
            return (input + " is not a palindrome");
        }
    }

    @PostMapping("/true-palindrome")
    public static String truePalindrome(@RequestBody String input) {
        input = input.toLowerCase();
        String rev = "";
        String noSymbolInput = "";
        String validChars = "1234567890qwertyuiopasdfghjklzxcvbnm";

        for (int i = input.length() - 1; i >= 0; i--) {
            if (validChars.contains(String.valueOf(input.charAt(i)))) {
                rev += input.charAt(i);
            }
        }
        for (int i = 0; i >= input.length() - 1; i++) {
            if (validChars.contains(String.valueOf(input.charAt(i)))) {
                noSymbolInput += input.charAt(i);
            }
        }
        boolean same = rev.equalsIgnoreCase(noSymbolInput);
        if (same) {
            return (input + " is a palindrome");
        }
        return (input + " is not a palindrome");
    }

    @GetMapping("/divisors/{number}")
    public List<Integer> divisors(@PathVariable Integer number) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        return (divisors);
    }

        @PostMapping("/split-character")
    public List<String> character(@RequestBody Characters splitting){
            String [] ss = splitting.getLetter().split(splitting.getSplitCharacter());
            return Collections.singletonList((Arrays.toString(ss)));
        }

    @PostMapping("/cube")
    public List<Integer> findCube(@RequestBody ArrayList<Integer> integers) {
        List<Integer> cubes = new ArrayList<>();
        for (Integer numbers : integers) {
            cubes.add(numbers * numbers * numbers);
        }
        return cubes;
    }

    @PostMapping("/circumference")
    public List<Float> findCircumference(@RequestBody ArrayList<Float> circleRadiiInMetres) {
        List<Float> circumference = new ArrayList<>();
        final Float PI = 3.142F;
        for (Float numbers : circleRadiiInMetres) {
            circumference.add((Float)(2 * PI * numbers));
        }
        return circumference;
    }
}







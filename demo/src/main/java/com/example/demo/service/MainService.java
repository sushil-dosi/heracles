package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

@Service
public class MainService {

    public MainService() {

    }


    public String convert(String input) {
        if(input == null || input == "" || input.isEmpty()){
            return "Input cannot be empty";
        }
        try {
            BigDecimal number = new BigDecimal(input);
            number = number.setScale(2, RoundingMode.HALF_UP);

            System.out.println(number);

            String numberStr = number.toString();


            String[] negativeSplitStr = numberStr.split("-");  //check for negative number
            boolean inputNumberSign =  false;

            //if negativeSplitStr size greater than 1 then we have negative sign
            int splitPosition  = negativeSplitStr.length > 1 ? 1 : 0;

            inputNumberSign = true;
            String[] numbers = negativeSplitStr[splitPosition].split("\\.");
            String inputNumber  = numbers[0];
            String inputNumberDecimal = numbers[1];

            int count = inputNumber.length() / 3;  // number spacing logic
            int split = inputNumber.length() % 3;




        }
        catch (NumberFormatException e) {
            return e.getMessage();
        }



        return input;
    }

}

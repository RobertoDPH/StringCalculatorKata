package test.kata;

import java.sql.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers){
        if(numbers.isBlank()){
            return 0;
        }

        String[] lines = numbers.split("//.(\\R)");
        String[] arrayNumbers;
        if(lines.length == 2){
            String differentDelimiter = numbers.substring(2,3);
            arrayNumbers = lines[1].split("[" + differentDelimiter + "]");
        }
        else{
            arrayNumbers = numbers.split("[\n,]");
        }

        int result = 0;
        for (String number : arrayNumbers) {
            result += Integer.parseInt(number);
        }

        if(result != 0){
            return result;
        }

        return Integer.parseInt(numbers);
    }
}

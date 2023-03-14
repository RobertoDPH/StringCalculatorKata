package test.kata;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : arrayNumbers) {
            int integerNumber = -1;

            try{
                integerNumber = Integer.parseInt(number);
            }catch (NumberFormatException error){
                System.out.println(error);
                return -1;
            }

            if(integerNumber < 0){
                negativeNumbers.add(integerNumber);
            }else if(integerNumber <= 1000){
                result += integerNumber;
            }
        }

        if(!negativeNumbers.isEmpty()){
            throw new IllegalArgumentException("negatives not allowed: " + negativeNumbers);
        }

        if(result != 0){
            return result;
        }

        return Integer.parseInt(numbers);
    }
}

package test.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public String[] getNumbersWithDelimiter(String numberString,String delimiter){
        boolean checkDelimiter = numberString.startsWith("//");
        if(checkDelimiter){
            numberString = numberString.substring(numberString.indexOf("\n") + 1);
        }
        return numberString.split(delimiter);
    }

    public String getDelimiterFromString(String numbersWithDelimiter){
        boolean checkDelimiter = numbersWithDelimiter.startsWith("//");

        return checkDelimiter ? getCustomDelimiter(numbersWithDelimiter.substring(2,numbersWithDelimiter.indexOf("\n"))) : getDefaultDelimiter();
    }

    private String getDefaultDelimiter() {
        return "[\n,]";
    }

    private String getCustomDelimiter(String provisionalDelimiter){
        int indexSquareBracket = provisionalDelimiter.indexOf("[");

        return indexSquareBracket != -1 ? getDelimiterWithSquareBracket(provisionalDelimiter) : provisionalDelimiter;
    }

    private String getDelimiterWithSquareBracket(String delimiterWithBrackets) {
        boolean multipleBrackets = delimiterWithBrackets.contains("][");
        return multipleBrackets ? String.join("", delimiterWithBrackets.split("]\\[")) : Pattern.quote(delimiterWithBrackets.substring(1, delimiterWithBrackets.length() - 1));
    }

    private int convertStringToNumber(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException error) {
            throw new NumberFormatException("");
        }
    }

    public int add(String numbers){
        if(numbers.isBlank()){
            return 0;
        }

        String delimiter = getDelimiterFromString(numbers);
        String[] arrayNumbers = getNumbersWithDelimiter(numbers, delimiter);

        int result = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String stringNumber : arrayNumbers) {
            int integerNumber = convertStringToNumber(stringNumber);

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

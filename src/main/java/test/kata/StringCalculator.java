package test.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public List<Integer> getNumbersWithDelimiter(String numberString,String delimiter){
        boolean checkDelimiter = numberString.startsWith("//");
        if(checkDelimiter){
            numberString = numberString.substring(numberString.indexOf("\n") + 1);
        }
        return Arrays.stream(numberString.split(delimiter)).map(this::convertStringToNumber).toList();
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

    private List<Integer> findNegativeNumbers(List<Integer> numbersList){
        List<Integer> negativeNumbersList = new ArrayList<>();
        for (int number: numbersList) {
            if (number < 0){
                negativeNumbersList.add(number);
            }
        };
        return negativeNumbersList;
    }

    private int sumNumbersLowerThan1000(List<Integer> numbersList){
        int result = 0;
        for (int number : numbersList) {
            if(number <= 1000){
                result += number;
            }
        }

        return result;
    }

    public int add(String numbers){
        if(numbers.isBlank()){
            return 0;
        }

        String delimiter = getDelimiterFromString(numbers);
        List<Integer> arrayNumbers = getNumbersWithDelimiter(numbers, delimiter);
        List<Integer> negativeNumbersList = findNegativeNumbers(arrayNumbers);
        if(negativeNumbersList.size() > 0){throw new IllegalArgumentException("negatives not allowed: " + negativeNumbersList);}

        int result = sumNumbersLowerThan1000(arrayNumbers);
        if(result != 0){
            return result;
        }

        return Integer.parseInt(numbers);
    }
}

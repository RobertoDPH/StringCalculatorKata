package test.kata;

public class StringCalculator {
    public int add(String numbers){
        if(numbers.isBlank()){
            return 0;
        }

        String[] arrayNumbers = numbers.split("[\n,]");
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

package test.kata;

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
            int integerNumber = -1;

            try{
                integerNumber = Integer.parseInt(number);
            }catch (NumberFormatException error){
                System.out.println(error);
                return -1;
            }

            if(integerNumber > 0 && integerNumber <= 1000){
                result += integerNumber;
            }
        }

        if(result != 0){
            return result;
        }

        return Integer.parseInt(numbers);
    }
}

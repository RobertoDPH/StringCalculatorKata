package test.kata;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {
    @Test
    public void be0IfNumbersAreEmpty(){
        int result = new StringCalculator().add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void beSameNumberIfLengthIs1(){
        int result = new StringCalculator().add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void allowHandleUnknownAmountOfNumbers(){
        int result = new StringCalculator().add("5,5,4,3,1,2,5");
        assertThat(result).isEqualTo(25);
    }

    @Test
    public void allowHandleNewLinesBetweenNumbers(){
        int result = new StringCalculator().add("5\n5,4\n3,1,2,5");
        assertThat(result).isEqualTo(25);
    }
}

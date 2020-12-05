import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] numbers = { 1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4 };
        List<Integer> numbersList = Arrays.asList(numbers);

        List<Integer> positiveNumbersList = new ArrayList<>();
        for (Integer number : numbersList) {
            if (number > 0) positiveNumbersList.add(number);
        }

        List<Integer> positiveEvenNumbersList = new ArrayList<>();
        for (Integer number : positiveNumbersList) {
            if (number % 2 == 0) positiveEvenNumbersList.add(number);
        }

        Collections.sort(positiveEvenNumbersList);
        for (Integer number : positiveEvenNumbersList) {
            System.out.println(number);
        }

    }

}

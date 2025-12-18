package Excercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> reversedList = new ArrayList<>();

        ListIterator<Integer> iterator = numbers.listIterator(numbers.size());

        while (iterator.hasPrevious()) {
            reversedList.add(iterator.previous());
        }

        System.out.println(reversedList);
        System.out.println(numbers);

    }
}

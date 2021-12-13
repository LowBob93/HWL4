import FunctionalInterfaces.MaxNumberFromList;
import FunctionalInterfaces.SearchListOfStrings;
import FunctionalInterfaces.StringReverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MainClass {

    public static void main(String[] args) {

        Integer[] intArray = {1, 3, 6, 3, 2, 0, 4, 7, 4, 4, 6, 6, 49};
        List<Integer> integerList = Arrays.asList(intArray);
        System.out.println("Задание 1");
        checkValid(search(6, integerList, (a, b) -> b.indexOf(a)));
        checkValid(search(22, integerList, (a, b) -> b.indexOf(a)));
        System.out.println("___________________________________________________");

        List<String> stringsList = new ArrayList<>();
        stringsList.add("абу");
        stringsList.add("Али");
        stringsList.add("акс");
        stringsList.add("Актер");
        stringsList.add("крот");

        System.out.println("Задание 2 ");
        System.out.println(reverse("!ропу в юялертс рвод и уважд аЗ", str -> new StringBuilder(str).reverse().toString()));
        System.out.println("___________________________________________________");

        System.out.println("Задание 3 ");
        System.out.println("Максимальное число в списке равно = " + maximum(integerList, Collections::max));
        System.out.println("___________________________________________________");

        System.out.println("Задание 4 ");
        System.out.println("Среднее значение всех чисел в массиве равно = " + average(integerList, list -> {
            if (list.size() == 0) {
                return 0.0;
            }
            Integer sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            return sum / (list.size() * 1.0);
        }));
        System.out.println("___________________________________________________");
        System.out.println("Задание 5");
        System.out.println("Слова подходящие под критерий \"Начинаются с буквы «а» (нижний регистр) и имеют ровно 3 буквы.\" : ");
        System.out.println(search(stringsList, str -> {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < str.size(); i++) {
                if ((str.get(i).length() == 3) && (str.get(i).charAt(0) == 'а')) {
                    result.add(str.get(i));
                }
            }
            return result;
        }));

    }


    public static int search(Integer n, List<Integer> list, BiFunction<Integer, List<Integer>, Integer> biFunction) {
        return biFunction.apply(n, list);
    }


    public static String reverse(String s, StringReverse strReverse) {
        return strReverse.reverse(s);
    }


    public static Integer maximum(List<Integer> list, MaxNumberFromList retMaxNumber) {
        return retMaxNumber.maxNumber(list);
    }


    public static Double average(List<Integer> list, Function<List<Integer>, Double> function) {
        return function.apply(list);
    }


    public static List<String> search(List<String> list, SearchListOfStrings searchList) {
        return searchList.searchListOfStrings(list);
    }

    public static void checkValid(int initialValue) {

        if (initialValue == -1) {
            System.out.println("Введенное число не существует");
        } else {
            System.out.println(initialValue);
        }
    }
}

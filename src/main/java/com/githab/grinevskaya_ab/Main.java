package com.githab.grinevskaya_ab;

//import java.awt.desktop.SystemSleepEvent;
//import java.util.concurrent.atomic.AtomicInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //task1
        System.out.println(equalsAmountXAndO("ooxx"));
        System.out.println(equalsAmountXAndO("xooxx"));
        System.out.println(equalsAmountXAndO("ooxXm"));
        System.out.println(equalsAmountXAndO("zpzpzpp"));
        System.out.println(equalsAmountXAndO("zzoo"));
        System.out.println();

        //task 2
        System.out.println(powEveryDigit(9119));
        System.out.println(powEveryDigit(7650));
        System.out.println(powEveryDigit(0));
        System.out.println(powEveryDigit(-7650));
        System.out.println();


        //task3
        System.out.println(getCapitalizeString("How can mirrors be real if our eyes aren't real"));
        System.out.println(getCapitalizeString(null));
        System.out.println(getCapitalizeString(""));
        System.out.println();

        //task4
        System.out.println("abcdefklmopqwxy".equals(longest("xyaabbbccccdefww", "xxxxyyyabklmopq")));
        System.out.println(longest("", ""));
        System.out.println(longest(null, null));
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", null));
        System.out.println(longest(null, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println("abcdefghijklmnopqrstuvwxyz".equals(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")));
        System.out.println();

        //task 5
        System.out.println(getSortedList(new ArrayList<>(Arrays.asList(1, 3, 5, 6, 7, 8))));
        System.out.println(getSortedList(new ArrayList<>(Arrays.asList(-1, -3, -5, -6, -7, -8))));
        System.out.println(getSortedList(new ArrayList<>(Arrays.asList(6, 7, 9, 11, 15, 16))));
        System.out.println(getSortedList(new ArrayList<>()));
    }

    /* Проверьте, содержит ли строка одинаковое количество символов «x» и «o».
     Метод должен возвращать логическое значение и быть нечувствительным к регистру. Строка может содержать любой символ.

    Примеры ввода/вывода:
     XO("ooxx") => верно
     XO("xooxx") => ложь
     XO("ooxXm") => верно
     XO("zpzpzpp") => true // если нет 'x' и 'o', должно возвращаться true
     XO("zzoo") => ложь */

    public static boolean equalsAmountXAndO(String string) {
        //в лоб
        String upperString = string.toUpperCase();
        int countX = (int) upperString.chars()
                .filter(ch -> ch == 'X')
                .count();
        int countO = (int) upperString.chars()
                .filter(ch -> ch == 'O')
                .count();

        return countO == countX;
    }


   /* Возвест в квадрат каждую цифру числа и соединить их.
      Функция принимает целое число и возвращает целое число

    Примеры ввода/вывода:
      (9119) => 811181 (81-1-1-81)
      (7650) => 493625 (49-36-25)
   */

    public static Integer powEveryDigit(Integer number) {
        if (number == 0) return 0;

        boolean need_minus = false;
        if (number < 0) {
            number *= -1;
            need_minus = true;
        }

        String resultString = Integer.toString(number).chars()
                .filter(ch -> ch != '0')
                .mapToObj(i -> String.valueOf(getPowDigitInt((char) i)))
                .collect(Collectors.joining());

        return (need_minus) ? -1 * Integer.parseInt(resultString) : Integer.parseInt(resultString);
    }

    public static int getPowDigitInt(char ch) {
        return (int) Math.pow(Integer.parseInt(ch + ""), 2);
    }

    /*Джейден Смит, сын Уилла Смита, является звездой таких фильмов, как «Парень-каратист» (2010) и «После Земли» (2013).
     Джейден также известен своей философией, которую он распространяет через Твиттер.
     Когда он пишет в Твиттере, он известен тем, что почти всегда пишет каждое слово с заглавной буквы. Для простоты вам придется писать каждое слово с заглавной буквы.
      Посмотрите, какими будут сокращения в примере ниже.

    Ваша задача — преобразовать строки так, как их написал Джейден Смит.
    Строки представляют собой настоящие цитаты Джейдена Смита, но они не пишутся с заглавной буквы так, как он их первоначально напечатал.

    Пример:

    Не Джейден-Кейс: How can mirrors be real if our eyes aren't real"
    Джейден-Кейс: How Can Mirrors Be Real If Our Eyes Aren't Real"
    Обратите внимание, что версия Java ожидает возвращаемого значения null для пустой строки или null.*/

    public static String getCapitalizeString(String string) {
        if (string == null || string.isEmpty()) return null;
        return Arrays.stream(string.split(" "))
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .collect(Collectors.joining(" "));

    }

    /*возьмем две строки s1 и s2, содержащие только буквы от a до z.
    Возвращает новую отсортированную строку, максимально длинную, содержащую отдельные буквы (каждая из которых берется только один раз), исходящие из s1 или s2.

    Примеры:
       а = "xyaabbbccccdefww"
       б = "xxxxyyyabklmopq"
       longest((a, b) -> "abcdefklmopqwxy"

       a = "abcdefghijklmnopqrstuvwxyz"
       longest((a, a) -> "abcdefghijklmnopqrstuvwxyz"*/

    public static String longest(String firstString, String secondString) {
        if (firstString == null && secondString == null) return null;
        String allString;

        if (firstString == null) allString = secondString;
        else if (secondString == null) allString = firstString;
        else allString = firstString + secondString;

        return allString.chars()
                .sorted()
                .distinct()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

    /* Похоже, какой-то сантехник-хулиган и его брат снова бегают и портят ваши сцены.
    Трубы, соединяющие этапы вашего уровня, необходимо починить, прежде чем вы получите новые жалобы.
    Трубы правильные, если каждая трубка после первой на 1 больше предыдущей.

    Учитывая список уникальных чисел, отсортированных в порядке возрастания, верните новый список так,
    чтобы значения увеличивались на 1 для каждого индекса от минимального значения до максимального значения (оба включены).

    Пример
    Вход: 1,3,5,6,7,8 Выход: 1,2,3,4,5,6,7,8
    */

    public static List<Integer> getSortedList(List<Integer> list) {
        if (list.isEmpty()) return null;
        Integer minNumber = list.stream().min(Comparator.naturalOrder()).get();
        Integer maxNumber = list.stream().max(Comparator.naturalOrder()).get();

        return IntStream.range(minNumber, maxNumber + 1)
                .boxed()
                .collect(Collectors.toList());
    }
}
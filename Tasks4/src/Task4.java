import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Task1");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println("Task2");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println("Task3");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println("Task4");
        System.out.println(alphabeticRow("abсzyx"));
        System.out.println(alphabeticRow("aaaa"));
        System.out.println("Task5");
        System.out.println(countChars("aaabbcdd"));
        System.out.println(countChars("vvvvaajaaaaa"));
        System.out.println("Task6");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println("Task7");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println("Task8");
        System.out.println(shortestWay(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
        System.out.println(shortestWay(new int[][]{
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}}));
        System.out.println("Task9");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder(("re6sponsibility Wit1h gr5eat power3 4comes g2reat")));
        System.out.println("Task10");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));

    }
    //1.	Напишите рекурсивную функцию, которая принимает строку и удаляет из неё повторяющиеся символы.
    // Функция должна вернуть строку, в которой каждый символ встречается только один раз.
    public static String nonRepeatable(String s) {
        if (s.isEmpty()) return s;
        return s.charAt(0) + nonRepeatable(s.replaceAll(String.valueOf(s.charAt(0)), ""));
    }
    //2.	Напишите функцию, которая генерирует все возможные правильные комбинации пар скобок для заданного числа n.
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        generateBracketsHelper(n, n, "", result);
        return result;
    }

    private static void generateBracketsHelper(int open, int close, String current, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        if (open > 0) {
            generateBracketsHelper(open - 1, close, current + "(", result);
        }
        if (close > open) {
            generateBracketsHelper(open, close - 1, current + ")", result);
        }
    }

    //3.	Напишите функцию, которая генерирует все возможные бинарные комбинации длины n, в которых не может быть соседствующих нулей.
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        current.add("0");
        current.add("1");

        for (int i = 1; i < n; i++) {
            List<String> next = new ArrayList<>();
            for (String s : current) {
                if (s.endsWith("0")) next.add(s + "1");
                if (s.endsWith("1")) {
                    next.add(s + "0");
                    next.add(s + "1");
                }
            }
            current = next;
        }

        for (String s : current) {
            if (s.length() == n) result.add(s);
        }

        return result;
    }
    //4.	Реализуйте функцию, которая принимает строку и возвращает длину самого длинного последовательного ряда в этом массиве.
    // Последовательный ряд – это список соседних элементов, идущих подряд в алфавитном порядке, который может быть как увеличивающимся,
    // так и уменьшающимся.
    public static String alphabeticRow(String str) {
        String maxRow = "";//последовательность
        int maxLen = 0;//длина

        for (int i = 0; i < str.length(); i++) {//в прямом
            StringBuilder current01 = new StringBuilder();
            current01.append(str.charAt(i));
            while (i < str.length() - 1 && str.charAt(i) + 1 == str.charAt(i + 1)) {//в алфавитном
                current01.append(str.charAt(i + 1));
                i++;
            }
            if (current01.length() > maxLen) {//обновление
                maxLen = current01.length();
                maxRow = current01.toString();
            }
        }

        for (int i = 0; i < str.length(); i++) {//в обратном
            StringBuilder current10 = new StringBuilder();
            current10.append(str.charAt(i));
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1) + 1) {//в обратном
                current10.append(str.charAt(i + 1));
                i++;
            }
            if (current10.length() > maxLen) {//обновление
                maxLen = current10.length();
                maxRow = current10.toString();
            }
        }
        return maxRow;
    }
    //5.	Напишите функцию, которая принимает строку и подсчитывает количество идущих подряд символов,
    // заменяя соответствующим числом повторяющиеся символы. Отсортируйте строку по возрастанию длины буквенного паттерна.
    public static String countChars(String str) {
        StringBuilder comp = new StringBuilder();//сжатая строка
        int count = 1;//колво повторений

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                comp.append(str.charAt(i - 1));
                comp.append(count);
                count = 1;
            }
        }
        comp.append(str.charAt(str.length() - 1));
        comp.append(count);//последний символ

        List<String> blocks = new ArrayList<>();//блоки буква+цифра
        Matcher matcher = Pattern.compile("[a-zA-Z]\\d+").matcher(comp.toString());
        while (matcher.find()) {
            blocks.add(matcher.group());//добавление регулятого выраж
        }

        blocks.sort((o1, o2) -> {// Сортировка с лямбдой
            int num1 = Integer.parseInt(o1.substring(1));//o1-строка1 о2- строка 2
            int num2 = Integer.parseInt(o2.substring(1));//
            return Integer.compare(num1, num2);//-if num2>.. +if num1>
        });

        StringBuilder result = new StringBuilder();
        for (String block : blocks) {
            result.append(block);
        }

        return result.toString();
    }

    //6.	Напишите функцию, принимающую положительное целое число в строковом формате,
    // не превышающее 1000, и возвращающую его целочисленное представление.
    public static int convertToNum(String str) {

        Map<String, Integer> numDict = new HashMap<>();//словарь чисел

        numDict.put("zero", 0);
        numDict.put("one", 1);
        numDict.put("two", 2);
        numDict.put("three", 3);
        numDict.put("four", 4);
        numDict.put("five", 5);
        numDict.put("six", 6);
        numDict.put("seven", 7);
        numDict.put("eight", 8);
        numDict.put("nine", 9);
        numDict.put("ten", 10);
        numDict.put("eleven", 11);
        numDict.put("twelve", 12);
        numDict.put("thirteen", 13);
        numDict.put("fourteen", 14);
        numDict.put("fifteen", 15);
        numDict.put("sixteen", 16);
        numDict.put("seventeen", 17);
        numDict.put("eighteen", 18);
        numDict.put("nineteen", 19);
        numDict.put("twenty", 20);
        numDict.put("thirty", 30);
        numDict.put("forty", 40);
        numDict.put("fifty", 50);
        numDict.put("sixty", 60);
        numDict.put("seventy", 70);
        numDict.put("eighty", 80);
        numDict.put("ninety", 90);
        numDict.put("hundred", 100);
        numDict.put("thousand", 1000);

        String[] words = str.split(" ");//строку на слова
        int result = 0;

        for (String word : words) {
            if (numDict.containsKey(word)) {
                if (word.contains("hundred")) {
                    result = result * 100;
                } else if (word.contains("thousand")){
                    result = result * 1000;
                } else {
                    result = result + numDict.get(word);
                }
            }
        }
        return result;
    }
    //7.	Напишите функцию, принимающую строку цифр, выполняющую поиск подстроки максимальной длины с уникальными элементами.
    // Если найдено несколько подстрок одинаковой длины, верните первую.
    public static String uniqueSubstring(String str) {
        Set<Character> unique = new HashSet<>();
        String max = "";
        String current = "";

        for (char c : str.toCharArray()) { //123789
            if (unique.contains(c)) {//если симв уже есть удаляем все до его первого появления
                int startIndex = current.indexOf(c);
                current = current.substring(startIndex + 1);
            }
            unique.add(c);
            current += c;
            if (current.length() > max.length()) {
                max = current;
            }
        }
        return max;
    }
    //8.	Напишите функцию поисковик наименьшего матричного пути. На вход поступает двумерный массив, размера n x n,
    // ваша задача найти путь с минимальной суммой чисел, передвигаясь только вправо или вниз.
    public static int shortestWay(int[][] arr) {
        int m = arr.length;//строки
        int n = arr[0].length;//столбцы
        int[][] x = new int[m][n];//новый масс, хран.пути

        x[0][0] = arr[0][0];//первые ячейки совпадают

        for (int i = 1; i < m; i++) {// строки(суммы если бы двигались)
            x[i][0] = x[i - 1][0] + arr[i][0];
        }
        for (int j = 1; j < n; j++) {// столбца
            x[0][j] = x[0][j - 1] + arr[0][j];
        }
        for (int i = 1; i < m; i++) {// стр
            for (int j = 1; j < n; j++) {//столб
                x[i][j] = Math.min(x[i - 1][j], x[i][j - 1]) + arr[i][j];
            }
        }
        return x[m - 1][n - 1];//- тк с 0
    }
    //9.	Создайте функцию, принимающую строку, содержащую числа внутри слов.
    // Эти числа представляют расположение слова для новой строящейся строки.

    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        Map<Integer, String> wordMap = new HashMap<>();

        for (String word : words) {
            int order = Integer.parseInt(word.replaceAll("[^0-9]", ""));
            wordMap.put(order, word);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= words.length; i++) {
            result.append(wordMap.get(i));
            result.append(" ");
        }

        String finalResult = result.toString().trim().replaceAll("\\d", "");
        return finalResult; // удаление лишних пробелов
    }
    //10.	Напишите функцию, принимающую два числа, которая делает второе число максимально возможным
    // за счет замены своих элементов элементами первого числа. Брать цифру можно только один раз.
    public static int switchNums(int num1, int num2) {
        char[] num1Digits = Integer.toString(num1).toCharArray();
        char[] num2Digits = Integer.toString(num2).toCharArray();

        Arrays.sort(num1Digits);

        for (int j = 0; j < num2Digits.length; j++){
            for (int i = num1Digits.length - 1; i >= 0; i--) {
                if (num1Digits[i] > num2Digits[j]) {
                    num2Digits[j] = num1Digits[i];
                    num1Digits[i] = 0;
                }
            }
        }
        return Integer.parseInt(new String(num2Digits));
    }
}


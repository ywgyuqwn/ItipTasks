import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        System.out.println("Task1");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println("Task2");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("Task3");
        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));
        System.out.println("Task4");
        System.out.println(equalToAvg(new float[]{1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new float[]{1, 2, 3, 4, 6}));
        System.out.println("Task5");
        System.out.println(Arrays.toString(indexMult(new int[]{1,2,3})));
        System.out.println(Arrays.toString(indexMult(new int[]{-3,3,-2,408,3,31})));
        System.out.println("Task6");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println("Task7");
        System.out.println(Tribonacci(6));
        System.out.println(Tribonacci(10));
        System.out.println("Task8");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println("Task9");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("Task10");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));


    }

    //3.	Создайте функцию, которая принимает массив и возвращает разницу между суммой четных и нечетных.
    public static int differenceEvenOdd(int[] nums) {
        int sumEven = 0;//четные
        int sumOdd = 0;//нечетные
        for (int num : nums) {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
        }
        return Math.abs(sumEven - sumOdd);
    }
//6.	Создайте метод, который принимает строку в качестве аргумента и возвращает ее в обратном порядке.
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

//4.	Создайте функцию, которая принимает массив и возвращает true, если в массиве есть хотя бы один элемент,
// который равен среднему арифметическому всех элементов массива, и false в противном случае.
    public static boolean equalToAvg(float[] nums) {
        float sum = 0;
        for (float num : nums) {
            sum += num;
        }
        float average = sum / nums.length;
        for (float num : nums) {
            if (num == average) {
                return true;
            }
        }
        return false;
    }
//5.	Создайте метод, который берет массив целых чисел и возвращает массив,
// в котором каждое целое число умножено на индекс этого числа в массиве.
    public static int[] indexMult(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * i;
        }
        return result;
    }
//7.	Создайте функцию, которая при заданном числе возвращает соответствующее число Трибоначчи.
// Последовательность Трибоначчи начинается с элементов «0, 0, 1».
    public static int Tribonacci(int n) {
        if (n == 0|n==1){
            return 0;
        }
        else if (n == 2){
            return 1;
        }
        else {
            int[] tribonacci = new int[n+1];
            tribonacci[0] = 0;
            tribonacci[1] = 0;
            tribonacci[2] = 1;
            for (int i = 3; i <= n; i++) {
                tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
            }
            return tribonacci[n];
        }
    }
//8.	Хэш-суммы в системе контроля версий (например, Git) выглядят как уникальная строка
// из символов (от a до f) и цифр (от 0 до 9) длиной в 40 элементов. В Git используется SHA-1 хэш-функция для создания хэшей коммитов.
//Создайте функцию, генерирующую квази-хэш заданной пользователем длины.
    public static String pseudoHash(int length) {
        String characters = "0123456789abcdef";
        char[] pseudoHash = new char[length];
        for (int i = 0; i < length; i++) {
            int randomIndex =(int) (Math.random()*(characters.length()));
            char randomChar = characters.charAt(randomIndex);
            pseudoHash[i] = randomChar;
        }
        return new String(pseudoHash);
    }

//9.	Напишите функцию, которая находит слово "help" в данной строке-стенограмме автоматизированного телефонного диспетчера службы спасения.
// Ответьте "Вызов сотрудника", если слово найдено, в противном случае – "Продолжайте ожидание".
    public static String botHelper(String stenogram) {
        String[] words = stenogram.split(" ");
        for (String word : words) {
            if (word.equalsIgnoreCase("help")) {
                return "Вызов сотрудника";
            }
        }
        return "Продолжайте ожидание";
    }
//10.	Создайте функцию, которая принимает две строки и определяет, являются ли они анаграммами.
    public static boolean isAnagram(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
//1.	Создайте функцию, которая определяет, есть ли в строке повторяющиеся символы.
    public static boolean duplicateChars(String str) {
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (!set.add(c)) {
                return true;
            }
        }
        return false;
    }
    //2.	Создайте метод, который принимает строку (фамилию и имя человека) и возвращает строку с инициалами без пробелов.
    public static String getInitials(String fullName) {
        String[] names = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String name : names) {
            initials.append(name.charAt(0));
        }
        return initials.toString();
    }
}


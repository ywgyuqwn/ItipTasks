import java.util.Arrays;

public class tasks3 {

    public static void main(String[] args) {
        System.out.println("task1");
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code"));
        System.out.println("task2");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("task3");
        System.out.println(doesBlockFit(1, 2, 3, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println("task4");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("task5");
        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));
        System.out.println("task6");
        System.out.println(Arrays.toString(salesData(new String[][]{
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}})));
        System.out.println(Arrays.toString(salesData(new String[][]{
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}})));
        System.out.println("task7");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("task8");
        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));
        System.out.println("task9");
        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words"));
        System.out.println("task10");
        System.out.println(Arrays.deepToString(dataScience(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}})).replace("], [", "],\n ["));
    }

    //1.	Создайте функцию, которая принимает строку и заменяет все гласные буквы на символ «*».
    public static String replaceVowels(String input) {
        return input.replaceAll("[aeiouAEIOU]", "*");
    }

    //2.	Напишите функцию, которая принимает строку и заменяет две идущие подряд буквы по шаблону «Double*».
    public static String stringTransform(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                result.append("Double");
            } else {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }

    //3.	Помогите ребенку разобраться с игрушкой на развитие - поместится ли параллелепипед в коробку с отверстиями
//      определенных параметров. Напишите функцию, которая принимает три измерения игрушечного блока: высоту(a), ширину(b)
//      и глубину(c) и возвращает true, если этот блок может поместиться в отверстие с шириной(w) и высотой(h).
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        // Проверяем каждую сторону блока по отношению к отверстию
        if ((a <= w && b <= h) || (a <= h && b <= w)) {
            return true;
        }
        if ((b <= w && c <= h) || (b <= h && c <= w)) {
            return true;
        }
        if ((c <= w && a <= h) || (c <= h && a <= w)) {
            return true;
        }
        return false;
    }

    //4.	Создайте функцию, которая принимает число в качестве входных данных и возвращает true,
    //     если сумма квадратов его цифр имеет ту же четность, что и само число. В противном случае верните false.
    public static boolean numCheck(int number) {
        int sumOfSquares = 0;
        int tempNumber = number;

        while (tempNumber != 0) {
            int digit = tempNumber % 10;
            sumOfSquares += Math.pow(digit, 2);
            tempNumber /= 10;
        }

        return (number % 2 == sumOfSquares % 2);
    }

    //5.	Создайте метод, который берет массив целых чисел-коэффициентов и возвращает количество целочисленных корней
//      квадратного уравнения.
    public static int countRoots(int[] coefficients) {
        int a = coefficients[0];
        int b = coefficients[1];
        int c = coefficients[2];

        int discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return 0; // Нет целочисленных корней
        } else if (discriminant == 0) {
            return 1; // Один целочисленный корень
        } else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double x1 = (-b + sqrtDiscriminant) / (2 * a);
            double x2 = (-b - sqrtDiscriminant) / (2 * a);

            if (x1%1==0 && x2%1==0) {
                return 2; // Два целочисленных корня
            } else {
                return 1; // Только один целочисленный корень
            }
        }
    }

    //6.	Создайте метод, который принимает двумерный массив, представляющий информацию о продажах разных товаров
//      в различных магазинах, и возвращает товары, которые были проданы в каждом из магазинов.
    public static String[] salesData(String[][] data) {
        int maxLen = 0;
        for (String[] row : data) {
            if (row.length > maxLen) {
                maxLen = row.length;
            }
        }
        int count = 0;
        String[] result = new String[data.length];
        for (String[] row : data) {
            if (row.length == maxLen) {
                result[count] = row[0];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }
    //7.	Создайте функцию, которая определяет, можно ли разбить заданное предложение на слова так, чтобы каждое слово
//     начиналось с последней буквы предыдущего слова.
    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");
        if (words.length < 2) {
            return false;
        }

        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currWord = words[i];
            if (prevWord.charAt(prevWord.length() - 1) != currWord.charAt(0)) {
                return false;
            }
        }

        return true;
    }
    //8.	Напишите метод, который определяет, является ли заданный массив «волнообразным». Последовательность чисел
//      считается волнообразной, если разница между соседними элементами чередуется между убыванием и возрастанием.
    public static boolean waveForm(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
            boolean increasing = arr[1] > arr[0];

            for (int i = 2; i < arr.length; i++) {
                if (increasing) {
                    if (arr[i] >= arr[i - 1]) {
                        return false;
                    }
                } else {
                    if (arr[i] <= arr[i - 1]) {
                        return false;
                    }
                }
                increasing = !increasing;
            }
            return true;
        }
    //9.	Напишите функцию, которая находит наиболее часто встречающуюся гласную в предложении.
    public static char commonVowel(String sentence) {
        String vowels = "aeiouAEIOU"; // гласные буквы на английском языке.
        int[] counts = new int[200];

        for (char c : sentence.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                counts[vowels.indexOf(c)]++;
            }
        }
        int maxCount = counts[0];
        int maxIndex = 0;

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
            }
        }

        return vowels.charAt(maxIndex);
    }
    //10.	Создайте функцию, которая принимает n целочисленных массивов длины n,
//      а затем изменяет каждый n-ый элемент n-го массива на среднее арифметическое элементов n-го столбца остальных массивов.
    public static int[][] dataScience(int[][] arrays) {
        int n = arrays.length;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    total += arrays[k][i];
                }
            }
            arrays[i][i] = total / (n-1);
        }
        return arrays;
    }
}
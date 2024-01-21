public class Add {
    public static void main(String[] args) {
    System.out.println(pseudoHash(5));}
    public static String pseudoHash(int length) {
        StringBuilder pseudoHash = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * 16);
            System.out.println(random);
            System.out.println("----");
            char c = (random < 10) ? (char) (random + '0') : (char) (random - 10 + 'a');
            System.out.println(random);
            pseudoHash.append(c);
        }
        return pseudoHash.toString();
    }
}

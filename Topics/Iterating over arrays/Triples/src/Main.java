import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int triples = 3;
        int size = scanner.nextInt() - triples;
        
        if (size >= 0) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            int third = scanner.nextInt();

            int countTriples = second - first == 1 && third - second == 1 ? 1 : 0;
            while (size != 0) {
                first = second;
                second = third;
                third = scanner.nextInt();
                if (second - first == 1 && third - second == 1) {
                    countTriples++;
                }
                size--;
            }

            System.out.print(countTriples);
        } else {
            System.out.print(0);
        }
    }
}

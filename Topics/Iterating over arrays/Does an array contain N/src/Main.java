import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int integer = scanner.nextInt();
        int i;
        for (i = 0; i < size; i++) {
            if (array[i] == integer) {
                break;
            }
        }
        if (i < size) {
            System.out.print(true);
        } else {
            System.out.print(false);
        }
    }
}

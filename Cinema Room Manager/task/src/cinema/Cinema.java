package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    private static final Scanner scanner = new Scanner(System.in);

    private static char[][] cinemaSeats;
    private static int rows;
    private static int seatsPerRow;
    private static int numberTickets;
    private static double percentageTickets;
    private static int income;

    private static int totalSeats;
    private static int totalIncome;

    public Cinema() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = scanner.nextInt();

        cinemaSeats = new char[rows][seatsPerRow];
        for (char[] row : cinemaSeats) {
            Arrays.fill(row, 'S');
        }

        numberTickets = 0;
        percentageTickets = 0.0;
        income = 0;

        totalSeats = rows * seatsPerRow;
        if (totalSeats <= 60) {
            totalIncome = totalSeats * 10;
        } else {
            int frontHalfSeats = (rows >> 1) * seatsPerRow;
            totalIncome = frontHalfSeats * 10 + (totalSeats - frontHalfSeats) * 8;
        }
    }

    public void showSeats() {
        System.out.println("\nCinema:");

        for (int seat = 1; seat <= seatsPerRow; seat++) {
            System.out.printf(" %d", seat);
        }
        System.out.println();

        for (int row = 0; row < rows; row++) {
            System.out.print(row + 1);
            for (int seat = 0; seat < seatsPerRow; seat++) {
                System.out.printf(" %c", cinemaSeats[row][seat]);
            }
            System.out.println();
        }
    }

    public void buyATicket() {
        int rowNumber;
        int seatNumber;
        boolean inputAgain;

        do {
            System.out.println("\nEnter a row number:");
            rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt();

            if (rowNumber > rows || seatNumber > seatsPerRow) {
                System.out.println("\nWrong input!");
                inputAgain = true;
            } else if (cinemaSeats[rowNumber - 1][seatNumber - 1] == 'B') {
                System.out.println("\nThat ticket has already been purchased!");
                inputAgain = true;
            } else {
                inputAgain = false;
            }
        } while (inputAgain);

        cinemaSeats[rowNumber - 1][seatNumber - 1] = 'B';
        numberTickets += 1;
        percentageTickets = numberTickets * 100.0 / totalSeats;

        if (totalSeats <= 60 || rowNumber <= (rows >> 1)) {
            income += 10;
            System.out.println("\nTicket price: $10");
        } else {
            income += 8;
            System.out.println("\nTicket price: $8");
        }
    }

    public void statistics() {
        System.out.printf("\nNumber of purchased tickets: %d\n", numberTickets);
        System.out.printf("Percentage: %.2f%%\n", percentageTickets);
        System.out.printf("Current income: $%d\n", income);
        System.out.printf("Total income: $%d\n", totalIncome);
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {

        Cinema cinema = new Cinema();
        byte option = 1;

        while (option != 0) {
            showMenu();
            option = scanner.nextByte();

            switch (option) {
                case 1 -> cinema.showSeats();
                case 2 -> cinema.buyATicket();
                case 3 -> cinema.statistics();
                default -> {
                }
            }
        }
    }
}
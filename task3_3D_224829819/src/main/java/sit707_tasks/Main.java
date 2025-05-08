package sit707_tasks;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Boundary Value Analysis (BVA) Tests ===");

        // January: Max boundary (31)
        System.out.println("\nJanuary 31 → increment → should go to February 1:");
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Original: " + date);
        date.increment();
        System.out.println("Incremented: " + date);

        // January: Min boundary (1)
        System.out.println("\nJanuary 1 → decrement → should go to December 31 previous year:");
        date = new DateUtil(1, 1, 2024);
        System.out.println("Original: " + date);
        date.decrement();
        System.out.println("Decremented: " + date);

        // Nominal value: random day in January
        System.out.println("\nRandom nominal day in January:");
        int randDay = 2 + new Random().nextInt(29); // avoid edge cases
        date = new DateUtil(randDay, 1, 2024);
        System.out.println("Original: " + date);
        date.increment();
        System.out.println("Incremented: " + date);

        // Leap year transition: Feb 28 → 29 → March 1
        System.out.println("\nLeap year: Feb 28 → 29 → Mar 1:");
        date = new DateUtil(28, 2, 2024);
        System.out.println("Original: " + date);
        date.increment();
        System.out.println("After 1st increment: " + date);
        date.increment();
        System.out.println("After 2nd increment: " + date);

        // December 31 → January 1 (year change)
        System.out.println("\nDecember 31 → increment → January 1 next year:");
        date = new DateUtil(31, 12, 2024);
        System.out.println("Original: " + date);
        date.increment();
        System.out.println("Incremented: " + date);

        // April 30 → increment → May 1
        System.out.println("\nApril 30 → increment → May 1:");
        date = new DateUtil(30, 4, 2024);
        System.out.println("Original: " + date);
        date.increment();
        System.out.println("Incremented: " + date);

        System.out.println("\n=== Equivalence Class Testing (ECT) Tests ===");

        // Invalid: April 31
        try {
            System.out.println("\nInvalid date: April 31 (ECT - invalid day in month)");
            date = new DateUtil(31, 4, 2024);
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Invalid: Month 13
        try {
            System.out.println("\nInvalid date: Month 13 (ECT - invalid month)");
            date = new DateUtil(10, 13, 2024);
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Invalid: Day 0
        try {
            System.out.println("\nInvalid date: Day 0 (ECT - invalid day)");
            date = new DateUtil(0, 1, 2024);
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Invalid: Year below minimum
        try {
            System.out.println("\nInvalid date: Year 1600 (ECT - invalid year)");
            date = new DateUtil(1, 1, 1600);
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Valid: Middle of the year
        System.out.println("\nValid date: July 15, 2024 (ECT - valid class)");
        date = new DateUtil(15, 7, 2024);
        System.out.println("Original: " + date);
        date.increment();
        System.out.println("Incremented: " + date);

        System.out.println("\n=== Demo Completed: BVA and ECT Showcased ===");
    }
}

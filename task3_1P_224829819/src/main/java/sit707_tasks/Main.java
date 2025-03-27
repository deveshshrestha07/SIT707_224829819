package sit707_tasks;

/**
 * Main class.
 * Author: Devesh Shrestha - 224829819
 */
public class Main 
{
    public static void main(String[] args) 
    {   
        // January max boundary: increment should go to February
        System.out.println("January max: increment should go to February.");
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println(date);
        date.increment();
        System.out.println(date);
        
        // January max boundary: decrement should be 30 January
        System.out.println("January max: decrement should be 30 January.");
        date = new DateUtil(31, 1, 2024);
        System.out.println(date);
        date.decrement();
        System.out.println(date);
        
        // January mid-range test: fixed to 16 Jan
        System.out.println("January random day between (1, 31): increment should be 1 day next.");
        date = new DateUtil(16, 1, 2024);
        System.out.println(date);
        date.increment();
        System.out.println(date);
        
        // January min boundary: increment to 2nd Jan
        System.out.println("January min: increment should be 2nd January.");
        date = new DateUtil(1, 1, 2024);
        System.out.println(date);
        date.increment();
        System.out.println(date);
        
        // January min boundary: decrement to 31 Dec 2023
        System.out.println("January min: decrement should be 31 December previous year.");
        date = new DateUtil(1, 1, 2024);
        System.out.println(date);
        date.decrement();
        System.out.println(date);        
    }
}

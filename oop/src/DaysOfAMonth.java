import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class DaysOfAMonth {

    public static boolean inArray(String[] arr, String checkValue) {
        boolean test = Arrays.asList(arr).contains(checkValue);
        return test;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Month: ");
        String month = scan.next();
        System.out.print("Year: ");
        int year = scan.nextInt();

        String month31DaysFull[] = {"January", "March", "May", "July", "August", "October", "December"};
        String month31DaysAbbre[] = {"Jan.", "Mar.", "Aug.", "Oct.", "Dec."};
        String month31Days3Letters[] = {"Jan", "Mar", "Aug", "Jul", "Oct", "Dec"};
        String month31DaysNumber[] = {"1", "3", "5", "7", "8", "10", "12"};

        String month30DaysFull[] = {"April", "June", "September", "November"};
        String month30DaysAbbre[] = {"Apr.", "Sept.", "Nov."};
        String month30Days3Letters[] = {"Apr", "Jun", "Sep", "Nov"};
        String month30DaysNumber[] = {"4", "6", "9", "11"};

        while (year < 0) {
            System.out.print("Please enter a valid year: ");
            int a = scan.nextInt();
            year = a;
        }

        if (inArray(month31DaysFull, month) | inArray(month31DaysAbbre, month) | inArray(month31Days3Letters, month) | inArray(month31DaysNumber, month)) {
            System.out.println(31);
        }
        else if (inArray(month30DaysFull, month) | inArray(month30DaysAbbre, month) | inArray(month30Days3Letters, month) | inArray(month30DaysNumber, month)) {
            System.out.println(30);
        }
        else if (month.equals("February") | month.equals("Feb.") | month.equals("Feb") | month.equals("2")) {
            if (year % 4 == 0) {
                if (year % 100 == 0 && year % 400 != 0) {
                    System.out.println(28);
                }
                else {
                    System.out.println(29);
                }
            }
            if (year % 4 != 0) {
                System.out.println(28);
            }
        }
        else {
            System.out.print("Please enter a valid month: ");
            String a = scan.next();
            month = a;
            
            if (inArray(month31DaysFull, month) | inArray(month31DaysAbbre, month) | inArray(month31Days3Letters, month) | inArray(month31DaysNumber, month)) {
                System.out.println(31);
            }
            else if (inArray(month30DaysFull, month) | inArray(month30DaysAbbre, month) | inArray(month30Days3Letters, month) | inArray(month30DaysNumber, month)) {
                System.out.println(30);
            }
            else if (month.equals("February") | month.equals("Feb.") | month.equals("Feb") | month.equals("2")) {
                if (year % 4 == 0) {
                    if (year % 100 == 0 && year % 400 != 0) {
                        System.out.println(28);
                    }
                    else {
                        System.out.println(29);
                    }
                }
                if (year % 4 != 0) {
                    System.out.println(28);
                }
            }
        }
    }
    
}   

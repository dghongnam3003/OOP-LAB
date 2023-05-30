package hust.soict.dsai.lab01;
import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int i, j, n, k = 0;
        n = keyboard.nextInt();
        
        for (i = 1; i <= n; i++, k = 0) {
            for (j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            while (k != (2*i-1)) {
                System.out.print("*");
                k++;
            }
            System.out.print("\n");
        }
    }
}

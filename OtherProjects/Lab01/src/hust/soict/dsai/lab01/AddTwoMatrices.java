package hust.soict.dsai.lab01;
import java.util.Scanner;

public class AddTwoMatrices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
    
        int matrix1[][] = new int[n][m];
        int matrix2[][] = new int[n][m];
        int sumMatrix[][] = new int[n][m];
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = in.nextInt();
            }
        } 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix2[i][j] = in.nextInt();
            }
        } 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        } 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", sumMatrix[i][j]);
            }
            System.out.println();
        }
    }
}

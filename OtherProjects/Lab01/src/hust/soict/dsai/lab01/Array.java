package hust.soict.dsai.lab01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = new ArrayList<Integer>();

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }

        Collections.sort(arr);

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr.get(i));
        }

        System.out.print("\n");
        System.out.print(sum);
    }
}

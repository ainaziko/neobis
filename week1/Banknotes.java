package week1;

import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] banknotes = {100, 50, 20, 10, 5, 2, 1};

        for(int i : banknotes){
            int numOfCurrBanknote = num / i;
            System.out.println(numOfCurrBanknote + " nota(s) de R$ " + i + ",00");
            num -= numOfCurrBanknote * i;
        }
    }
}
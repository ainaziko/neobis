import java.util.Scanner;

public class LogicalSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        doIt(in.nextInt(), in.nextInt());
    }
    private static void doIt(int col, int num){
        int counter = 0;
        for(int i = 1; i <= num; i++){
            String ii = i + "";
            if(counter == col){
                System.out.println();
                counter = 0;
            }
            counter++;
            if(counter != col){ii += " ";}
            System.out.print(ii);
        }
    }
}
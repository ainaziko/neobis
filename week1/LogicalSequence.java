import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int column = in.nextInt();
        int num = in.nextInt();
        int c = 0;

        for(int i = 1; i <= num; i++){
            if(c != column - 1){
                System.out.print(i + " ");
                c++;
            }else {
                System.out.println(i);
                c = 0;
            }
        }
    }
}
import java.util.Scanner;
public class ColumnInArray{
    private static float[][] arr = new float[12][12];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int columnNum = in.nextInt();
        char sumOrAvg = in.next().charAt(0);

        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                arr[i][j] = in.nextFloat();
            }
        }

        /*for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                System.out.print(" [" + arr[i][j] + "] ");
            }
            System.out.println();
        }*/

        if(sumOrAvg == 'S'){
            float s = sumUp(columnNum);
            System.out.println(String.format("%.1f", s));
        }

		else if(sumOrAvg == 'A'){
            float summ = sumUp(columnNum);
            System.out.println(String.format("%.1f",(summ / 12)));
        }
    }

    private static float sumUp(int columnNum){
        float sum = 0;
        for(int row = 0; row < 12; row++){
            sum += arr[row][columnNum];
        }
        return sum;
    }
}
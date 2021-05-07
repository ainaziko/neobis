import java.util.Scanner;
public class WeightedAvg{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        for (int i = 0; i < n; i++){
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();

            double res = (a * 2.0 + b * 3.0 + c * 5.0)/ (2.0 + 3.0 + 5.0);
            System.out.println(String.format("%.1f", res));
        }
    }
}

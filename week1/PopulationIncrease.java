import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PopulationIncrease p = new PopulationIncrease();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            p.calculate(in.nextInt(), in.nextInt(), in.nextDouble(), in.nextDouble());
        }
    }

    private void calculate(int pA, int pB, double g1, double g2){
        int counter = 0;

        int perYearA = (int)Math.round((pA * g1)/100);
        int perYearB = (int)Math.round((pB * g2)/100);
        System.out.println(perYearA + " " + perYearB);

        while(pA <= pB){
            pA += perYearA;
            pB += perYearB;
            if(counter >= 100) { System.out.println("Mais de 1 seculo.");break; }
            counter++;
        }
        System.out.println(counter + " anos.");
    }
}
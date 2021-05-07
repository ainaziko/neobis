import java.util.Scanner;

public class Grenais {
    static int scoreInter = 0;
    static int scoreGremio = 0;
    static int empates = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = 1;
        Grenais g = new Grenais();
        int inter = in.nextInt();
        int gremio = in.nextInt();
        System.out.println("Novo grenal (1-sim 2-nao)");
        int contin = in.nextInt();

        g.count(inter,gremio);
        while (contin == 1){
            g.count(in.nextInt(), in.nextInt());
            System.out.println("Novo grenal (1-sim 2-nao)");
            contin = in.nextInt();
            counter++;
        }
        System.out.println(counter + " grenais");
        System.out.println("Inter:" + scoreInter);
        System.out.println("Gremio:" + scoreGremio);
        System.out.println("Empates:" + empates);
        if(scoreInter > scoreGremio){
            System.out.println("Inter venceu mais");
        }else {
            System.out.println("Gremio venceu mais");
        }


    }

    private void count(int inter, int gremio){
        if(inter == gremio) empates++;
        else if(inter < gremio) scoreGremio++;
        else  if(inter > gremio) scoreInter++;
    }
}

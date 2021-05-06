import java.util.Scanner;
import java.util.Arrays;
public class TriangleTypes{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double[] s = {in.nextDouble(), in.nextDouble(), in.nextDouble()};
        Arrays.sort(s);

        double a = s[2];
        double b = s[1];
        double c = s[0];

        if(a >= (b+c)){System.out.println("NAO FORMA TRIANGULO");}
        else if(Math.pow(a,2) == Math.pow(b,2) + Math.pow(c,2)){System.out.println("TRIANGULO RETANGULO");}
        else if(Math.pow(a,2) > Math.pow(b,2) + Math.pow(c,2)){System.out.println("TRIANGULO OBTUSANGULO");}
        else if(Math.pow(a,2) < Math.pow(b,2) + Math.pow(c,2)){System.out.println("TRIANGULO ACUTANGULO");}

        if(a == b && a == c){System.out.println("TRIANGULO EQUILATERO");}
        else if((a == b && a != c) || (b == c && b != a) || (a == c && a != b)){System.out.println("TRIANGULO ISOSCELES");}
    }
}
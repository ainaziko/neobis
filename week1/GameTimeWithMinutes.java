import java.util.Scanner;

public class GameTimeWithMinutes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int iHour = in.nextInt();
        int iMinute = in.nextInt();

        int fHour = in.nextInt();
        int fMinute = in.nextInt();
        GameTimeWithMinutes n = new GameTimeWithMinutes();
        n.calculate(iHour, iMinute, fHour, fMinute);

    }

    private void calculate(int iHour, int iMinute, int fHour, int fMinute) {
        int iTime = iHour * 60 + iMinute;
        int fTime = fHour * 60 + fMinute;

        int resInMin = fTime - iTime;

        if (resInMin > 0) {
            System.out.println("O JOGO DUROU " + resInMin / 60 + " HORA(S) E " + resInMin % 60 + " MINUTO(S)");
        } else if (resInMin < 0) {
            System.out.println("O JOGO DUROU " + (24 * 60 - resInMin) / 60 + " HORA(S) E " + (24 * 60 - resInMin) % 60 + " MINUTO(S)");
        } else if (resInMin == 0) {
            System.out.println("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)");
        }
    }
}
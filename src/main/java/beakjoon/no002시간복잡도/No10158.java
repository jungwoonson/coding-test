package beakjoon.no002시간복잡도;

import java.util.Scanner;

public class No10158 {

    public static String answer(int w, int h, int p, int q, int t) {
        int pRemainder = (p + t) % (2 * w);
        int qRemainder = (q + t) % (2 * h);

        int lastP = pRemainder > w ? 2 * w - pRemainder : pRemainder;
        int lastQ = qRemainder > h ? 2 * h - qRemainder : qRemainder;

        return lastP + " " + lastQ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int t = scanner.nextInt();

        System.out.println(answer(w, h, p, q, t));
    }
}

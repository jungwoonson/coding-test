package beakjoon.no001문자열;

import java.util.Scanner;

public class No13223 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String now = sc.nextLine();
        String target = sc.nextLine();

        System.out.println(answer(now, target));
    }

    public static String answer(String now, String target) {
        String[] nowSplit = now.split(":");
        String[] targetSplit = target.split(":");

        int nowHour = Integer.parseInt(nowSplit[0]);
        int nowMin = Integer.parseInt(nowSplit[1]);
        int nowSec = Integer.parseInt(nowSplit[2]);

        int targetHour = Integer.parseInt(targetSplit[0]);
        int targetMin = Integer.parseInt(targetSplit[1]);
        int targetSec = Integer.parseInt(targetSplit[2]);

        int hour = targetHour - nowHour;
        int min = targetMin - nowMin;
        int sec = targetSec - nowSec;

        if (sec < 0) {
            sec = 60 + sec;
            min--;
        }
        if (min < 0) {
            min = 60 + min;
            hour--;
        }
        if (hour < 0) {
            hour = 24 + hour;
        }
        if (hour == 0 && min == 0 && sec == 0) {
            hour = 24;
        }

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}

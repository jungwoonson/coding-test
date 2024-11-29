package beakjoon.no014재귀;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class No16987_1 {

    public static int maxCount = 0;

    public static class Egg {
        private final int id;
        private int durability;
        private final int weight;

        public Egg(int id, int durability, int weight) {
            this.id = id;
            this.durability = durability;
            this.weight = weight;
        }

        public void touch(Egg other) {
            durability -= other.weight;
            other.durability -= weight;
        }

        public void recover(Egg other) {
            durability += other.weight;
            other.durability += weight;
        }

        public boolean isDie() {
            return durability <= 0;
        }

        public int getDurability() {
            return durability;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        maxCount = 0;

        int n = Integer.parseInt(br.readLine());

        List<Egg> eggs = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            eggs.add(new Egg(i, Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        function2(0, eggs);

        bw.write(maxCount + "");
        bw.flush();
        bw.close();
    }

    public static void function2(int current, List<Egg> eggs) {
        if (current == eggs.size()) {
            int count = countBrokenEggs(eggs);
            maxCount = Math.max(count, maxCount);
            return;
        }
        Egg currentEggs = eggs.get(current);

        if(currentEggs.isDie()) {
            function2(current + 1 ,eggs);
            return;
        }

        for (int i = 0; i < eggs.size(); i++) {
            boolean isTouch = false;
            Egg other = eggs.get(i);
            if (i != current && !other.isDie()) {
                isTouch = true;
                currentEggs.touch(other);
            }
//
//            if (i == current) {
//                continue;
//            }
//            if (!other.isDie()) {
//                isTouch = true;
//                currentEggs.touch(other);
//            }


            if (isTouch) {
                function2(current + 1, eggs);
                currentEggs.recover(other);
            } else if (!isTouch && countBrokenEggs(eggs) == eggs.size() - 1) {
                function2(current + 1, eggs);
            }
        }
    }
    
    public static int countBrokenEggs(List<Egg> eggs) {
        int count = 0;
        for (Egg egg : eggs) {
            if(egg.isDie()) {
                count++;
            }
        }
        return count;
    }
}

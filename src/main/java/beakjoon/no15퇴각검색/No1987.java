package beakjoon.no15퇴각검색;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class No1987 {

    public static final String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");
        int r = Integer.parseInt(line1[0]);
        int c = Integer.parseInt(line1[1]);
        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        Player player = new Player(board, r, c);

        recursion(board, player);

        bw.write(player.getMaxMoveCount() + "");

        bw.flush();
        bw.close();
    }

    public static void recursion(char[][] board, Player player) {

        for (String direction : directions) {
            if (player.checkCanMove(board, direction)) {
                player.move(board, direction);
                recursion(board, player);
                player.back(board, direction);
            }
        }
    }
}

class Player {

    public static final String UP = No1987.directions[0];
    public static final String DOWN = No1987.directions[1];
    public static final String LEFT = No1987.directions[2];
    public static final String RIGHT = No1987.directions[3];

    private final int r;
    private final int c;

    private int v;
    private int h;
    private int moveCount;
    private int maxMoveCount;

    private final Set<Character> values = new HashSet<>();

    public Player(char[][] board, int r, int c) {
        this.r = r;
        this.c = c;
        this.v = 0;
        this.h = 0;
        this.moveCount = 1;
        this.maxMoveCount = 1;
        values.add(board[this.v][this.h]);
    }

    public boolean checkCanMove(char[][] board, String direction) {
        if (UP.equals(direction) && v <= 0) {
            return false;
        }
        if (DOWN.equals(direction) && v >= r - 1) {
            return false;
        }
        if (LEFT.equals(direction) && h <= 0) {
            return false;
        }
        if (RIGHT.equals(direction) && h >= c - 1) {
            return false;
        }

        if (UP.equals(direction)) {
            return !values.contains(board[v - 1][h]);
        }
        if (DOWN.equals(direction)) {
            return !values.contains(board[v + 1][h]);
        }
        if (LEFT.equals(direction)) {
            return !values.contains(board[v][h - 1]);
        }
        if (RIGHT.equals(direction)) {
            return !values.contains(board[v][h + 1]);
        }

        return false;
    }

    public void move(char[][] board, String direction) {
        if (UP.equals(direction)) {
            v--;
        }
        if (DOWN.equals(direction)) {
            v++;
        }
        if (LEFT.equals(direction)) {
            h--;
        }
        if (RIGHT.equals(direction)) {
            h++;
        }
        char value = board[v][h];
        values.add(value);
        moveCount++;
        maxMoveCount = Math.max(maxMoveCount, this.moveCount);
    }

    public void back(char[][] board, String direction) {
        char value = board[v][h];
        values.remove(value);
        moveCount--;
        if (UP.equals(direction)) {
            v++;
        }
        if (DOWN.equals(direction)) {
            v--;
        }
        if (LEFT.equals(direction)) {
            h++;
        }
        if (RIGHT.equals(direction)) {
            h--;
        }
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }
}

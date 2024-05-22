package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;

public class No1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int count = 0;
        int ended = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= ended) {
                count++;
                ended = meeting.end;
            }
        }

        bw.write(count + "");

        bw.flush();
        bw.close();
    }
}

class Meeting {
    public int start;
    public int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

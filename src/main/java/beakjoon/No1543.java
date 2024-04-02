package beakjoon;

public class No1543 {

    public int answer(String document, String value) {
        int answer = 0;
        int startIndex = 0;

        while (true) {
            int findIndex = document.indexOf(value, startIndex);
            if (findIndex < 0) {
                break;
            }
            startIndex = findIndex + value.length();
            answer++;
        }

        return answer;
    }
}

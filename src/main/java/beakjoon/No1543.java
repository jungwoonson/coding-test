package beakjoon;

public class No1543 {

    public int answer(String document, String value) {
        int answer = 0;

        for (int i = 0; i < document.length(); i++) {
            boolean isDuplicated = true;
            for (int j = 0; j < value.length(); j++) {
                if (i + j >= document.length()) {
                    isDuplicated = false;
                    break;
                }

                if (document.charAt(i + j) != value.charAt(j)) {
                    isDuplicated = false;
                    break;
                }
            }
            if (isDuplicated) {
                answer++;
                i += value.length() - 1;
            }
        }

        return answer;
    }
}

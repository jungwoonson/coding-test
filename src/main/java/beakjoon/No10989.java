package beakjoon;

public class No10989 {

    public static int[] answer(int[] numbers) {
        int[] counts = new int[10001];
        for (int i = 0; i < numbers.length; i++) {
            counts[numbers[i]]++;
        }

        int index = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    numbers[index] = i;
                    index++;
                }
            }
        }

        return numbers;
    }
}

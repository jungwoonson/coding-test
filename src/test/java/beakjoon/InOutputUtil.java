package beakjoon;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InOutputUtil {

    public static final String NL = System.lineSeparator();

    public static void setIn(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}

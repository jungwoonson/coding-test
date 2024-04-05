package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class InOutputUtil {

    public static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    public static final PrintStream standardOut = System.out;

    public static void setIn(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}

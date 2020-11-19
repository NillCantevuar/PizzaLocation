package operators;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Liner {

    public List<String> parts(BufferedReader br) throws IOException {
        List<String> parts = new ArrayList<>();
        while (true) {
            String input = br.readLine();
            if (input.trim().equals("pizza.out")) {
                break;
            } else if (input.equals(" ") || input.equals("")) {

            } else {
                parts.add(input);
            }
        }
        return parts;
    }
}

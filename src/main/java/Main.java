import operators.Liner;
import operators.Optimizer;
import operators.Procesor;
import pojo.MapedLines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        mainLoop();

    }

    private static void mainLoop() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Liner liner = new Liner();
        Procesor procesor = new Procesor();
        Optimizer optimizer = new Optimizer();


        do{
            String input = bufferedReader.readLine();
            if (input.trim().equals("pizza.in")){

                List<String> parts = liner.parts(bufferedReader);//Spliting given text into single lines.
                MapedLines procesedLines = procesor.proces(parts);//Translating data from lines into data object
                System.out.println(
                        optimizer.selectOptimal(procesedLines));//Selecting best combination from given data
            }
        }while (bufferedReader.ready());
    }
}

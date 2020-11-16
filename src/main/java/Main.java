import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        mainRun();

    }

    private static void mainRun() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Liner liner = new Liner();
        Procesor procesor = new Procesor();
        Optimizer optimizer = new Optimizer();


        do{

            String input = bufferedReader.readLine();

            if (input.trim().equals("pizza.in")){

                List<String> parts = liner.parts(bufferedReader);//good
                MapedLines procesedLines = procesor.proces(parts);
                System.out.println(
                        optimizer.selectOptimal(procesedLines));


            }


        }while (bufferedReader.ready());
    }
}

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Optimizer {


    public int selectOptimal(MapedLines mapedLines) {

        Scanner scanner = new Scanner(mapedLines.getRestaurantsRange());
        List<Integer> scoreList = new ArrayList<>();

        List<List<Point>> locationsSetList
                = scanner.selectLocationsToScan(mapedLines.getRestaurantsQuant()
                , mapedLines.getLocations().size(), mapedLines.getLocations());

        for (List<Point> set : locationsSetList
        ) {

             int singleSocre = scanner.scanLocationSet(set, mapedLines.getSolits());
             scoreList.add(singleSocre);

        }

        return selectHighest(scoreList);


    }


    private int selectHighest(List<Integer> scores){

        int max = 0;
        for (Integer i:scores
             ) {
            if (i>max){
                max =i ;
            }
        }
        return max;
    }
}

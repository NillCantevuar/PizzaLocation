package operators;

import pojo.MapedLines;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Optimizer {


    public int selectOptimal(MapedLines mapedLines) {

        LocationScanner locationScanner = new LocationScanner(mapedLines.getRestaurantsRange());
        List<Integer> scoreList = new ArrayList<>();
        //generate all posible setup's of locations
        List<List<Point>> locationsSetList
                = locationScanner.selectLocationsToScan(mapedLines.getRestaurantsQuant()
                , mapedLines.getLocations().size(), mapedLines.getLocations());

        //calculate setup's and select highest possible
        for (List<Point> set : locationsSetList
        ) {
            int singleSocre = locationScanner.scanLocationSet(set, mapedLines.getSolits());
            scoreList.add(singleSocre);
        }
        return selectHighest(scoreList);
    }

    private int selectHighest(List<Integer> scores) {
        int max = 0;
        for (Integer i : scores
        ) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}

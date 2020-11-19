package operators;

import pojo.MapedLines;
import pojo.Solit;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Procesor {

    public MapedLines proces(List<String> parts) {
        return mapLines(parts);


    }

    private MapedLines mapLines(List<String> pats) {
        MapedLines mapedLines = new MapedLines();

        int line = 0;

        mapedLines.setRestaurantsQuant(Integer.parseInt(pats.get(0).trim().split(" ")[0]));
        mapedLines.setRestaurantsRange(Integer.parseInt(pats.get(0).trim().split(" ")[1]));
        line++;

        Integer possibleLocationQuant = Integer.parseInt(pats.get(1).trim());
        line++;

        List<Point> possibleLocations = new ArrayList<>();
        int lineVal = line;

        for (int i = lineVal; i < possibleLocationQuant + lineVal; i++) {
            Point point = new Point();
            point.setLocation(Integer.parseInt(pats.get(i).trim().split(" ")[0]),
                    Integer.parseInt(pats.get(i).trim().split(" ")[1])
            );
            line++;
            possibleLocations.add(point);

        }
        mapedLines.setLocations(possibleLocations);

        Integer solitQuant = Integer.parseInt(pats.get(line).trim());
        line++;

        List<Solit> solits = new ArrayList<>();
        lineVal = line;

        for (int i = lineVal; i < solitQuant + lineVal; i++) {
            Solit solit = new Solit(new Point(Integer.parseInt(pats.get(i).trim().split(" ")[0]),
                    Integer.parseInt(pats.get(i).trim().split(" ")[1])),
                    Integer.parseInt(pats.get(i).trim().split(" ")[2]));
            solits.add(solit);
            line++;

        }
        mapedLines.setSolits(solits);

        return mapedLines;
    }

}

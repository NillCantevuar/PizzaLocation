package operators;

import pojo.Solit;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class LocationScanner {

    public int range;

    public LocationScanner(int range) {
        this.range = range;
    }
    // method reciving all combinations we can find for actual case
    public List<List<Point>> selectLocationsToScan(int restaurantsQuant, int locationQuant, List<Point> locations) {

        List<Integer> combinations = selectNaturalCombinations(restaurantsQuant, locationQuant);
        List<List<Point>> requestedPointsSet = new ArrayList<>();

        for (Integer i : combinations
        ) {
            char[] temopCombinationCell = new char[locationQuant];
            char[] combinationCell = Integer.toBinaryString(i).toCharArray();

            if (combinationCell.length < locationQuant) {
                int misingBinaryIndex = 0;

                for (int x = combinationCell.length; x < locationQuant; x++) {
                    temopCombinationCell[misingBinaryIndex] = '0';
                    misingBinaryIndex++;
                }
                int filledIndex = 0;
                for (int j = misingBinaryIndex; j < locationQuant; j++) {
                    temopCombinationCell[j] = combinationCell[filledIndex];
                    filledIndex++;
                }
                combinationCell = temopCombinationCell;
            }

            List<Point> requestedPoints = new ArrayList<>();
            for (int j = 0; j < combinationCell.length; j++) {
                if (combinationCell[j] == '1') {
                    requestedPoints.add(locations.get(j));
                }
            }
            requestedPointsSet.add(requestedPoints);
        }
        return requestedPointsSet;
    }
    // selecting nubers wich binary representation is correct for simulation of location setup
    public List<Integer> selectNaturalCombinations(int restaurantsQuant, int locationsQuant) {

        int[] naturalNumbers = generateNaturalNumbersArray(locationsQuant);
        List<Integer> combinationRepresentation = new ArrayList<>();

        for (int i = 0; i < naturalNumbers.length; i++) {
            int trueCounter = 0;

            for (char c : Integer.toBinaryString(naturalNumbers[i]).toCharArray()
            ) {
                if (c == '1') {
                    trueCounter++;
                }
            }
            if (trueCounter == restaurantsQuant) {
                combinationRepresentation.add(naturalNumbers[i]);
            }
        }
        return combinationRepresentation;
    }
    //generating numbers which binary representation size is in range
    private int[] generateNaturalNumbersArray(int numberLocations) {
        int[] possibleLocations = new int[(int) Math.pow(2, numberLocations)];

        int naturalNumber = 0;
        for (int i = 0; i < possibleLocations.length; i++) {
            possibleLocations[i] = naturalNumber;
            naturalNumber++;
        }
        return possibleLocations;
    }
    //method scaning set of locations not including repetitons in solits
    public int scanLocationSet(List<Point> locations, List<Solit> solits) {
        int peopleCount = 0;

        for (Point point : locations
        ) {
            peopleCount += scanLocation(point, solits);
        }
        solits.forEach(solit -> solit.setChecked(false));
        return peopleCount;
    }

    //method scaning single location for solits
    public int scanLocation(Point locationCoord, List<Solit> solitList) {
        int customerCounter = 0;

        for (Solit sol : solitList
        ) {
            if (!sol.isChecked()) {
                if (isInRange(locationCoord, sol, range)) {
                    customerCounter += sol.getPeoples();
                    sol.setChecked(true);
                }
            }
        }
        return customerCounter;
    }

    // method calculating that solit is in range of location
    private boolean isInRange(Point locationCoord, Solit sol, int range) {

        Double sxd = Double.valueOf(sol.getCoordinates().x);
        Double lxd = Double.valueOf(locationCoord.x);
        Double syd = Double.valueOf(sol.getCoordinates().y);
        Double lyd = Double.valueOf(locationCoord.y);
        return (Math.sqrt(Math.pow(sxd - lxd, 2) + Math.pow(syd - lyd, 2)) <= range);
    }


}

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneToHold {

    class Solit {

        private boolean checked;
        private int peoples;
        private Point coordinates;

        public Solit( Point coordinates,int peoples) {
            this.peoples = peoples;
            this.coordinates = coordinates;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public int getPeoples() {
            return peoples;
        }

        public void setPeoples(int peoples) {
            this.peoples = peoples;
        }

        public Point getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Point coordinates) {
            this.coordinates = coordinates;
        }
    }

    class Scanner {

        public int range;

        public Scanner(int range) {
            this.range = range;
        }

        public java.util.List<java.util.List<Point>> selectLocationsToScan(int restaurantsQuant, int locationQuant, java.util.List<Point> locations) {

            java.util.List<Integer> combinations = selectNaturalCombinations(restaurantsQuant, locationQuant);
            java.util.List<java.util.List<Point>> requestedPointsSet = new ArrayList<>();

            for (Integer i : combinations
            ) {
                char[] temopCombinationCell = new char[locationQuant];

                char[] combinationCell = Integer.toBinaryString(i).toCharArray();

                if(combinationCell.length<locationQuant){
                    int misingBinaryIndex =0;



                    for (int x = combinationCell.length; x <locationQuant ; x++) {
                        temopCombinationCell[misingBinaryIndex] = '0';
                        misingBinaryIndex++;
                    }
                    int filledIndex = 0;
                    for (int j = misingBinaryIndex; j <locationQuant ; j++) {
                        temopCombinationCell[j] = combinationCell[filledIndex];
                        filledIndex++;
                    }
                    combinationCell =temopCombinationCell;
                }




                java.util.List<Point> requestedPoints = new ArrayList<>();

                for (int j = 0; j < combinationCell.length ; j++) {

                    //tu było

                    if (combinationCell[j] == '1'){
                        requestedPoints.add(locations.get(j));
                    }


                }
                requestedPointsSet.add(requestedPoints);

            }

            return requestedPointsSet;

        }

        public java.util.List<Integer> selectNaturalCombinations(int restaurantsQuant, int locationsQuant) {

            int[] naturalNumbers = generateNaturalNumbersArray(locationsQuant);

            java.util.List<Integer> combinationRepresentation = new ArrayList<>();

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

        private int[] generateNaturalNumbersArray(int numberLocations) {
            int[] possibleLocations = new int[(int) Math.pow(2, numberLocations)];
            int naturalNumber = 0;
            for (int i = 0; i < possibleLocations.length; i++) {
                possibleLocations[i] = naturalNumber;
                naturalNumber++;
            }

            return possibleLocations;
        }

        public int scanLocationSet(java.util.List<Point> locations, java.util.List<Solit> solits) {

            int peopleCount = 0;

            for (Point point : locations
            ) {
                peopleCount += scanLocation(point, solits);
            }
            solits.forEach(solit -> solit.setChecked(false));
            return peopleCount;

        }


        public int scanLocation(Point locationCoord, List<Solit> solitList) {

            int customerCounter = 0;

            for (Solit sol : solitList
            ) {
                if (!sol.isChecked()) {
                    if (isInRange(locationCoord, sol,range)) {
                        customerCounter += sol.getPeoples();
                        sol.setChecked(true);
                    }
                }
            }
            return customerCounter;
        }

        private boolean isInRange(Point locationCoord, Solit sol, int range) {

            Double sxd = Double.valueOf(sol.getCoordinates().x);
            Double lxd = Double.valueOf(locationCoord.x);
            Double syd = Double.valueOf(sol.getCoordinates().y);
            Double lyd = Double.valueOf(locationCoord.y);


            return (Math.sqrt(Math.pow(sxd-lxd,2) + Math.pow(syd -lyd,2))<=range);




        }


    }

    class Procesor {

        public MapedLines proces(List<String> parts) {
            return  mapLines(parts);


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
    class Optimizer {


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
    class MapedLines {

        private Integer restaurantsQuant;
        private Integer restaurantsRange;
        private List<Point> locations;
        private List<Solit> solits;

        public MapedLines(){

        }

        public Integer getRestaurantsQuant() {
            return restaurantsQuant;
        }

        public void setRestaurantsQuant(Integer restaurantsQuant) {
            this.restaurantsQuant = restaurantsQuant;
        }

        public Integer getRestaurantsRange() {
            return restaurantsRange;
        }

        public void setRestaurantsRange(Integer restaurantsRange) {
            this.restaurantsRange = restaurantsRange;
        }

        public List<Point> getLocations() {
            return locations;
        }

        public void setLocations(List<Point> locations) {
            this.locations = locations;
        }

        public List<Solit> getSolits() {
            return solits;
        }

        public void setSolits(List<Solit> solits) {
            this.solits = solits;
        }

        public MapedLines(Integer restaurantsQuant, Integer restaurantsRange, List<Point> locations, List<Solit> solits) {
            this.restaurantsQuant = restaurantsQuant;
            this.restaurantsRange = restaurantsRange;
            this.locations = locations;
            this.solits = solits;
        }
    }
    class Liner {

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















}

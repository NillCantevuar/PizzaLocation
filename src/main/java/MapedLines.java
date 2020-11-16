import java.awt.Point;
import java.util.List;

public class MapedLines {

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

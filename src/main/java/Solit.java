import java.awt.*;

public class Solit {

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

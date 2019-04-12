package polyguide.buldingsmap;

import android.graphics.Point;

public class Vertex {

    private String label;
    private Point coordinate;
    private int floor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label.equals(vertex.label) &&
                coordinate.equals(vertex.coordinate) &&
               floor == vertex.floor;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    public Vertex(String label, Point coordinate, int floor)
    {
        this.label = label;
        this.coordinate = coordinate;
        this.floor = floor;
    }

    public String getLabel() {
        return label;
    }

    public int getFloor() { return floor;}

    public Point getCoordinate() {
        return coordinate;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
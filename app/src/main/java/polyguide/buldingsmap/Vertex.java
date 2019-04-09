package polyguide.buldingsmap;

import android.graphics.Point;

import java.util.Objects;

public class Vertex {

    private String label;
    private Point coordinate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label.equals(vertex.label) &&
                coordinate.equals(vertex.coordinate);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    public Vertex(String label, Point coordinate)
    {
        this.label = label;
        this.coordinate = coordinate;
    }

    public String getLabel() {
        return label;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
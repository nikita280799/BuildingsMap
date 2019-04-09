package polyguide.buldingsmap;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Graph graph;

    // xml пока не используется, все отображетние задается программно, там дальше смотрите как удобнее будет 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createGraph();
        DrawWay drawWay = new DrawWay(this);
        drawWay.setWayForDrawing(getPointsForDrawing(graph.bdf(new Vertex("V0", new Point(1000, 1000), 5), new Vertex("501", new Point(250, 500), 5))));
        HorizontalScrollView scroll = new HorizontalScrollView(this);
        scroll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        drawWay.setMinimumWidth(2000);
        scroll.addView(drawWay);
        setContentView(scroll);
    }

    public void createGraph() {
        graph = new Graph();
        Vertex v1 = new Vertex("501", new Point(250, 500), 5);
        Vertex v2 = new Vertex("N1", new Point(300, 500), 5);
        Vertex v3 = new Vertex("N2", new Point(300, 1000), 5);
        Vertex v4 = new Vertex("V0", new Point(1000, 1000), 5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addConnectionsInTwoSides(v4, v3);
        graph.addConnectionsInTwoSides(v3, v2);
        graph.addConnectionsInTwoSides(v2, v1);
    }

    public Stack<Point> getPointsForDrawing(Stack<Vertex> stack) {
        Stack<Point> stackOfPoints = new Stack<>();
        while (!stack.isEmpty()) {
            stackOfPoints.push(stack.pop().getCoordinate());
        }
        return stackOfPoints;
    }
}
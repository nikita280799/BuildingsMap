package polyguide.buldingsmap;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

public class MainActivity extends AppCompatActivity {

    Graph graph = Graph.NINEGRAPH;

    // xml пока не используется, все отображетние задается программно, там дальше смотрите как удобнее будет
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawWay drawWay = new DrawWay(this);
        drawWay.setTestPoints(graph.getVertexList());
        drawWay.setWayForDrawing(graph.bdf( new Vertex("101", new Point(668, 93), 1),  new Vertex("212", new Point(495, 328), 2)));
        HorizontalScrollView scroll = new HorizontalScrollView(this);
        scroll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        drawWay.setMinimumWidth(5000);
        scroll.addView(drawWay);
        setContentView(scroll);
    }
}
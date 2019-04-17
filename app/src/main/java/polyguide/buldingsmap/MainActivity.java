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
        //drawWay.setTestPoints(graph.getVertexList());
        //drawWay.setWayForDrawing(graph.searchWay(new Vertex("117", new Point(295, 324), 1), new Vertex("107", new Point(64, 273), 1)));
        drawWay.setGraphForDrawing(graph);
        HorizontalScrollView scroll = new HorizontalScrollView(this);
        scroll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        drawWay.setMinimumWidth(5000);
        scroll.addView(drawWay);
        setContentView(scroll);
    }
}
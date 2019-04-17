package polyguide.buldingsmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.List;
import java.util.Map;

/**
    Кастомный View для отрисовки графа на картинке корпуса
 */
public class DrawWay extends View {

    private Paint mPaint = new Paint();
    private Bitmap mBitmap;
    private List<Vertex> wayForDrawing;
    private List<Vertex> testPoints;
    private Graph graph; // только для проверки соединений

    private int activeFloor = 1;
    private boolean isNineBuildingPaint = true;
    private double[][] drawingCoef = {{3.39, 3.45}};


    public DrawWay(Context context) {
        super(context);
        drawFloor();
    }

    public void switchOnMainBuiding() {
        isNineBuildingPaint = false;
    }

    public void switchOnNineBuiding() {
        isNineBuildingPaint = true;
    }

    public void upFloor() {
      if (isNineBuildingPaint && activeFloor < 5 || !isNineBuildingPaint && activeFloor < 3) activeFloor++;
        drawFloor();
    }

    public void downFloor(){
        if (activeFloor > 1) activeFloor--;
        drawFloor();
    }

    private void drawFloor() {
        if (isNineBuildingPaint) {
            switch (activeFloor) {
                case 1: mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.build9first);
                break;
                case 2: mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.build9second);
                    break;
                case 3: mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.build9third);
                    break;
                case 4: mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.build9fourth);
                    break;
                case 5: mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.build9fifth);
                    break;
            }
        } else {
            switch (activeFloor) {
                case 1: mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.first);
                    break;
                case 2: mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.second);
                    break;
                case 3: mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.third);
                    break;
            }
        }
        invalidate();
    }


    public void setWayForDrawing(List<Vertex> way) {
        this.wayForDrawing = way;
    }

    public void setTestPoints(List<Vertex> testPoints) {
        this.testPoints = testPoints;
    }

    public void setGraphForDrawing(Graph graphForDrawing) {
        this.graph = graphForDrawing;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        canvas.drawCircle(2702, 560, 50, mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(35);
        mPaint.setTextSize(50);
        canvas.drawText( Integer.toString(activeFloor), 1000, 500, mPaint);
        canvas.drawText( Integer.toString(mBitmap.getWidth()), 1200, 500, mPaint);
        canvas.drawText( Integer.toString(mBitmap.getHeight()), 1400, 500, mPaint);
        if (wayForDrawing != null && !wayForDrawing.isEmpty()) drawWay(canvas);
        if (testPoints != null && !testPoints.isEmpty()) drawTestPoints(canvas);
        if (graph != null) drawGraph(canvas);
    }

    private void drawTestPoints(Canvas canvas) {
        for (Vertex v: testPoints) {
            if (v.getFloor() == activeFloor) canvas.drawCircle(v.getCoordinate().x * 3.5f, v.getCoordinate().y * 3.5f, 10, mPaint);
        }
    }

    private void drawWay(Canvas canvas) {
        Vertex from = wayForDrawing.get(0);
        for (Vertex to: wayForDrawing) {
            if (from.getFloor() == activeFloor && to.getFloor() == activeFloor) {
                canvas.drawLine(from.getCoordinate().x* 3.5f, from.getCoordinate().y* 3.5f, to.getCoordinate().x* 3.5f, to.getCoordinate().y* 3.5f, mPaint);
                from = to;
            }
        }
    }

    private void drawGraph(Canvas canvas) {
        for (Vertex from: graph.getVertexList()) {
            if (graph.getConnections(from) != null && !graph.getConnections(from).isEmpty()) {

                for (Vertex to : graph.getConnections(from)) {
                    canvas.drawLine(from.getCoordinate().x * 3.5f, from.getCoordinate().y* 3.5f, to.getCoordinate().x* 3.5f, to.getCoordinate().y* 3.5f, mPaint);
                }
            }
        }
    }
}
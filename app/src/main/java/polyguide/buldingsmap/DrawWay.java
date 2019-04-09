package polyguide.buldingsmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.ScrollView;

import java.util.Stack;

public class DrawWay extends View {

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;
    private Stack<Point> stack;


    public DrawWay(Context context) {
        super(context);
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.building);
    }

    public void setWayForDrawing(Stack<Point> stack) {
        this.stack = stack;
    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(20);
        if (!stack.isEmpty()) drawWay(canvas);
    }

    private void drawWay(Canvas canvas) {
        Point from = stack.pop();
        while (!stack.isEmpty()) {
            Point to = stack.pop();
            canvas.drawLine(from.x, from.y, to.x, to.y, mPaint);
            from = to;
        }
    }

}

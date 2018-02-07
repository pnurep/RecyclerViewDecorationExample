package com.example.gold.recyclerviewstudy;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by gold on 2018. 2. 7..
 */

public class MyDecoration2 extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int childPos = parent.getChildAdapterPosition(child);

            boolean isLeft = childPos % 2 == 0;
            int top = child.getTop();
            int bottom = child.getBottom();
            int widthPx = 16;
            Paint leftPaint = new Paint();
            leftPaint.setColor(Color.BLUE);
            Paint rightPaint = new Paint();
            rightPaint.setColor(Color.RED);

            if (isLeft) {
                int left = child.getLeft();
                int right = child.getLeft() + widthPx;
                c.drawRect(left, top, right, bottom, leftPaint);
            } else {
                int left = child.getRight() + widthPx;
                int right = child.getRight();

                c.drawRect(left, top, right, bottom, rightPaint);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

    }

}

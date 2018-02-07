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

public class MyDecoration extends RecyclerView.ItemDecoration {

    int dividerHeightPx = 1;
    Paint dividerPaint;

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        dividerPaint = new Paint();
        dividerPaint.setColor(Color.BLACK);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom() + dividerHeightPx;
            float bottom = view.getBottom();
            c.drawRect(left, top, right, bottom, dividerPaint);
        }

    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);



    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeightPx;
    }
}

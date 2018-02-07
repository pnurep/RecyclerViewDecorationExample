package com.example.gold.recyclerviewstudy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

/**
 * Created by gold on 2018. 2. 7..
 */

public class ComplexDecoration extends RecyclerView.ItemDecoration {

    Context mContext;
    Callback mCallback;
    Paint paint;
    TextPaint textPaint;
    private Paint.FontMetrics fontMetrics;

    int leftGap;
    int rightGap;
    int topGap;

    public ComplexDecoration(Context context, Callback callback) {
        this.mContext = context;
        this.mCallback = callback;

        textPaint = new TextPaint();
        paint = new Paint();

        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(80);
        textPaint.setColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        textPaint.getFontMetrics(fontMetrics);
        textPaint.setTextAlign(Paint.Align.LEFT);
        paint.setColor(ContextCompat.getColor(mContext, R.color.colorAccent));
        fontMetrics = new Paint.FontMetrics();

        leftGap = ((int) Utils.dpToPixel(24, mContext.getResources()));
        rightGap = ((int) Utils.dpToPixel(8, mContext.getResources()));
        topGap = ((int) Utils.dpToPixel(20, mContext.getResources()));

    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        final int totalItemCount = state.getItemCount();
        final int childCount = parent.getChildCount();
        final float left = parent.getPaddingLeft();
        final float lineHeight = textPaint.getTextSize() + fontMetrics.descent;

        long prevGroupId, groupId = -1;
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i);
            final int position = parent.getChildAdapterPosition(view);

            // Ignore items without a group and items that are in same group as previous item
            prevGroupId = groupId;
            groupId = mCallback.getGroupId(position);
            if (groupId < 0 || groupId == prevGroupId) continue;

            // Ignore empty text line
            final String textLine = mCallback.getGroupFirstLine(position).toUpperCase();
            if (TextUtils.isEmpty(textLine)) continue;

            // Find appropriate y position for text; on screen unless pushed off by bottom of group
            final int viewBottom = view.getBottom() + view.getPaddingBottom();
            float textY = Math.max(topGap, view.getTop() + view.getPaddingTop());
            if (position + 1 < totalItemCount) {
                long nextGroupId = mCallback.getGroupId(position + 1);
                if (nextGroupId != groupId && viewBottom < textY + lineHeight) {
                    // Next item is different group, align Y with bottom of current group
                    textY = viewBottom - lineHeight;
                }
            }

            // draw text
            c.drawText(textLine, left, textY, textPaint);

        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int pos = parent.getChildAdapterPosition(view);
        long groupId = mCallback.getGroupId(pos);
        if (groupId < 0) return;

        outRect.left = leftGap;
        outRect.right = rightGap;

        if (pos == 0 || isFirstInGroup(pos)) {
            outRect.top = topGap;
        } else {
            outRect.top = 0;
        }

    }

    private boolean isFirstInGroup(int position) {
        if (position == 0) {
            return true;
        } else {
            long prevGroupId = mCallback.getGroupId(position - 1);
            long groupId = mCallback.getGroupId(position);
            return prevGroupId != groupId;
        }
    }

}

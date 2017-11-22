package com.changqin.architecturedemo.weiget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wangchangqin on 2017/10/17.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration{
    private int offset;

    public SpacesItemDecoration(int offset) {
        this.offset = offset;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int itemPosition = parent.getChildAdapterPosition(view);
        //outRect.set(offset);
    }
}

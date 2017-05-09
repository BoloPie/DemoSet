package com.example.demoset.helper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.demoset.adapter.AdanceItemTouchAdapter;
import com.example.demoset.adapter.NormalAdapter;

/**
 * Created by 张凌云 on 2017/4/27.
 */

public class AdvancedItemTouchHelper extends ItemTouchHelper.Callback {

    private ItemTouchHelperAdapter mAdapter;

    public AdvancedItemTouchHelper(ItemTouchHelperAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0,ItemTouchHelper.LEFT );
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        ((AdanceItemTouchAdapter.ViewHolder)viewHolder).titleTV.setTranslationX(0);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        AdanceItemTouchAdapter.ViewHolder mViewHolder = (AdanceItemTouchAdapter.ViewHolder)viewHolder;
        int deleteWidth = mViewHolder.delLay.getWidth();
        float fraction = deleteWidth/(float) mViewHolder.itemView.getWidth();
        mViewHolder.titleTV.setTranslationX(dX * fraction);
    }
}

package com.example.demoset.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by 张凌云 on 2017/4/27.
 */
public class SimpleItemTouchHelper extends ItemTouchHelper.Callback {


    private ItemTouchHelperAdapter mAdapter;

    public SimpleItemTouchHelper(ItemTouchHelperAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //返回对于某个ViewHolder可以移动的方向，可选的值有UP/DOWN/LEFT/RIGHT/START/END。
        return makeMovementFlags(ItemTouchHelper.UP |ItemTouchHelper.DOWN , ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT);
    }


    /**当某个被拖动的Item被从旧位置拖动到了新位置后回调，如果返回true，
     * 那么ItemTouchHelper就认为viewHolder已经被移动到了target在Adapter中的位置。
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    /**当某个Item被滑动到消失时回调，direction表示滑动的方向。
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }
}

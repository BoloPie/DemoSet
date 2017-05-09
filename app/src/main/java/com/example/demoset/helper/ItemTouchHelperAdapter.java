package com.example.demoset.helper;

/**
 * Created by 张凌云 on 2017/5/9.
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}

package com.example.demoset.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by 张凌云 on 2017/5/9.
 */

public class EmpityListView extends ListView {
    public EmpityListView(Context context) {
        super(context);
    }

    public EmpityListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmpityListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setVisibility(final int visibility)
    {
        if(visibility!= View.GONE||getCount()!=0)
            super.setVisibility(visibility);
    }

}

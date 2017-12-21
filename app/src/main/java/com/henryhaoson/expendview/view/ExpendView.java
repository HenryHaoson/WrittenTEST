package com.henryhaoson.expendview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class ExpendView extends LinearLayout{
    private int mHeight;

    public ExpendView(Context context) {
        super(context);
    }

    public ExpendView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpendView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
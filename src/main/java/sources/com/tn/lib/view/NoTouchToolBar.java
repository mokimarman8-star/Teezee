package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class NoTouchToolBar extends Toolbar {
    private boolean U;

    public NoTouchToolBar(@NonNull Context context) {
        super(context);
        this.U = false;
    }

    public NoTouchToolBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.U;
    }

    public void setIntercept(boolean z) {
        this.U = z;
    }
}

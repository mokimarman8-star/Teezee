package com.mbridge.msdk.widget;

import android.view.View;
import java.util.Calendar;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a implements View.OnClickListener {
    private long a = 0;

    protected abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.a > 2000) {
            this.a = timeInMillis;
            a(view);
        }
    }
}

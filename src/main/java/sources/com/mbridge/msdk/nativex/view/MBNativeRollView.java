package com.mbridge.msdk.nativex.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class MBNativeRollView extends LinearLayout {
    private RollingBCView a;
    private Context b;
    private NativeListener.FilpListener c;

    public interface a {
    }

    public MBNativeRollView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View, com.mbridge.msdk.nativex.view.RollingBCView] */
    public MBNativeRollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        ?? rollingBCView = new RollingBCView(context);
        this.a = rollingBCView;
        addView(rollingBCView);
        this.a.setLayoutParams(new LinearLayout.LayoutParams((int) (t0.j(context) * 0.9d), -2));
        setClipChildren(false);
    }

    @SuppressLint({"NewApi"})
    public MBNativeRollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a.dispatchTouchEvent(motionEvent);
    }

    public void setData(List<Frame> list, Context context, String str, a aVar) {
        this.a.setData(list, context, str, aVar);
    }

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        if (filpListener != null) {
            this.c = filpListener;
            this.a.setFilpListening(filpListener);
        }
    }

    public void setFrameWidth(int i) {
        this.a.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
    }
}

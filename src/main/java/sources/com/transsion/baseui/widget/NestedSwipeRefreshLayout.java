package com.transsion.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/transsion/baseui/widget/NestedSwipeRefreshLayout;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "ev", BuildConfig.FLAVOR, "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", BuildConfig.FLAVOR, "R", "I", "touchSlop", BuildConfig.FLAVOR, "S", "F", "startY", "T", "startX", "U", "Z", "isVpDragger", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NestedSwipeRefreshLayout extends SwipeRefreshLayout {
    public static final int $stable = 8;

    /* renamed from: R, reason: from kotlin metadata */
    private final int touchSlop;

    /* renamed from: S, reason: from kotlin metadata */
    private float startY;

    /* renamed from: T, reason: from kotlin metadata */
    private float startX;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isVpDragger;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.h(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.startY = ev.getY();
            this.startX = ev.getX();
            this.isVpDragger = false;
        } else if (action == 2) {
            if (this.isVpDragger) {
                return false;
            }
            float y = ev.getY();
            float abs = Math.abs(ev.getX() - this.startX);
            Math.abs(y - this.startY);
            if (abs > this.touchSlop) {
                this.isVpDragger = true;
                return false;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }
}

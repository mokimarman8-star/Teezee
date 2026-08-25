package com.transsion.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/baseui/widget/NestedHorizontalScrollableHost;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "delta", BuildConfig.FLAVOR, "a", "(F)Z", "Landroid/view/MotionEvent;", "e", BuildConfig.FLAVOR, "b", "(Landroid/view/MotionEvent;)V", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", BuildConfig.FLAVOR, "I", "touchSlop", "F", "initialX", "c", "initialY", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "child", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NestedHorizontalScrollableHost extends FrameLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: b, reason: from kotlin metadata */
    private float initialX;

    /* renamed from: c, reason: from kotlin metadata */
    private float initialY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedHorizontalScrollableHost(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedHorizontalScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final boolean a(float delta) {
        int i = -((int) Math.signum(delta));
        View child = getChild();
        if (child != null) {
            return child.canScrollHorizontally(i);
        }
        return false;
    }

    private final void b(MotionEvent e) {
        if (e.getAction() == 0) {
            this.initialX = e.getX();
            this.initialY = e.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            return;
        }
        if (e.getAction() == 2) {
            float x = e.getX() - this.initialX;
            float y = e.getY() - this.initialY;
            float abs = Math.abs(x) * 0.5f;
            float abs2 = Math.abs(y) * 1.0f;
            int i = this.touchSlop;
            if (abs > i || abs2 > i) {
                if (abs2 > abs) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else if (a(x)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Intrinsics.h(e, "e");
        b(e);
        return super.onInterceptTouchEvent(e);
    }
}
